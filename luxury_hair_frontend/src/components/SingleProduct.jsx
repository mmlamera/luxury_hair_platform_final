import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import Navbar from "../components/Navbar";
import "../main.css";
import "../assets/singleProduct.css";

const SingleProduct = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [product, setProduct] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [selectedLength, setSelectedLength] = useState("12 inches");
  const [selectedColor, setSelectedColor] = useState("Black");
  const [selectedStyle, setSelectedStyle] = useState("Customized");
  const [quantity, setQuantity] = useState(1);

  useEffect(() => {
    const baseUrl = import.meta.env.VITE_BACK_END_URL;

    fetch(`${baseUrl}/product/read/${id}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        setProduct(data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("There was an error fetching the product:", error);
        setError(error);
        setLoading(false);
      });
  }, [id]);

  const handleAddToCart = () => {
    const cartProduct = {
      productId: product.productId,
      hairStyle: product.hairStyle,
      hairPrice: product.hairPrice,
      selectedLength,
      selectedColor,
      selectedStyle,
      quantity,
      image: product.image,
    };
  
    // Get the userId from localStorage
    const userId = localStorage.getItem("userId"); // Assuming "userId" is stored in localStorage
  
    // Check if userId exists
    if (!userId) {
      alert("You need to be logged in to add items to the cart.");
      return;
    }
  
    // Prepare the cartRequest object with user and product objects
    const cartRequest = {
      product: {
        productId: product.productId,         // Product ID
        hairStyle: product.hairStyle,         // Product hairstyle
        hairPrice: product.hairPrice,         // Product price
        hairTexture: product.hairTexture,     // Product texture
        hairSize: product.hairSize,           // Product size
        hairColor: product.hairColor,         // Product color
        hairStock: product.hairStock,         // Product stock
        image: product.image,                 // Product image
      },
      user: {
        userId: userId,                       // User ID from localStorage
      },
      quantity: quantity,                    // Quantity selected by user
    };
  
    const baseUrl = import.meta.env.VITE_BACK_END_URL;
  
    // Make the POST request to the backend
    fetch(`${baseUrl}/cart/add`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(cartRequest),     // Send the JSON object
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to add product to cart");
        }
        return response.json();
      })
      .then((data) => {
        // Backend returns cartId (assumed)
        const { cartId } = data;
  
        if (cartId) {
          // Add product with cartId to localStorage
          let cart = localStorage.getItem("cart");
          cart = cart ? JSON.parse(cart) : [];
  
          const productIndex = cart.findIndex(
            (item) =>
              item.productId === cartProduct.productId &&
              item.selectedLength === cartProduct.selectedLength &&
              item.selectedColor === cartProduct.selectedColor &&
              item.selectedStyle === cartProduct.selectedStyle
          );
  
          if (productIndex >= 0) {
            cart[productIndex].quantity += cartProduct.quantity;
          } else {
            // Add cartId to the product in localStorage
            cart.push({
              ...cartProduct,
              cartId: cartId,  // Add cartId received from the backend
            });
          }
  
          // Save updated cart in localStorage
          localStorage.setItem("cart", JSON.stringify(cart));
  
          alert("Product added to cart!");
          console.log("Product added to cart:", data);
        } else {
          throw new Error("No cartId received from the backend");
        }
      })
      .catch((error) => {
        console.error("Error adding product to cart:", error);
        alert("There was an error adding the product to the cart.");
      });
  };
  

  const handleBuyNow = () => {
    navigate("/cart");
  };

  if (loading) {
    return <p>Loading product...</p>;
  }

  if (error) {
    return <p>There was an error loading the product: {error.message}</p>;
  }

  if (!product) {
    return <p>No product found.</p>;
  }

  return (
    <>
      <Navbar />
      <div id="singleproduct" className="max-w-7xl mx-auto mt-4">
        <div key={product.productId} className="flex rounded-lg shadow-2xl">
          <div className="w-full">
            {/* Display the base64-encoded image */}
            {product.image ? (
              <img
                src={`data:image/jpeg;base64,${product.image}`}
                alt={product.hairStyle}
                className="product-image"
              />
            ) : (
              <p>No Image Available</p>
            )}
          </div>

          <div className="w-full px-4">
            <div className="flex justify-between w-full">
              <div className="text-black text-2xl">{product.hairStyle}</div>
              <div className="text-black text-xl">{product.hairPrice}</div>
            </div>

            <div className="w-full justify-end">
              <p className="text-black text-lg py-2">{product.hairTexture}</p>
              <p className="text-black text-lg py-2">{product.hairSize}</p>
              <p className="text-black text-lg py-2">{product.hairColor}</p>
              <p className="text-black text-lg py-2">
                {product.hairStock} in stock
              </p>
            </div>

            <div className="mt-4 py-2">
              <p className="text-black">Quantity</p>
              <input
                type="number"
                value={quantity}
                onChange={(e) => setQuantity(parseInt(e.target.value))}
                className="bg-white border border-black border-2 text-black px-2 rounded-lg"
              />
            </div>

            <div className="mt-4 py-2">
              <button onClick={handleAddToCart} className="w-full">
                Add to Cart
              </button>
              <button onClick={handleBuyNow} className="w-full mt-2">
                Buy Now
              </button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default SingleProduct;
