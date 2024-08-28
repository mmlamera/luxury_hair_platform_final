import React from 'react';
import '../assets/style.css';
import '../assets/products.css';


const FeaturedProducts = () => {
    const products = [
        { id: 1, name: 'Body Wave', price: 'R1900.00', image: '/src/assets/BodyWave.jpg' },
        { id: 2, name: 'Barbie Curls', price: 'R3700.00', image: '/src/assets/KinkyCurls.jpg' },
        { id: 3, name: 'Wavy Curls', price: 'R5000.00', image: '/src/assets/JasmineRaw.jpg' },
      //  { id: 4, name: 'Kim K Bob', price: 'R2,300.00', image: '/src/assets/KimKBob.jpg' },

    ];

    return (
        <section id="products" className="products">
            <h2>Featured Products</h2>
            <div className="product-list">
                {products.map((product) => (
                    <div key={product.id} className="product-card">
                        <img src={product.image} alt={product.name} />
                        <h3>{product.name}</h3>
                        <p>{product.price}</p>
                    </div>
                ))}
            </div>
        </section>
    );
};

export default FeaturedProducts;
