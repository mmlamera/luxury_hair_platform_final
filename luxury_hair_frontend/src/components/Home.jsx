import React from "react";
import Navbar from "./Navbar.jsx";
import Hero from "./Hero.jsx";
import Products from "./FeaturedProducts.jsx";
import Services from "./Services.jsx";
import Product from "./Product.jsx";
import Contact from "./Contact.jsx";
import Footer from "./Footer";

const Home = () => {
  return (
    <>
      <Navbar />
      <Hero />
      <Products />
      <Services />
      <Contact />
      <Footer />
    </>
  );
};

export default Home;
