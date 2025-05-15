import axios from "axios";
import React, { useState } from "react";

const Register = () => {
  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
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
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
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
          <input type="submit" value="Cadastrar" />
        </label>
      </form>
    </div>
  );
};

export default Register;
