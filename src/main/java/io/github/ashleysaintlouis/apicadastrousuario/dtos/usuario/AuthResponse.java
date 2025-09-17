package io.github.ashleysaintlouis.apicadastrousuario.dtos.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse{
    private String token;
    private String nome;
    private String email;
}
