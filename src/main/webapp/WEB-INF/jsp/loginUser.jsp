<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css">
    <script>
        async function fazerLogin(event) {
            event.preventDefault();

            const email = document.getElementById("email").value;
            const senha = document.getElementById("senha").value;

            const dados = { email: email, senha: senha };

            try {
                const response = await fetch("http://localhost:8082/usuario/login", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(dados)
                });

                if (response.ok) {
                    const result = await response.json();
                    alert("Login realizado com sucesso! Usuario: " + result.token);

                    localStorage.setItem("token", result.token);

                    window.location.href = "home";
                } else {
                    alert("Erro ao fazer login! Código: " + response.status);
                }
            } catch (error) {
                console.error("Erro:", error);
                alert("Erro no servidor!");
            }
        }
    </script>
</head>
<body>
<h2>Entrar</h2>
<form class="form_register_login" onsubmit="fazerLogin(event)">
    <label>Email:</label>
    <input class="input_text" type="text" id="email" required/><br/>

    <label>Senha:</label>
    <input class="input_text" type="password" id="senha" required/><br/>

    <button class="input_button_login input_button" type="submit">Entrar</button>
</form>
</body>
</html>
