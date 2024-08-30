import React, { useEffect, useState } from "react";
import { GoogleOAuthProvider, GoogleLogin } from "@react-oauth/google";
import "../assets/AuthPage.css";
import axios from "axios";
import { v4 as uuidv4 } from "uuid";

const AuthPage = () => {
  const [isLogin, setIsLogin] = useState(true);
  const [errorMessage, setErrorMessage] = useState("");
  const [showPopup, setShowPopup] = useState(false);

  // Access the backend URL from the environment variable
  const baseUrl = import.meta.env.VITE_BACK_END_URL;

  useEffect(() => {
    axios
      .get(`${baseUrl}/userlogin/`)
      .then((response) => setIsLogin(response.data))
      .catch((error) =>
        console.error("Error fetching user information:", error)
      );
  }, [baseUrl]);

  // Toggle between login and signup forms
  const toggleForm = () => {
    setIsLogin(!isLogin);
    setErrorMessage("");
  };

  // Handle form submission for login and signup
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
        // Check if email exists in DB before sign-up
        const emailCheckResponse = await axios.get(
          `${baseUrl}/userlogin/email-exists?email=${email}`
        );
        if (emailCheckResponse.data.exists) {
          throw new Error("Email already exists. Please log in.");
        }

        // Sign-up logic
        const fullName = formData.get("fullName");
        if (!fullName) {
          throw new Error("Full name is required for sign up.");
        }

        const userID = uuidv4(); // Generating a unique userID
        const userType = "customer";

        await axios.post(`${baseUrl}/userlogin/create`, {
          userID,
          fullName,
          email,
          password,
          userType,
        });

        alert("Signup successful! Please log in.");
        toggleForm(); // Switch to login form after successful signup
      } else {
        // Login logic
        const response = await axios.post(`${baseUrl}/userlogin/read`, {
          email,
          password,
        });

        if (response.status === 200) {
          setShowPopup(true); // Show popup message on successful login
        } else {
          throw new Error("Please ensure all fields are entered correctly");
        }
      }
    } catch (error) {
      setErrorMessage("Please ensure all fields are entered correctly.");
      setShowPopup(true);
    }
  };

  // Handle Google login success
  const handleGoogleLoginSuccess = (response) => {
    console.log("Google login success:", response);

    axios
      .post(`${baseUrl}/userlogin/google-login`, { token: response.credential })
      .then((res) => {
        alert("Google login successful!");
      })
      .catch((err) => {
        setErrorMessage("Google login failed. Please try again.");
        setShowPopup(true);
      });
  };

  // Handle Google login error
  const handleGoogleLoginError = (error) => {
    console.log("Google login error:", error);
    setErrorMessage("Google login failed. Please try again.");
    setShowPopup(true);
  };

  // Close the popup message
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
              {errorMessage ? <p>{errorMessage}</p> : <p>Login successful!</p>}
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
