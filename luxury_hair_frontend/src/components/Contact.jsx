import React, { useState } from "react";
import "../assets/style.css";


const baseUrl = import.meta.env.VITE_BACK_END_URL;

const Subscribe = () => {
  const [email, setEmail] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const data = {
      email: email,
    };

    try {
    
      const emailExistsResponse = await fetch(
        `${baseUrl}/newsletter/email-exists?email=${encodeURIComponent(email)}`
      );

      if (emailExistsResponse.ok) {
        const emailExistsData = await emailExistsResponse.json();
        if (emailExistsData.exists) {
          alert("This email is already subscribed.");
          return; 
        }
      } else {
        alert("There was an error checking the email. Please try again.");
        return; 
      }

   
      const response = await fetch(`${baseUrl}/newsletter/create`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
      });

     
      if (response.ok) {
        alert("Thank you for subscribing!");
        setEmail(""); 
      } else {
        alert("There was an error. Please try again.");
      }
    } catch (error) {
      console.error("Error:", error);
      alert("There was a problem connecting to the server.");
    }
  };

  return (
    <section id="subscribe" className="subscribe-section">
      <div className="subscribe-container">
        <h2>Subscribe to our emails</h2>
        <p>
          Be the first to know about new collections and exclusive discounts.
        </p>
        <form className="subscribe-form" onSubmit={handleSubmit}>
          <input
            type="email"
            placeholder="Email"
            required
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <button type="submit" className="subscribe-btn">
            →
          </button>
        </form>
      </div>
    </section>
  );
};

export default Subscribe;
