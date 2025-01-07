import { useParams } from "react-router-dom";
import "./components/styles/discussion.css";
import React, { useEffect, useState } from "react";
import Header from "./components/Header";

export default function DiscussionPage() {
  const params = useParams();
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const res = await fetch(`https://webovci.onrender.com/api/discussions/${params.discussionId}`);
        const data = await res.json();
        setData(data);
      } catch (error) {
        console.log("Error fetching data:", error);
      } finally {
        setLoading(false);
      }
    };
    fetchData();
  }, [params.discussionId]);

  // Always call hooks before conditional rendering
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

  const addComment = async() => {
    if (!newComment.trim()) return;
  //   try {
  //     const response = await fetch('https://webovci.onrender.com/api/comments', {
  //         method: "POST",
  //         headers: {
  //             "Content-Type": "application/json",
  //         },
  //         body: JSON.stringify(newComment),
  //     });
  //     setContent("");
  //     if (!response.ok) {
  //         throw new Error(`HTTP error! status: ${response.status}`);
  //     }
  //     const result = await response.json();
  // } catch (error) {
  //     console.error("Error:", error);
  // }
    setData((prevData) => ({
      ...prevData,
      comments: [
        ...prevData.comments,
        { author: "NewUser", content: newComment, },
      ],
    }));

    setNewComment("");
  };

  // Ensure that loading is checked after all hooks
  if (loading) {
    return <div>Loading...</div>;
  }

  // Avoid rendering when data is still null or not fetched yet
  if (!data) {
    return <div>Error: Failed to load discussion data</div>;
  }

  return (
    <>
      <h1 className="discussion_title">{data.title}</h1>
      <p>{data.description}</p>
      <div className="discussion_container">
        {/* <h3 className="discussion_title">Polls</h3> */}
        
        <h3 className="discussion_title">Comments</h3>
        {data.comments.map((comment, index) => (
          <div key={index} className="discussion_comment">
            <div className="comment_contents">
              <p>
                <strong>{comment.author.firstName + " " + comment.author.lastName}:</strong> {comment.content}
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
            Add comment
          </button>
        </div>
      </div>
    </>
  );
}
