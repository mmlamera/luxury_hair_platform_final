import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import Navbar from "../components/Navbar";
import "../main.css";

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
  const [review, setReview] = useState("");

  useEffect(() => {
    fetch(`http://localhost:8080/LuxuryHairVendingSystemDB3/product/read/${id}`)
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
      // If the product with the same options already exists, update the quantity
      cart[productIndex].quantity += cartProduct.quantity;
    } else {
      // Otherwise, add the new product to the cart
      cart.push(cartProduct);
    }

    localStorage.setItem("cart", JSON.stringify(cart));
    alert("Product added to cart!");
  };

  const handleBuyNow = () => {
    navigate("/shipping");
  };

  const handleSubmitReview = () => {
    fetch(`http://localhost:8080/LuxuryHairVendingSystemDB3/reviews`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        productId: id,
        review,
      }),
    })
      .then((response) => response.json())
      .then(() => {
        alert("Review submitted!");
        setReview("");
      })
      .catch((error) => {
        console.error("Error submitting review:", error);
        alert("Failed to submit review");
      });
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
            <img
              src={"../src/assets/" + product.image}
              alt={product.hairStyle}
              className="w-full"
            />
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

            <div>
              <p className="text-black py-2">Length</p>
              <div className="flex">
                <button onClick={() => setSelectedLength("12 inches")}>
                  12 Inch
                </button>
                <button onClick={() => setSelectedLength("14 inches")}>
                  14 Inch
                </button>
                <button onClick={() => setSelectedLength("16 inches")}>
                  16 Inch
                </button>
              </div>

              <div className="mt-4 py-2">
                <p className="text-black">Colour</p>
                <div className="flex">
                  <button onClick={() => setSelectedColor("Brown")}>
                    Brown
                  </button>
                  <button onClick={() => setSelectedColor("Black")}>
                    Black
                  </button>
                  <button onClick={() => setSelectedColor("Red")}>Red</button>
                </div>
              </div>

              <div className="mt-4 py-2">
                <p className="text-black">Style</p>
                <div className="flex">
                  <button onClick={() => setSelectedStyle("Customized")}>
                    Customized
                  </button>
                  <button onClick={() => setSelectedStyle("Non-Customized")}>
                    Non-Customized
                  </button>
                </div>
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
