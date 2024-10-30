import { useState } from "react";
import Navbar from "./components/Navbar";
import "./Login.css";

function Login() {
  return (
    <>
        <Navbar/>
    
      <div className="body">
        <div id="login_form">
          <h1>You need to log in</h1>
          <button>Log in with Google</button>
        </div>
      </div>
    </>
  );
}

export default Login;
