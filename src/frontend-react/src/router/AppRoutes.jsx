//Pages
import Home from "../pages/functional/Home";
import Login from "../pages/User/Login";
import Register from "../pages/User/Register";

import { Route, Routes } from "react-router-dom";

function AppRoutes() {
  return (
    <div className="AppRoutes">
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </div>
  );
}

export default AppRoutes;
