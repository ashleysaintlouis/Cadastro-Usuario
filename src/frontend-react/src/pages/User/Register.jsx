import axios from "axios";
import "./Register.css";
import React, { useState } from "react";

const Register = () => {
  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const [confsenha, setConfsenha] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (senha != confsenha) {
      alert("Senha diferente da confirmação de senha!");
    }
    else {
      const novoUsuario = { nome, email, senha };
      axios
      .post("http://localhost:8080/usuario", novoUsuario)
      .then((response) => {
        console.log("Usuário salvo:", response.data);
        alert("Usuário cadastrado com sucesso!");
      })
      .catch((error) => {
        console.error("Erro ao salvar usuário:", error);
      });
    }
  };

  return (
    <div className="register">
      <form className="form_register" onSubmit={handleSubmit}>
        <h1>Cadastre-se</h1>
        <label>
          {" "}
          Nome:
          <input
            type="text"
            onChange={(e) => setNome(e.target.value)}
            value={nome}
            required
          />
        </label>
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
                <label>
          {" "}
          Confirme senha:
          <input
            type="password"
            onChange={(e) => setConfsenha(e.target.value)}
            value={confsenha}
          />
        </label>

        <input className="btn_cadastrar" type="submit" value="Cadastrar" />
      </form>
    </div>
  );
};

export default Register;
