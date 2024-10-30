import logo from "../assets/images/logoNav.png";

const Navbar = () => {
  return (
    <div className="navbar">
      <img src={logo}></img>
      <div className="navbar_buttons">
        <a>Home</a>
        <a>Contact</a>
        <a>About</a>
      </div>
    </div>
  );
};
export default Navbar;
