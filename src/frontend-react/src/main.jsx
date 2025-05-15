import React from "react";
import ReactDOM from "react-dom/client";
import AppRoutes from "./router/AppRoutes.jsx";
import NavBar from "./component/NavBar.jsx";
import { BrowserRouter } from "react-router-dom";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <BrowserRouter>
      <NavBar />
      <AppRoutes />
    </BrowserRouter>
  </React.StrictMode>
);
