import React, { useEffect, useState } from "react";
import "../assets/style.css";
import "../assets/products.css";

const FeaturedProducts = () => {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // Fetch products from the database
  useEffect(() => {
    fetch("http://localhost:8080/LuxuryHairVendingSystemDB3/product/getall")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to fetch products");
        }
        return response.json();
      })
      .then((data) => {
        setProducts(data);
        setLoading(false);
      })
      .catch((error) => {
        setError(error.message);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <p>Loading products...</p>;
  }

  if (error) {
    return <p>Error: {error}</p>;
  }

  return (
    <section id="products" className="products">
      <h2>Featured Products</h2>
      <div className="product-list">
        {products.slice(0, 3).map((product) => (
          <div key={product.productId} className="product-card">
            <img
              src={`src/assets/${product.image}`}
              alt={product.hairStyle}
              className="product-image"
            />
            <h3>{product.hairStyle}</h3>
            <p>{product.hairPrice}</p>
          </div>
        ))}
      </div>
    </section>
  );
};

export default FeaturedProducts;
