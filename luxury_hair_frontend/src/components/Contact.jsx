import React, { useState } from "react";
import "../assets/style.css";

const Subscribe = () => {
  const [email, setEmail] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Prepare the data to be sent to the server
    const data = {
      email: email, 
    };

    try {
      // Send POST request to the server
      const response = await fetch(
        "http://localhost:8080/LuxuryHairVendingSystemDB3/customer/create",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(data),
        }
      );

      // handle the response
      if (response.ok) {
        alert("Thank you for subscribing!");
        setEmail(""); // i clear the input field after successful submission
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
