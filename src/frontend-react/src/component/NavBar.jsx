import React from "react";
import { NavLink } from "react-router-dom";
import "./Navbar.css";

const NavBar = () => {
  return (
    <nav className="Navbar">
      <a className="crud" href="/">
        CRUD
      </a>
      <div className="nav_links">
        <NavLink className="link link_home" to="/">
          Inicio
        </NavLink>
        <NavLink className="link link_cadastrar" to="/register">
          Cadastrar
        </NavLink>
        <NavLink className="link link_login" to="/login">
          Entrar
        </NavLink>
      </div>
    </nav>
  );
};

export default NavBar;
