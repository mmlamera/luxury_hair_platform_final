import React, { useEffect, useState } from "react";
import {NavLink, useLocation, useNavigate} from "react-router-dom";
import "../assets/style.css";
import "../assets/AuthPage.css";

const Navbar = () => {
  const [cartItemsCount, setCartItemsCount] = useState(0);
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [,setRedirectPath ] = useState('/');
  useNavigate();
  const location = useLocation();

  useEffect(() => {
    const cart = localStorage.getItem("cart");
    if (cart) {
      const cartItems = JSON.parse(cart);
      const totalItems = cartItems.reduce(
          (total, item) => total + item.quantity,
          0
      );
      setCartItemsCount(totalItems);
    }
    const loginStatus = localStorage.getItem("isLogin");
    setIsLoggedIn(!!loginStatus);

    setRedirectPath(location.pathname);
  }, [location.pathname]);
  const Logout = () => {
    window.localStorage.removeItem("isLogin");
    window.location.reload();
    alert("Logout Successful");

  }

  return (
    <nav>
      <h1>Luxury Hair</h1>
      <ul>
        <li>
          <NavLink to="/">Home</NavLink>
        </li>
        <li>
          <NavLink to="/products">Products</NavLink>
        </li>
        <li>
          <NavLink to="/services">Services</NavLink>
        </li>
        <li>
          <NavLink to="/cart">
            Cart <span>({cartItemsCount})</span>
          </NavLink>
        </li>
        <li>
          <NavLink to="/reviews">Reviews</NavLink>
        </li>
        {isLoggedIn ? (
            <li>
              <NavLink to="/" onClick={Logout}>Logout</NavLink>
            </li>
        ) : (
            <li>
              <NavLink to="/login">Login</NavLink>
            </li>
        )}
      </ul>
    </nav>
  );
};

export default Navbar;
