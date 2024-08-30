import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./components/Home";
import Product from "./components/Product";
import SingleProduct from "./components/SingleProduct";
import Cart from "./components/Cart";
import AuthPage from "./components/AuthPage";
import LandingPage from "./components/LandingPage";
import Shipping from "./components/Shipping";
import Reviews from "./components/Reviews";
import ServicesPage from "./components/ServicesPage";
import Checkout from "./components/Checkout";

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LandingPage />} />
        <Route path="/home" element={<Home />} />
        <Route path="/products" element={<Product />} />
        <Route path="/product/:id" element={<SingleProduct />} />
        <Route path="/services" element={<ServicesPage />} />
        <Route path="/cart" element={<Cart />} />
        <Route path="/reviews" element={<Reviews />} />
        <Route path="/login" element={<AuthPage />} />
        <Route path="/checkout" element={<Checkout />} />
        <Route path="/shipping" element={<Shipping />} />
      </Routes>
    </Router>
  );
};

export default App;
