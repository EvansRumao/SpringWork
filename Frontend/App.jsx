// Import React and the useState hook
import React, { useState } from "react";

// Import all the components used in the application
import Home from "./components/Home";
import Navbar from "./components/Navbar";
import Cart from "./components/Cart";
import AddProduct from "./components/AddProduct";
import Product from "./components/Product";
import UpdateProduct from "./components/UpdateProduct";
import Order from "./components/Order";
import SearchResults from "./components/SearchResults";

// Import React Router components for navigation
import { BrowserRouter, Routes, Route } from "react-router-dom";

// Import Context Provider to share state across the application
import { AppProvider } from "./Context/Context";

// Import Bootstrap CSS and JavaScript
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";

// Import Toast notifications
import { ToastContainer } from "react-toastify";

function App() {

  // State to store the currently selected product category
  const [selectedCategory, setSelectedCategory] = useState("");

  // Function called when a category is selected from the Navbar
  const handleCategorySelect = (category) => {
    setSelectedCategory(category); // Update the selected category
    console.log("Selected category:", category);
  };

  return (

    // AppProvider makes global state accessible to all child components
    <AppProvider>

      {/* BrowserRouter enables client-side routing */}
      <BrowserRouter>

        {/* ToastContainer displays notification messages */}
        <ToastContainer
          autoClose={2000}
          hideProgressBar={true}
        />

        {/* Navbar receives the category selection callback */}
        <Navbar onSelectCategory={handleCategorySelect} />

        {/* Main container with Bootstrap styling */}
        <div className="min-vh-100 bg-light">

          {/* Define all application routes */}
          <Routes>

            {/* Home page with selected category passed as prop */}
            <Route
              path="/"
              element={<Home selectedCategory={selectedCategory} />}
            />

            {/* Add Product page */}
            <Route path="/add_product" element={<AddProduct />} />

            {/* Product page */}
            <Route path="/product" element={<Product />} />

            {/* Dynamic Product Details page using product ID */}
            <Route path="product/:id" element={<Product />} />

            {/* Shopping Cart page */}
            <Route path="/cart" element={<Cart />} />

            {/* Update Product page using product ID */}
            <Route
              path="/product/update/:id"
              element={<UpdateProduct />}
            />

            {/* Orders page */}
            <Route path="/orders" element={<Order />} />

            {/* Search Results page */}
            <Route
              path="/search-results"
              element={<SearchResults />}
            />

          </Routes>
        </div>
      </BrowserRouter>
    </AppProvider>
  );
}

export default App;
