import React, { useEffect, useState } from "react";
import { GoogleOAuthProvider, GoogleLogin } from "@react-oauth/google";
import "../assets/AuthPage.css";
import axios from "axios";
import { v4 as uuidv4 } from "uuid";
import { useNavigate } from "react-router-dom";

const AuthPage = () => {
  const [isLogin, setIsLogin] = useState(true);
  const [errorMessage, setErrorMessage] = useState("");
  const [showPopup, setShowPopup] = useState(false);

  useEffect(() => {
    axios
      .get("http://localhost:8080/LuxuryHairVendingSystemDB/userlogin/")
      .then((response) => setIsLogin(response.data))
      .catch((error) =>
        console.error("Error fetching user information:", error)
      );
  }, []);

  const toggleForm = () => {
    setIsLogin(!isLogin);
    setErrorMessage("");
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    setErrorMessage("");

    try {
      const formData = new FormData(event.target);
      const email = formData.get("email");
      const password = formData.get("password");

      if (!email || !password) {
        throw new Error("Please ensure all fields are entered correctly");
      }

      if (!isLogin) {
        const emailCheckResponse = await axios.get(
          `http://localhost:8080/LuxuryHairVendingSystemDB/userlogin/email-exists?email=${email}`
        );
        if (emailCheckResponse.data.exists) {
          throw new Error("Email already exists. Please log in.");
        }

        const fullName = formData.get("fullName");
        if (!fullName) {
          throw new Error("Full name is required for sign up.");
        }

        const userID = uuidv4();
        const userType = "customer";

        await axios.post(
          "http://localhost:8080/LuxuryHairVendingSystemDB/userlogin/create",
          {
            userID,
            fullName,
            email,
            password,
            userType,
          }
        );

        alert("Signup successful! Please log in.");
        toggleForm();
      } else {
        const response = await axios.post(
          "http://localhost:8080/LuxuryHairVendingSystemDB/userlogin/read",
          {
            email,
            password,
          }
        );

        if (response.status === 200) {
          setShowPopup(true);
        } else {
          throw new Error("Invalid login credentials");
        }
      }
    } catch (error) {
      setErrorMessage(error.message);
      setShowPopup(true);
    }
  };

  const handleGoogleLoginSuccess = (response) => {
    console.log("Google login success:", response);

    axios
      .post(
        "http://localhost:8080/LuxuryHairVendingSystemDB/userlogin/google-login",
        { token: response.credential }
      )
      .then((res) => {
        alert("Google login successful!");
      })
      .catch((err) => {
        setErrorMessage("Google login failed. Please try again.");
        setShowPopup(true);
      });
  };

  const handleGoogleLoginError = (error) => {
    console.log("Google login error:", error);
    setErrorMessage("Google login failed. Please try again.");
    setShowPopup(true);
  };

  const closePopup = () => {
    setShowPopup(false);
    setErrorMessage("");
  };

  return (
    <GoogleOAuthProvider clientId="116310698020-3tjps2m44tu1vgl6nh6phvt91l0l1mf8.apps.googleusercontent.com">
      <div className="container">
        {showPopup && (
          <div className="popup">
            <div className="popup-inner">
              {errorMessage ? <p>{errorMessage}</p> : <p>Login successful!</p>}{" "}
              {/* **New Code: Popup message content** */}
              <button className="close-btn" onClick={closePopup}>
                Close
              </button>
            </div>
          </div>
        )}
        <div className="form-container">
          <h2>{isLogin ? "Login" : "Sign Up"}</h2>
          <form onSubmit={handleSubmit}>
            {!isLogin && (
              <input
                type="text"
                name="fullName"
                placeholder="Full Name"
                className="input-field"
              />
            )}
            <input
              type="email"
              name="email"
              placeholder="Email"
              className="input-field"
            />
            <input
              type="password"
              name="password"
              placeholder="Password"
              className="input-field"
            />
            <button type="submit" className="submit-btn">
              {isLogin ? "Login" : "Sign Up"}
            </button>
            <button type="button" className="toggle-btn" onClick={toggleForm}>
              {isLogin
                ? "Need an account? Sign Up"
                : "Already have an account? Login"}
            </button>
          </form>
          <div className="social-login">
            <p>Or {isLogin ? "login" : "sign up"} with:</p>
            <GoogleLogin
              onSuccess={handleGoogleLoginSuccess}
              onError={handleGoogleLoginError}
            />
          </div>
        </div>
      </div>
    </GoogleOAuthProvider>
  );
};

export default AuthPage;
