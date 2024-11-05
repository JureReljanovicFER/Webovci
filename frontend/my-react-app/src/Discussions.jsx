import Navbar from "./components/Navbar";
import {useParams} from "react-router-dom";
import Layout from "./components/Layout"
import "./style.css";


export default function Discussions() {
  const params = useParams();
  console.log(params);
  return (
    <>
      <Navbar />
      <h1>Building page {params.buildingId} Discussions</h1>
      <Layout/>
    </>
  );
}