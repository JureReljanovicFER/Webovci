import { useParams } from "react-router-dom";
import "./components/styles/discussion.css";
import React, { useEffect, useState } from "react";
import Header from "./components/Header";

export default function DiscussionPage() {
  const params = useParams();
  console.log(params);

  // useEffect(() => {
  //     const fetchData = async () => {
  //         try {
  //             const res = await fetch("http://localhost:8000/Popisclanova");
  //             const data = await res.json();
  //             setData(data);
  //         } catch (error) {
  //             console.log("Error fetching data:", error);
  //         } finally {
  //             setLoading(false);
  //         }
  //     };
  //     fetchData();
  // }, []);

  //data ovdje definiran za testiranje funkcionalnosti, treba se dohvatiti sa backenda
  const [data, setData] = useState({
    title: "diskusija 1",
    description: "description of discussion",
    komentari: [
      {
        user: "JOHN",
        text: "komentar of JOHNA",
        replies: [{ user: "JOHNr", text: "reply of JOHNAr", replies: [] }],
      },
      { user: "JOHN1", text: "komentar of JOHNA1", replies: [] },
      { user: "JOHN2", text: "komentar of JOHNA2", replies: [] },
      { user: "JOHN3", text: "komentar of JOHNA3", replies: [] },
      { user: "JOHN4", text: "komentar of JOHNA4", replies: [] },
    ],
  });

  const [replyInputs, setReplyInputs] = useState({});

  const [newComment, setNewComment] = useState("");

  const handleInputChange = (index, value) => {
    setReplyInputs((prevInputs) => ({
      ...prevInputs,
      [index]: value,
    }));
  };

  const addReply = (index) => {
    const replyText = replyInputs[index];
    if (!replyText) return;

    setData((prevData) => {
      const newComments = [...prevData.komentari];

      if (
        newComments[index].replies.some(
          (reply) => reply.text === replyText && reply.user === "NewUser"
        )
      ) {
        return prevData;
      }

      newComments[index].replies.push({
        user: "NewUser",
        text: replyText,
        replies: [],
      });

      return { ...prevData, komentari: newComments };
    });

    setReplyInputs((prevInputs) => ({
      ...prevInputs,
      [index]: "",
    }));
  };

  const addComment = () => {
    if (!newComment.trim()) return;

    setData((prevData) => ({
      ...prevData,
      komentari: [
        ...prevData.komentari,
        { user: "NewUser", text: newComment, replies: [] },
      ],
    }));

    setNewComment("");
  };

  return (
    <>
      <h1 className="discussion_title">{data.title}</h1>
      <p>{data.description}</p>
      <div className="discussion_container">
        <h3 className="discussion_title">Komentari</h3>
        {data.komentari.map((comment, index) => (
          <div key={index} className="discussion_comment">
            <div className = "comment_contents">
              <p>
                <strong>{comment.user}:</strong> {comment.text}
              </p>
            </div>
            <hr></hr>
            {comment.replies.length > 0 && (
              <div className="replies_container">
                {comment.replies.map((reply, replyIndex) => (
                  <div key={replyIndex} className="discussion_reply">
                    <p>
                      <strong>{reply.user}:</strong> {reply.text}
                    </p>
                  </div>
                ))}
              </div>
            )}

            <div className="reply_input">
              <input
                type="text"
                value={replyInputs[index] || ""}
                onChange={(e) => handleInputChange(index, e.target.value)}
                placeholder="Type your reply here..."
              />
              <button onClick={() => addReply(index)} className="discussion_btn2">Reply</button>
            </div>
          </div>
        ))}
      </div>
      <div className="discussion_footer">
        <div className="comment_input">
          <input
            type="text"
            value={newComment}
            onChange={(e) => setNewComment(e.target.value)}
            placeholder="Type your comment here..."
          />
          <button onClick={addComment} className="discussion_btn">
            Add comment
          </button>
        </div>
      </div>
    </>
  );
}
