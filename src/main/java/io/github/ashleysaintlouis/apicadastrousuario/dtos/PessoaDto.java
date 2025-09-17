package io.github.ashleysaintlouis.apicadastrousuario.dtos;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class PessoaDto {
    private Long id;
    private String nome;
    private String tipo_documento;
    private String numero_documento;
    private String email;
    private String telefone;
    private Date data_nascimento;
}
