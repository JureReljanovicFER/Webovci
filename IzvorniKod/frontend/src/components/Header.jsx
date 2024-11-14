import logo from "../assets/images/logoNav.png";
import "./styles/Header.css";
import { useNavigate, useParams } from "react-router-dom";
const Navbar = () => {
    const navigate = useNavigate();
    const params = useParams();

    const shoot = () => {
        let odabir = window.confirm("Jeste li sigurni da se želite log-outat");
        if (odabir) {
            navigate("/login");
        }
    };
    return (
        <div className="navbar">
            <img src={logo}></img>
            <div className="navbar_buttons">
                <a
                    className="BuildingsHeader"
                    onClick={() => {
                        navigate(`/${params.userid}/buildings`);
                    }}
                >
                    Buildings
                </a>
                <a className="LogOutButton" onClick={shoot}>
                    Log Out
                </a>
            </div>
        </div>
    );
};
export default Navbar;
