import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./Login.css";

function Login() {
  return (
    <>
      <div class="navbar">
        <div>logo</div>
        <a>Home</a>
        <a>Contact</a>
        <a>About us</a>
      </div>

      <div id="login_form">
        <p>You can log in using Google</p>
        <button>Login with Google</button>
      </div>
    </>
  );
}

export default Login;
