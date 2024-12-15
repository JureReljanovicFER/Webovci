import { useParams } from "react-router-dom";
import "./components/styles/discussion.css";

export default function DiscussionPage() {
  const params = useParams();
  console.log(params);
  return (
    <>
        <h1 class="discussion_title">Title</h1>
        <p>opis</p>
      <div class="discussion_container"></div>
      <div class="discussion_footer">
        <button class="discussion_btn">Dodaj komentar</button>
      </div>
    </>
  );
}
