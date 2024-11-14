import { useParams } from "react-router-dom";

export default function DiscussionPage() {
    const params = useParams();
    console.log(params);
    return (
        <>
            <h1>
                Building page {params.buildingId} Disscussion {params.discussionId}
            </h1>
        </>
    );
}
