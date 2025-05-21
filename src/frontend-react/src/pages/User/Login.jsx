import axios from "axios";
import "./Register.css";
import React, { useState } from "react";

const Login = () => {
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");


  const handleSubmit = (e) => {
    e.preventDefault();
    const logarUsuario = { email, senha };
    axios
    .post("http://localhost:8080/usuario", logarUsuario)
    .then((response) => {
      console.log("Acesso ao sistema realizado com sucesso!", response.data);
      alert("Acesso ao sistema realizado com sucesso!");
    })
    .catch((error) => {
      console.error("Erro ao acessar ao sistema", error);
    });
  };

  return (
    <div className="register">
      <form className="form_register" onSubmit={handleSubmit}>
        <h1>Entrar</h1>
    
        <label>
          {" "}
          E-mail:
          <input
            type="email"
            onChange={(e) => setEmail(e.target.value)}
            value={email}
          />
        </label>
        <label>
          {" "}
          Senha:
          <input
            type="password"
            onChange={(e) => setSenha(e.target.value)}
            value={senha}
          />
        </label>
        <a href="/forgotpassword">Esqueceu senha?</a>
        <input className="btn_cadastrar" type="submit" value="Entrar" />

        <a href="/register">Ainda não possui cadadtro? Clique aqui.</a>
      </form>
    </div>
  );
};

export default Login;
