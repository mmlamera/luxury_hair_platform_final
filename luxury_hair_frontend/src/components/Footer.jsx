import React from 'react';
import '../assets/style.css';

const Footer = () => {
    return (
        <div className="flex bg-black justify-between">
            <div>
                <ul>
                    <h2>Products</h2>
                    <li>Featured</li>
                    <li>link 1</li>
                    <li>link 1</li>
                </ul>
            </div>
            <div>
                <ul>
                    <h2>Services</h2>
                    <li>Weave Revamp </li>
                    <li>Facebook</li>
                    <li>LinkedIn</li>
                </ul>
            </div>
            <div>
                <ul>
                    <h2>Contact</h2>
                    <li>Instagram </li>
                    <li>Facebook</li>
                    <li>LinkedIn</li>
                </ul>
            </div>
        </div>
    );
};

export default Footer;