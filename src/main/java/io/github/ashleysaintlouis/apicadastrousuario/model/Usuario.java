package io.github.ashleysaintlouis.apicadastrousuario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Column(length = 255, nullable = false)
    @NotBlank
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private StatusPerfilUsuario status; // enum já mapeado como STRING

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "perfil_usuario_id", referencedColumnName = "perfif_usuario_id")
    private PerfilUsuario perfilUsuario;

    @OneToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "pessoaId")
    private Pessoa pessoa;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataCriacao = new Date();
}
