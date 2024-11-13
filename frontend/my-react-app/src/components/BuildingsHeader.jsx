import { useNavigate } from "react-router-dom";
const BuildingsHeader = () => {
    const navigate = useNavigate();
    const shoot = () => {
        let odabir = window.confirm("Jeste li sigurni da se želite log-outat");
        if (odabir) {
            navigate("/login");
        }
    };

    return (
        <div className="header">
            <h1>StanBlog</h1>
            <button onClick={shoot} className="botun">
                Odjavi se
            </button>
        </div>
    );
};

export default BuildingsHeader;
