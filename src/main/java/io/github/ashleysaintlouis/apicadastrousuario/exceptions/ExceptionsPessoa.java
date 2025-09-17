package io.github.ashleysaintlouis.apicadastrousuario.exceptions;

public class ExceptionsPessoa {

    public static class PessoaNaoEncontradaException extends RuntimeException {
        public PessoaNaoEncontradaException(Long id) {
            super("Pessoa com ID " + id + " não encontrada.");
        }
    }

    public static class EmailPessoaJaCadastradoException extends RuntimeException {
        public EmailPessoaJaCadastradoException(String email) {
            super("E-mail já cadastrado: " + email);
        }
    }
}
