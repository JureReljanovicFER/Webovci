import { useEffect } from "react";
import "./style.css";
import { useNavigate } from "react-router-dom";

export default function Home() {
    const hash = location.hash
    const navigate = useNavigate();

    useEffect(() => {
        if (hash) {
            navigate(`/login`, {state: hash});
        }
        navigate("/login");
    }, [navigate]);

    return (
        <>
            <h1>FIRST PAGE</h1>
        </>
    );
}
