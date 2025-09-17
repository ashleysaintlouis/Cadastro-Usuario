package io.github.ashleysaintlouis.apicadastrousuario.dtos.usuario;

import io.github.ashleysaintlouis.apicadastrousuario.dtos.PessoaDto;
import io.github.ashleysaintlouis.apicadastrousuario.model.PerfilUsuario;
import io.github.ashleysaintlouis.apicadastrousuario.model.StatusPerfilUsuario;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class UsuarioResponseDto {
    private Long id;
    private StatusPerfilUsuario status;
    private PerfilUsuario perfil_usuario;
    private PessoaDto pessoa;
}
