import { FcGoogle } from "react-icons/fc";
import "./style.css";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

function Login() {
    const navigate = useNavigate();
    const [showError, setShowError] = useState(false);
    const [loading, setLoading] = useState(false);

    const response = location.hash;
    let accessCode = "";

    const getAccessToken = async () => {
        if (response) {
            setLoading(true);

            accessCode = response.split("&")[0].split("#access_token=")[1];

            const res = await fetch(`https://webovci.onrender.com/api/oauth/login?token=${accessCode}`);

            if (res.ok) {
                const data = await res.json();

                if (data.id) {
                    navigate(`/${data.id}`);
                }
            } else {
                setShowError(true);
            }
            setLoading(false);
        }
    };

    useEffect(() => {
        getAccessToken();
    }, [location]);

    return (
        <>
            <div className="body">
                <div id="login_form">
                    <h1>You need to log in</h1>

                    {loading ? (
                        <p>Učitavanje ...</p>
                    ) : (
                        <a href="https://accounts.google.com/o/oauth2/v2/auth?redirect_uri=https://webovci-1.onrender.com/login&response_type=token&client_id=860876392172-7ft3es30lvo02gc4dh1b0apcsoa5oijc.apps.googleusercontent.com&scope=https://www.googleapis.com/auth/userinfo.email">
                            <button>
                                Log in with Google <FcGoogle />
                            </button>
                        </a>
                    )}

                    {showError && <p>Ovaj korisnički račun ne postoji</p>}
                </div>
            </div>
        </>
    );
}

export default Login;
