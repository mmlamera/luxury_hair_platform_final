import React, { useState } from "react";
import ServiceButton from "./ServiceButton";
import BookingForm from "./BookingForm";
// import { createHairService } from "../services/hairServicesService";
import Navbar from "./Navbar"; 
import "../assets/hairServices.css";
import "../assets/style.css";


const services = [
  "Straightening of wigs",
  "Wig revamping",
  "Wig treatment",
  "Curling",
];

const ServicesPage = () => {
  const [selectedService, setSelectedService] = useState(null);
  const [bookingDetails, setBookingDetails] = useState(null);

  const handleServiceClick = (serviceName) => {
    setSelectedService(serviceName);
    setBookingDetails(null); 
  };

  const handleBookingSubmit = async (details) => {
    try {
      await createHairService({
        image: details.file,
        date: details.date,
        time: details.time,
        additionalNotes: details.additionalNotes,
      });
      setBookingDetails(details);
      alert(`Booking submitted successfully for ${details.service}`);
    } catch (error) {
      console.error("Error submitting booking:", error);
      alert("There was an error submitting your booking. Please try again.");
    }
  };

  return (
    <div className="services-page">
      <Navbar /> 
      <div className="content">
        <h1>Hair Services</h1>
        <div className="service-buttons">
          {services.map((service, index) => (
            <ServiceButton
              key={index}
              serviceName={service}
              onClick={handleServiceClick}
            />
          ))}
        </div>
        {selectedService && (
          <BookingForm
            selectedService={selectedService}
            onSubmit={handleBookingSubmit}
          />
        )}
        {bookingDetails && (
          <div className="booking-summary">
            <h3>Booking Summary</h3>
            <p>Service: {bookingDetails.service}</p>
            <p>Date: {bookingDetails.date}</p>
            <p>Time: {bookingDetails.time}</p>
            <p>Additional Notes: {bookingDetails.additionalNotes}</p>
            <p>File: {bookingDetails.file.name}</p>
          </div>
        )}
      </div>
     
    </div>
  );
};

export default ServicesPage;
