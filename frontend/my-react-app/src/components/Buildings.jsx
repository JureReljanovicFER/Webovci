import { useState, useEffect, Link } from "react";
import BuildingsChoice from "./BuildingsChoice";
import { useLocation, useNavigate } from "react-router-dom";
import { BsFillBuildingsFill } from "react-icons/bs";

export default function Buildings() {
    const [data, setData] = useState([]);
    const [user, setUser] = useState([]);
    const [loading, setLoading] = useState(true);
    const location = useLocation();
    const id = location.pathname.replace(/^\/|\/buildings$/g, "");
    const navigate = useNavigate();

    useEffect(() => {
        const fetchData = async () => {
            try {
                const res = await fetch("https://webovci.onrender.com/api/apartment-buildings/" + id);
                //const res = await fetch("http://localhost:8000/ApartmentBuildings");
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
                const res1 = await fetch("https://webovci.onrender.com/api/user/" + id);

                const user = await res1.json();
                setUser(user);
            } catch (error) {
                console.log("Error fetching data:", error);
            } finally {
                setLoading(false);
            }
        };
        fetchUser();
    }, [id, location]);

    console.log(user);

    if (loading) return <p>Loading...</p>;

    return (
        <div>
            {data.map((item) => (
                <Link key={item.id} className="odabirZgradeLink" onClick={() => navigate(`${item.id}`)} state={{ data: item }}>
                    <div className="zgrada">
                        <h1>{item.address}</h1>
                        <BsFillBuildingsFill size={200} opacity={0.5} />
                    </div>
                </Link>
            ))}
            <BuildingsChoice data={data} user={user} />
        </div>
    );
};

