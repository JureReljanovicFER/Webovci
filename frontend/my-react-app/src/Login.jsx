import { FcGoogle } from "react-icons/fc";
import "./style.css";
import { useNavigate } from "react-router-dom";

function Login() {
    const navigate = useNavigate();

    return (
        <>
            <div className="body">
                <div id="login_form">
                    <h1>You need to log in</h1>
                    <button
                        onClick={() => {
                            navigate("/1");
                        }}
                    >
                        Log in with Google <FcGoogle />
                    </button>
                </div>
            </div>
        </>
    );
}

export default Login;
