import React, { useState, useEffect } from "react";

import BuildingsChoice from "./BuildingsChoice";
import Header from "./Header";
const Buildings = () => {
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const res = await fetch("http://localhost:8000/ApartmentBuildings");
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

    if (loading) return <p>Loading...</p>;

    return (
        <>
            <BuildingsChoice data={data} />
        </>
    );
};

export default Buildings;
