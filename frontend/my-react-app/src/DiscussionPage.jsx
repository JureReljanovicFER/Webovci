import { useParams } from "react-router-dom";
import "./components/styles/discussion.css";
import { useEffect, useRef, useState } from "react";

export default function DiscussionPage() {
  const params = useParams();
  console.log(params);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const res = await fetch("http://localhost:8000/Diskusija");
        const data = await res.json();
        setData(data);
      } catch (error) {
        console.log("Error fetching data:", error);
      } finally {
        setLoading(false);
      }
    };
    fetchData();
  }, []);

  const data1 = {
    //za potrebe testiranja stranice, kasnije se treba obrisati, a u returnu data1 zamijeniti sa data
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
  };

  return (
    //data1 se treba zamijeniti sa data
    <>
      <h1 class="discussion_title">{data1.title}</h1>
      <p>{data1.title}</p>
      <div class="discussion_container">
        {data1.komentari.map((comment, index) => (
          <div key={index} className="discussion_comment">
            <p>
              <strong>{comment.user}:</strong> {comment.text}
            </p>
            {comment.replies.length > 0 && (
              <div className="replies_container">
                {comment.replies.map((reply, replyIndex) => (
                  <div key={replyIndex} className="reply">
                    <p>
                      <strong>{reply.user}:</strong> {reply.text}
                    </p>
                  </div>
                ))}
              </div>
            )}
            <button>Reply</button>
          </div>
        ))}
      </div>
      <div class="discussion_footer">
        <button class="discussion_btn">Dodaj komentar</button>
      </div>
    </>
  );
}
