import { useParams } from "react-router-dom";
import "./components/styles/discussion.css";
import React, { useEffect, useState } from "react";
import Header from "./components/Header";

export default function DiscussionPage() {
  const params = useParams();
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);

  const fetchData = async () => {
    try {
      const res = await fetch(
        `https://webovci.onrender.com/api/discussions/${params.discussionId}`
      );
      // const text = await res.text(); // Get the response as text (before parsing as JSON)
      // console.log("Raw response text:", text);
      const data = (await res.json()).data;
      setData(data);
      console.log(data);
    } catch (error) {
      console.log("Error fetching data:", error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchData();
  }, [params.discussionId]);

  // const [replyInputs, setReplyInputs] = useState({});
  const [newComment, setNewComment] = useState("");
  // const [content, setContent] = useState("");

  // const handleInputChange = (index, value) => {
  //   setReplyInputs((prevInputs) => ({
  //     ...prevInputs,
  //     [index]: value,
  //   }));
  // };

  const addComment = async () => {
    if (!newComment.trim()) return;

    try {
      const userResponse = await fetch(
        `https://webovci.onrender.com/api/user/${params.userid}`
      );

      if (!userResponse.ok) {
        throw new Error("Failed to fetch user data");
      }

      const userData = await userResponse.json();

      const comment = {
        userId: params.userid,
        discussionId: params.discussionId,
        content: newComment,
      };

      console.log(comment);

      const response = await fetch(
        "https://webovci.onrender.com/api/comments/",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(comment),
        }
      );

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const result = await response.json();
      await fetchData();
      setNewComment("");
    } catch (error) {
      console.error("Error adding comment:", error);
    }

    //setNewComment("");
  };

  const addVotePos = async () => {
    const vote = {
      userId: params.userid,
      answerPozitive: true,
    };
    console.log(vote);
    console.log(data.voting);
    try {
      const response = await fetch(
        `https://webovci.onrender.com/api/voting/${data.voting.id}`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(vote),
        }
      );
      if (response.ok) {
        alert("Uspjesno glasanje");
      } else {
        throw new Error(response.status);
      }
      const result = await response.json();
      await fetchData();
    } catch (error) {
      alert(`Greška: ${error.message}`);
    }
  };

  const addVoteNeg = async () => {
    const vote = {
      userId: params.userid,
      answerPozitive: false,
    };
    console.log(vote);
    try {
      const response = await fetch(
        `https://webovci.onrender.com/api/voting/${data.voting.id}`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(vote),
        }
      );
      if (response.ok) {
        alert("Uspjesno glasanje");
      } else {
        throw new Error(response.status);
      }
      const result = await response.json();
      console.log(result);
      await fetchData();
    } catch (error) {
      alert(`Greška: ${error.message}`);
    }
  };

  const addVoting = async () => {
    let votingTitle = prompt("Unesite naslov glasanja:", "naslov");
    let pozitiveAnsLabel = "Slazem se";
    let negativeAnsLabel = "Ne slazem se";
    let dissId = params.discussionId;
    let usId = params.userId;
    //let votingId = data.voting.id;
    if (votingTitle == null || votingTitle == "") {
      alert("Morate unijeti naslov");
      return;
    }

    const votingData = {
      title: votingTitle,
      pozitiveAnswerLabel: pozitiveAnsLabel,
      negativeAnswerLabel: negativeAnsLabel,
      discussionId: dissId,
    };

    console.log(votingData);

    try {
      const response = await fetch(
        "https://webovci.onrender.com/api/voting/new",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(votingData),
        }
      );
      const result = await response.json();

      if (response.ok) {
        alert("Glasanje kreirano");
      } else {
        throw new Error(result.message);
      }
    } catch (error) {
      alert(`Greška: ${error.message}`);
    }
  };

  if (loading) {
    return <div>Loading...</div>;
  }

  if (!data) {
    return <div>Error: Failed to load discussion data</div>;
  }

  let totalVotesFor = 0;
  let totalVotesAgainst = 0;

  if (data.userVotngs) {
    totalVotesFor = data.userVotngs.filter(
      (vote) => !vote.answerPositive
    ).length;
    totalVotesAgainst = data.userVotngs.filter(
      (vote) => vote.answerPositive
    ).length;
  }

  return (
    <>
      <h1 className="discussion_title">{data.title}</h1>
      <p>{data.description}</p>
      <div className="discussion_container">
        <h3 className="discussion_title">Glasanje</h3>

        {data.voting != null ? (
          <div className="poll">
            <h4>{data.voting.title}</h4>
            <hr></hr>
            <p>Votes for: {totalVotesFor}</p>
            <p>Votes against: {totalVotesAgainst}</p>

            {data.userVotngs.map((vote, index) => (
              <div key={index} className="votes">
                <p>
                  {vote.userId + ":"} + {vote.answerPositive}
                </p>
              </div>
            ))}

            <hr></hr>
            <button className="discussion_btn2" onClick={addVotePos}>
              {data.voting.pozitiveAnswerLabel}
            </button>
            <button className="discussion_btn2" onClick={addVoteNeg}>
              {data.voting.negativeAnswerLabel}
            </button>
          </div>
        ) : (
          <p>Još nema kreiranog glasanja</p>
        )}
        <h3 className="discussion_title">Komentari</h3>
        {data.comments ? (
          <div>
            {data.comments.map((comment, index) => (
              <div key={index} className="discussion_comment">
                <div className="comment_contents">
                  <p>
                    <strong>
                      {comment.author.firstName + " " + comment.author.lastName}
                      :
                    </strong>{" "}
                    {comment.content}
                  </p>
                </div>
              </div>
            ))}
          </div>
        ) : (
          <p>Još nema komentara</p>
        )}
      </div>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <div className="discussion_footer">
        <div className="comment_input">
          <input
            type="content"
            value={newComment}
            onChange={(e) => setNewComment(e.target.value)}
            placeholder="Ovdje napišite komentar..."
          />
          <button onClick={addComment} className="discussion_btn">
            Dodaj komentar
          </button>
          <button onClick={addVoting} className="discussion_btn">
            Dodaj glasanje
          </button>
          <button className="discussion_btn">Započni sastanak</button>
        </div>
      </div>
    </>
  );
}
