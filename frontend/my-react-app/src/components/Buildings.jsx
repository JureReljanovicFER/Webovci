import { useState, useEffect } from "react";
import BuildingsChoice from "./BuildingsChoice";
import { useLocation } from "react-router-dom";
const Buildings = () => {
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);
    const location = useLocation();
    const id=location.pathname.replace(/^\/|\/buildings$/g, '')

 
    useEffect(() => {
        const fetchData = async () => {
            try {
                const res = await fetch("https://webovci.onrender.com/api/apartment-buildings/1");
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
            <BuildingsChoice data={data}/>
        </>
    );
};

export default Buildings;
