package io.github.ashleysaintlouis.apicadastrousuario.dtos.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AuthRequest {
    private String email;
    private String senha;
}
