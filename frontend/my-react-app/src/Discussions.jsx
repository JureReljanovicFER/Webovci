import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";

import "./style.css";

export default function Discussions() {
    const [discussions, setDiscussions] = useState([]);

    const params = useParams();

    useEffect(() => {
        const fetchDiscussions = async () => {
            try {
                const res = await fetch("https://webovci.onrender.com/api/discussions/getAll");
                const data = await res.json();

                const discussions = data.filter((discussion) => discussion.id == params.buildingId);

                setDiscussions(discussions);
            } catch (error) {
                console.log("Error fetching data:", error);
            }
        };

        fetchDiscussions();
    }, []);

    console.log(params);
    return (
        <>
            <h1>Building page {params.buildingId} Discussions</h1>

            {/* <div>
                {discussions.forEach((discussion) => {
                    discussion.visibilities.forEach((visibility) => {
                        if (visibility.appUser == params.userId) {
                            if (visibility.canUserSeeDiscussion == true) {
                                return (
                                    <div>
                                        <h3>Naslov: {discussion.title}</h3>
                                        <p>Naslov: {discussion.description}</p>
                                    </div>
                                );
                            } else {
                                <div>
                                    <h3>Naslov: Ne možete vidjeti naslov ove diskusije</h3>
                                </div>;
                            }
                        }
                    });
                })}
            </div> */}
        </>
    );
}
