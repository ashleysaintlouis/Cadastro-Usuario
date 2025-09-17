package io.github.ashleysaintlouis.apicadastrousuario.exceptions;

public class ExceptionsUsuario {

    public static class UsuarioNaoEncontradoException extends RuntimeException {
        public UsuarioNaoEncontradoException(Long id) {
            super("Usuário com ID " + id + " não encontrado.");
        }
    }

    public static class EmailUsuarioJaCadastradoException extends RuntimeException {
        public EmailUsuarioJaCadastradoException(String email) {
            super("E-mail de usuário já cadastrado: " + email);
        }
    }
}
