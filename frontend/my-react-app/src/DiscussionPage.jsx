import { useParams } from "react-router-dom";
import Navbar from "./components/Navbar";

export default function DiscussionPage() {
  const params = useParams();
  console.log(params);
  return (
    <>
      <Navbar />
      <h1>
        Building page {params.buildingId} Disscussion {params.discussionId}
      </h1>
    </>
  );
}
