import { useState } from "react";
import Navbar from "./components/Navbar";
import { FcGoogle } from "react-icons/fc";
import "./style.css";

function Login() {
  return (
    <>
      

      <div className="body">
        <div id="login_form">
          <h1>You need to log in</h1>
          <button>Log in with Google  <FcGoogle /></button>
        
        </div>
      </div>
    </>
  );
}

export default Login;
