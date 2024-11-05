import logo from "../assets/images/logoNav.png";

const Navbar = () => {
  return (
    <div className="navbar">
      <img src={logo}></img>
      <div className="navbar_buttons">
        <a
          onClick={() => {
            window.location.href = "/";
          }}
        >
          Home
        </a>
        <a
          onClick={() => {
            window.location.href = "/buildings";
          }}
        >
          Buildings
        </a>
        <a>About</a>
      </div>
    </div>
  );
};
export default Navbar;
