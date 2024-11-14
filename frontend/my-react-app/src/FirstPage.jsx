import { useEffect } from "react";
import "./style.css";
import { useNavigate } from "react-router-dom";

function FirstPage() {
    const navigate = useNavigate();
    const hash = location.hash;

    useEffect(() => {
        console.log(hash);
        if (hash) {
            navigate(`/login`, { state: hash });
        } else {
            navigate("/login");
        }
    }, [hash, navigate]);

    return (
        <div>
            <h1>FIRST PAGE</h1>
        </div>
    );
}

export default FirstPage;
