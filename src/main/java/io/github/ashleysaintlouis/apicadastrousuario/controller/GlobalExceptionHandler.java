package io.github.ashleysaintlouis.apicadastrousuario.controller;

import io.github.ashleysaintlouis.apicadastrousuario.exceptions.ExceptionsPessoa;
import io.github.ashleysaintlouis.apicadastrousuario.exceptions.ExceptionsUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExceptionsPessoa.PessoaNaoEncontradaException.class)
    public ResponseEntity<?> handlePessoaNaoEncontrada(ExceptionsPessoa.PessoaNaoEncontradaException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(ExceptionsPessoa.EmailPessoaJaCadastradoException.class)
    public ResponseEntity<?> handleEmailPessoaJaCadastrado(ExceptionsPessoa.EmailPessoaJaCadastradoException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(ExceptionsUsuario.UsuarioNaoEncontradoException.class)
    public ResponseEntity<?> handleUsuarioNaoEncontrado(ExceptionsUsuario.UsuarioNaoEncontradoException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(ExceptionsUsuario.EmailUsuarioJaCadastradoException.class)
    public ResponseEntity<?> handleEmailUsuarioJaCadastrado(ExceptionsUsuario.EmailUsuarioJaCadastradoException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException ex) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", message);
        return new ResponseEntity<>(body, status);
    }
}
