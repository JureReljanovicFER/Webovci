import { useParams } from "react-router-dom";
import Navbar from "./components/Navbar";
import Layout from "./components/Layout"

export default function DiscussionPage() {
  const params = useParams();
  console.log(params);
  return (
    <>
      <Navbar />
      <h1>
        Building page {params.buildingId} Disscussion {params.discussionId}
      </h1>
      <Layout/>
    </>
  );
}
