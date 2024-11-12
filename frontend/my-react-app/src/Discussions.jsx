import { useParams } from "react-router-dom";

import "./style.css";

export default function Discussions() {
    const params = useParams();
    console.log(params);
    return (
        <>
            <h1>Building page {params.buildingId} Discussions</h1>
        </>
    );
}
