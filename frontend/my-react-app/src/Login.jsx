import { useState } from "react";
import logo from "/logoNav.png";
import "./Login.css";

function Login() {
  return (
    <>
      <div class="navbar">
        <img src={logo}></img>
        <div class="navbar_buttons">
          <a>Home</a>
          <a>Contact</a>
          <a>About</a>
        </div>
      </div>
      <div class="body">
        <div id="login_form">
          <h1>You need to log in</h1>
          <button>Log in with Google</button>
        </div>
      </div>
    </>
  );
}

export default Login;
