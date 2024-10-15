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
  
     const userId = localStorage.getItem("userId"); 
  
    if (!userId) {
      alert("You need to be logged in to add items to the cart.");
      return;
    }
  
    const cartRequest = {
      product: {
        productId: product.productId,         
        hairStyle: product.hairStyle,         
        hairPrice: product.hairPrice,         
        hairTexture: product.hairTexture,     
        hairSize: product.hairSize,           
        hairColor: product.hairColor,         
        hairStock: product.hairStock,        
        image: product.image,              
      },
      user: {
        userId: userId,                      
      },
      quantity: quantity,                  
    };
  
    const baseUrl = import.meta.env.VITE_BACK_END_URL;
  
    fetch(`${baseUrl}/cart/add`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(cartRequest),  
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to add product to cart");
        }
        return response.json();
      })
      .then((data) => {
       
        const { cartId } = data;
  
        if (cartId) {
          
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
         
            cart.push({
              ...cartProduct,
              cartId: cartId,  
            });
          }
  
          localStorage.setItem("cart", JSON.stringify(cart));
  
          alert("Product added to cart!");
          console.log("Product added to cart:", data);
          navigate('/products');
          location.reload();


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

  const handleBack = () => {
    navigate(-1); 
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
        <button onClick={handleBack} className="back-button">
          ← Back
        </button>
        <div
          key={product.productId}
          className="flex rounded-lg shadow-2xl mt-4"
        >
          <div className="w-full">
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
              <div className="text-black text-xl">R{product.hairPrice}</div>
            </div>

            <div className="w-full justify-end">
              <p className="text-black text-lg py-2">
                {" "}
                Texture: {product.hairTexture}
              </p>
              <p className="text-black text-lg py-2">
                Inches: {product.hairSize}
              </p>
              <p className="text-black text-lg py-2">
                Color: {product.hairColor}
              </p>
              <p className="text-black text-lg py-2">
                {product.hairStock} In stock!
              </p>
              <p className="text-black text-lg py-2">
                {" "}
                Fast delivery, ships in 5-7 working days
              </p>
              <p className="text-black text-lg py-2">
                --------------------------------------------------------------------------------------------------------
              </p>
              <p className="text-black text-lg py-2">More description:</p>
              <p className="text-black text-lg py-2">
                Our {product.hairTexture} hair is 100% raw human hair, offering
                a soft, smooth texture that mimics natural hair. Its healthy
                shine and silky feel provide an elegant look, suitable for any
                occasion.
              </p>
              <p className="text-black text-lg py-2">
                This raw hair resists tangling and shedding, ensuring it remains
                luscious and voluminous over time, even with daily wear.
              </p>
              <p className="text-black text-lg py-2">
                Designed to offer all-day comfort, the lightweight nature of the
                hair ensures it doesn't feel heavy on the scalp, making it
                perfect for extended wear.
              </p>

            

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

/* Goes in the gap above
    <div className="mt-4 py-2">
       <p className="text-black">Quantity</p>
       <input
         type="number"
         value={quantity}
         onChange={(e) => setQuantity(parseInt(e.target.value))}
         className="bg-white border border-black border-2 text-black px-2 rounded-lg"
       />
     </div>; */
