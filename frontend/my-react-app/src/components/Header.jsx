import logo from "../assets/images/logoNav.png";
import "./Header.css"
const Navbar = () => {
  const shoot = () => {
    let odabir=window.confirm("Jeste li sigurni da se želite log-outat");
    if(odabir){
      window.location.href=`/login`
    }
    else{}
  }
  return (
    <div className="navbar">
      <img src={logo}></img>
      <div className="navbar_buttons">
        <a className="BuildingsHeader"
          onClick={() => {
            window.location.href = "/buildings";
          }}
        >
          Buildings
        </a>
        <a className="LogOutButton"
        onClick={shoot}
        >Log Out</a>
      </div>
    </div>
  );
};
export default Navbar;
