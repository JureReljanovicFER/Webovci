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
      const data = await res.json();
      setData(data);
    } catch (error) {
      console.log("Error fetching data:", error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchData();
  }, [params.discussionId]);

  const [replyInputs, setReplyInputs] = useState({});
  const [newComment, setNewComment] = useState("");
  const [content, setContent] = useState("");

  const handleInputChange = (index, value) => {
    setReplyInputs((prevInputs) => ({
      ...prevInputs,
      [index]: value,
    }));
  };

  const addReply = (index) => {
    const replycontent = replyInputs[index];
    if (!replycontent) return;

    setData((prevData) => {
      const newComments = [...prevData.comments];

      // if (
      //   newComments[index].replies.some(
      //     (reply) => reply.content === replycontent && reply.user === "NewUser"
      //   )
      // ) {
      //   return prevData;
      // }

      // newComments[index].replies.push({
      //   user: "NewUser",
      //   content: replycontent,
      //   replies: [],
      // });

      return { ...prevData, comments: newComments };
    });

    setReplyInputs((prevInputs) => ({
      ...prevInputs,
      [index]: "",
    }));
  };

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

      console.log(comment)

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

      await fetchData()
      // setData((prevData) => ({
      //   ...prevData,
      //   comments: [
      //     ...prevData.comments,
      //     result,
      //     { author: `${comment.author.firstName}`, content: newComment },
      //   ], ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////jel ovo doooooooobrooooooooooooooooooooooooooooooooooooooooooooooooooooo
      // }));

      setNewComment("");
    } catch (error) {
      console.error("Error adding comment:", error);
    }

    // // https://webovci.onrender.com/api/user/:id
    // // params.userid
    // //   try {
    // //     const response = await fetch('https://webovci.onrender.com/api/comments', {
    // //         method: "POST",
    // //         headers: {
    // //             "Content-Type": "application/json",
    // //         },
    // //         body: JSON.stringify(newComment),
    // //     });
    // //     setContent("");
    // //     if (!response.ok) {
    // //         throw new Error(`HTTP error! status: ${response.status}`);
    // //     }
    // //     const result = await response.json();
    // // } catch (error) {
    // //     console.error("Error:", error);
    // // }
    // setData((prevData) => ({
    //   ...prevData,
    //   comments: [
    //     ...prevData.comments,
    //     { author: "d", content: newComment },
    //   ],
    // }));

    setNewComment("");
  };

  const addVotePos = async () => {
    const vote = {
      userId: params.userid,
      answerPositive: true,
    };
    try {
      const response = await fetch(
        "https://webovci.onrender.com/api/voting/%7Bid%7D",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(vote),
        }
      );
      const result = await response.json();

      if (response.ok) {
        alert("Uspjesno glasanje");
      } else {
        throw new Error(result.message);
      }
    } catch (error) {
      alert(`Greška: ${error.message}`);
    }
  };

  const addVoteNeg = async () => {
    const vote = {
      userId: params.userid,
      answerPositive: false,
    };
    try {
      const response = await fetch(
        "https://webovci.onrender.com/api/voting/%7Bid%7D",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(vote),
        }
      );
      const result = await response.json();

      if (response.ok) {
        alert("Uspjesno glasanje");
      } else {
        throw new Error(result.message);
      }
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
    if (votingTitle == null || votingTitle == "") {
      alert("Morate unijeti naslov");
      return;
    }

    const votingData = {
      title: votingTitle,
      pozitiveAnswerLabel: pozitiveAnsLabel,
      negativeAnswerLabel: negativeAnsLabel,
      discussionId: params.discussionId,
    };

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

  const totalVotesFor = data.userVotngs.filter(
    (vote) => vote.answerPositive
  ).length;
  const totalVotesAgainst = data.userVotngs.filter(
    (vote) => !vote.answerPositive
  ).length;

  return (
    <>
      <h1 className="discussion_title">{data.title}</h1>
      <p>{data.description}</p>
      <div className="discussion_container">
        <h3 className="discussion_title">Poll</h3>
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
        <h3 className="discussion_title">Comments</h3>
        {data.comments.map((comment, index) => (
          <div key={index} className="discussion_comment">
            <div className="comment_contents">
              <p>
                <strong>
                  {comment.author.firstName + " " + comment.author.lastName}:
                </strong>{" "}
                {comment.content}
              </p>
            </div>
          </div>
        ))}
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
            placeholder="Type your comment here..."
          />
          <button onClick={addComment} className="discussion_btn">
            Dodaj komentar
          </button>
          <button onClick={addVoting} className="discussion_btn">
            Dodaj glasanje
          </button>
        </div>
      </div>
    </>
  );
}
