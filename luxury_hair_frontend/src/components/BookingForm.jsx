import React, { useState } from "react";

// eslint-disable-next-line react/prop-types
const BookingForm = ({ selectedService, onSubmit }) => {
  const [details, setDetails] = useState({
    date: "",
    time: "",
    file: null,
    additionalNotes: "",
  });

  const handleChange = (e) => {
    const { name, value, files } = e.target;
    setDetails({
      ...details,
      [name]: files ? files[0] : value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit({ ...details, service: selectedService });
  };

  return (
    <div className="booking-form-container">
      <h2>{`Booking for ${selectedService}`}</h2>
      <form className="booking-form" onSubmit={handleSubmit}>
        <label>
          Booking Date:
          <input
            type="date"
            name="date"
            value={details.date}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          <input
            type="time"
            name="time"
            value={details.time}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Picture of your weave before:
          <input type="file" name="file" onChange={handleChange} required />
        </label>
        <label>
          Leave any comment:
          <input
            type="text"
            name="additionalNotes"
            value={details.additionalNotes}
            onChange={handleChange}
          />
        </label>
        <button type="submit">Submit Booking</button>
      </form>
    </div>
  );
};

export default BookingForm;
