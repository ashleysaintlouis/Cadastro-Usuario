<html>
<head>
    <title>Área do Usuário</title>
    <script>
        async function carregarPerfil() {
            const token = localStorage.getItem("token");

            if (!token) {
                alert("Você precisa fazer login!");
                window.location.href = "/login";
                return;
            }

            try {
                const response = await fetch("http://localhost:8082/usuario/perfil", {
                    method: "GET",
                    headers: {
                        "Authorization": "Bearer " + token
                    }
                });

                if (response.ok) {
                    const usuario = await response.json();
                    document.getElementById("nome").textContent = usuario.nome;
                    document.getElementById("email").textContent = usuario.email;
                } else if (response.status === 401) {
                    alert("Token inválido ou expirado. Faça login novamente.");
                    localStorage.removeItem("token");
                    window.location.href = "/login";
                } else {
                    alert("Erro ao buscar perfil. Código: " + response.status);
                }
            } catch (error) {
                console.error("Erro:", error);
                alert("Erro no servidor!");
            }
        }

        function logout() {
            localStorage.removeItem("token");
            window.location.href = "login";
        }

        window.onload = carregarPerfil;
    </script>
</head>
<body>
<h2>Bem-vindo!</h2>
<p>Nome: <span id="nome"></span></p>
<p>Email: <span id="email"></span></p>

<button onclick="logout()">Sair</button>
</body>
</html>
