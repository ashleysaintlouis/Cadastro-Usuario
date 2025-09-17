<html>
<head>
    <title>Cadastro</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css">



    <script>
        async function cadastrarUsuario(event) {
            event.preventDefault();

            const nome = document.getElementById("nome").value;
            const email = document.getElementById("email").value;
            const senha = document.getElementById("senha").value;

            const dados = { nome: nome, email: email, senha: senha };

            try {
                const response = await fetch("http://localhost:8082/usuario/register", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(dados)
                });

                if (response.ok) {
                    const result = await response.json();
                    alert("Usuário cadastrado com sucesso: " + result.nome);

                    window.location.href = "login";
                } else {
                    alert("Erro no cadastro! Código: " + response.status);
                }
            } catch (error) {
                console.error("Erro:", error);
                alert("Erro no servidor!");
            }
        }
    </script>

</head>
<body>
<h2>Criar Conta</h2>
<form class="form_register_login" onsubmit="cadastrarUsuario(event)">
    <label>Nome:</label>
    <input class="input_text" type="text" id="nome" required/><br/>

    <label>Email:</label>
    <input class="input_text" type="email" id="email" required/><br/>

    <label>Senha:</label>
    <input class="input_text" type="password" id="senha" required/><br/>

    <button class="input_button_register input_button" type="submit">Cadastrar</button>
</form>
</body>
</html>
