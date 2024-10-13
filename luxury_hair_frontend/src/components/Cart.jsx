import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";
import Navbar from "../components/Navbar"; 
import Footer from "../components/Footer"; 

const Cart = () => {
  const [cartItems, setCartItems] = useState([]);
  const navigate = useNavigate(); 


  useEffect(() => {
    const cart = localStorage.getItem("cart");
    if (cart) {
      setCartItems(JSON.parse(cart));
    }
  }, []);


  const calculateTotalPrice = () => {
    return cartItems.reduce(
      (total, item) => total + item.hairPrice * item.quantity,
      0
    );
  };

  const handleRemoveItem = (productId, selectedLength, selectedColor, selectedStyle) => {
    // Find the item to remove or update in the cart
    const itemToRemove = cartItems.find(item =>
      item.productId === productId &&
      item.selectedLength === selectedLength &&
      item.selectedColor === selectedColor &&
      item.selectedStyle === selectedStyle
    );
  
    if (itemToRemove) {
     if (itemToRemove) {
    console.log("Item to remove:", itemToRemove);

    // If quantity > 1, update the quantity in the backend
    if (itemToRemove.quantity > 1) {
      axios
        .put(`http://localhost:8080/LuxuryHairVendingSystemDB/cart/update/${itemToRemove.cartId}?newQuantity=${itemToRemove.quantity - 1}`, {
          newQuantity: itemToRemove.quantity - 1 }, // payload
          { headers: { 'Content-Type': 'application/json' }  // Reduce by 1
        })
        .then(response => {
          console.log("Backend update response:", response.data);
    
          // Update the local cart items after the backend update
          const updatedCart = cartItems.map(item =>
            item.cartId === itemToRemove.cartId
              ? { ...item, quantity: item.quantity - 1 }  // Reduce quantity locally
              : item
          );
    
          // Save the updated cart in localStorage
          setCartItems(updatedCart);
          localStorage.setItem("cart", JSON.stringify(updatedCart));
          console.log("Cart updated successfully:", response.data);
        })
        .catch(error => {
          console.error("There was an error updating the cart!");
          console.error("Error details:", error.response ? error.response.data : error);
        });
    }
      else {
        // If quantity = 1, remove the item from the backend
        axios
          .delete(`http://localhost:8080/LuxuryHairVendingSystemDB/cart/delete/${itemToRemove.cartId}`)
          .then(response => {
            // Remove the item from the local cart
            const updatedCart = cartItems.filter(item => item.cartId !== itemToRemove.cartId);
  
            // Save the updated cart in localStorage
            setCartItems(updatedCart);
            localStorage.setItem("cart", JSON.stringify(updatedCart));
            console.log("Item removed from cart successfully:", response.data);
          })
          .catch(error => {
            console.error("There was an error removing the item from the cart!", error);
          });
      }
    }
  }};
  
  

  const handleCheckout = () => {
   
    const cartData = {
      userId: 1, 
      products: cartItems.map((item) => ({
        productId: item.productId,
        quantity: item.quantity,
      })), 
    };  navigate("/login");

    // Send the cart data to the backend
    axios
      .post(
        "http://localhost:8080/LuxuryHairVendingSystemDB/cart/create",
        cartData
      )
      .then((response) => {
        console.log("Cart saved successfully:", response.data);
        
        localStorage.removeItem("cart");
        setCartItems([]);
        
      })
      .catch((error) => {
        console.error("There was an error saving the cart!", error);
      });
  };

  if (cartItems.length === 0) {
    return (
      <>
        <Navbar /> 
        <div className="flex flex-col items-center mt-10">
          <h2 className="text-2xl font-semibold text-black mb-4">
            Your Cart is Empty
          </h2>
          <Link to="/products" className="text-lg text-black hover:underline">
            Continue Shopping
          </Link>
        </div>
        <Footer /> 
      </>
    );
  }

  return (
    <>
      <Navbar /> 
      <div className="max-w-5xl mx-auto mt-4">
        <h2 className="text-3xl font-bold mb-6 text-center text-black">
          Your Cart
        </h2>
        <table className="min-w-full bg-white text-black border border-black rounded-lg shadow-lg overflow-hidden">
          <thead className="bg-black text-white">
            <tr>
              <th className="p-4 text-left">Product</th>
              <th className="p-4 text-left">Length</th>
              <th className="p-4 text-left">Color</th>
              <th className="p-4 text-left">Style</th>
              <th className="p-4 text-left">Quantity</th>
              <th className="p-4 text-left">Price</th>
              <th className="p-4 text-left">Remove</th>
            </tr>
          </thead>
          <tbody>
            {cartItems.map((item, index) => (
              <tr key={index} className="border-b border-black">
                <td className="p-4">{item.hairStyle}</td>
                <td className="p-4">{item.selectedLength}</td>
                <td className="p-4">{item.selectedColor}</td>
                <td className="p-4">{item.selectedStyle}</td>
                <td className="p-4">{item.quantity}</td>
                <td className="p-4">R{item.hairPrice * item.quantity}</td>
                <td className="p-4">
    <button
        onClick={() =>
            handleRemoveItem(
                item.productId,
                item.selectedLength,
                item.selectedColor,
                item.selectedStyle,
                item.quantity // Pass the quantity
            )
        }
        className="bg-black text-white px-3 py-1 rounded hover:bg-gray-800 transition"
    >
        Remove
    </button>
</td>
              </tr>
            ))}
          </tbody>
        </table>

        <div className="mt-6 flex justify-between items-center">
          <div>
            <Link to="/products" className="text-black hover:underline text-lg">
              Continue Shopping
            </Link>
          </div>
          <div className="text-xl font-semibold text-black">
            Total: R{calculateTotalPrice()}
          </div>
          <div>
            <button
              onClick={handleCheckout} 
              className="bg-black text-white px-6 py-2 rounded hover:bg-gray-800 transition"
            >
              Checkout
            </button>
          </div>
        </div>
      </div>
      <Footer /> 
    </>
  );
};

export default Cart;
