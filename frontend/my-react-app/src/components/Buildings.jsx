import { useState, useEffect } from "react";
import BuildingsChoice from "./BuildingsChoice";
import { useLocation } from "react-router-dom";
const Buildings = () => {
    const [data, setData] = useState([]);
    const[user,setUser]=useState([]);
    const [loading, setLoading] = useState(true);
    const location = useLocation();
    const id=location.pathname.replace(/^\/|\/buildings$/g, '')

 
    useEffect(() => {
        const fetchData = async () => {
            try {
                const res = await fetch("https://webovci.onrender.com/api/apartment-buildings/"+id);
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

    useEffect(() => {
        const fetchUser = async () => {
            try {
                const res1 = await fetch("https://webovci.onrender.com/api/users/"+id);
                const user = await res1.json();
                setUser(user);
            } catch (error) {
                console.log("Error fetching data:", error);
            } finally {
                setLoading(false);
            }
        };
        fetchUser();
    }, []);

    console.log(user);

    if (loading) return <p>Loading...</p>;

    return (
        <>
            <BuildingsChoice data={data} user={user}/>
        </>
    );
};

export default Buildings;
