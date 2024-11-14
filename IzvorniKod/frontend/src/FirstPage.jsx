import { useEffect } from "react";
import "./style.css";
import { useNavigate } from "react-router-dom";

export default function Home() {
    const navigate = useNavigate();

    useEffect(() => {
        navigate("/login");
    }, []);

    return (
        <>
            <h1>FIRST PAGE</h1>
        </>
    );
}
