import { BrowserRouter as Router, Routes, Route, Navigate} from 'react-router-dom';
import Home from './components/Home';
import Product from './components/Product';
import SingleProduct from './components/SingleProduct';
import Cart from './components/Cart';
import AuthPage from "./components/AuthPage.jsx";
import Services from "./components/Services.jsx";
import Checkout from "./components/Checkout.jsx";

import AdminProduct from "./components/AdminProduct.jsx"; 

const App = () => {
    const login = window.localStorage.getItem("isLogin");
    const userType = window.localStorage.getItem("userType");
    console.log("Userr Type:" + userType);
   
    return (
        <Router>
            <Routes>
                
                <Route path="/" element={<Home />} />
                <Route path="/products" element={<Product />} />
                <Route path="/product/:id" element={<SingleProduct />} />
                <Route path="/cart" element={<Cart />} />
                <Route path="/login" element={login ? <Home /> : <AuthPage />} />
                <Route path="/services" element={<Services />} />
                <Route path="/checkout" element={login ? <Checkout /> : <AuthPage />} />
                <Route path="/AdminProduct" element={ userType === "admin"? <AdminProduct /> : <Home />
                    }
                /> 
               
            </Routes>
        </Router>
    );
    
};



export default App;


