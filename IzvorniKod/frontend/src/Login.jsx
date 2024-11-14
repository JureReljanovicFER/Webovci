import { FcGoogle } from "react-icons/fc";
import "./style.css";

function Login() {
    return (
        <>
            <div className="body">
                <div id="login_form">
                    <h1>You need to log in</h1>
                    <a href="https://accounts.google.com/o/oauth2/v2/auth?redirect_uri=https://webovci.onrender.com/api/oauth/login&response_type=code&client_id=442466901721-vdd38j9fev4g56mndioe14kchem2cjeu.apps.googleusercontent.com&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile+openid&access_type=offline">
                        <button>
                            Log in with Google <FcGoogle />
                        </button>
                    </a>
                </div>
            </div>
        </>
    );
}

export default Login;
