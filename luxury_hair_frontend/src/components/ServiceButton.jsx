// src/components/ServiceButton.js
import React from "react";

const ServiceButton = ({ serviceName, onClick }) => (
  <button className="service-button" onClick={() => onClick(serviceName)}>
    {serviceName}
  </button>
);

export default ServiceButton;
