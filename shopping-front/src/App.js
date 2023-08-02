/** @format */
import "bootstrap/dist/css/bootstrap.min.css";
import React from "react";
import "./App.css";
import Header from "./components/Header";
import Footer from "./components/Footer";
// import ProductCard from "./components/Product";
import Products from "./components/Products";

const App = () => {
  return (
    <div>
      <Header />
      <div style={{ padding: "80px" }}>
        <Products />
      </div>

      <Footer />
    </div>
  );
};

export default App;
