package io.github.ashleysaintlouis.apicadastrousuario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pessoaId;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, length = 50)
    private String tipo_documento;

    @Column(nullable = false, length = 50)
    private String numero_documento;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(nullable = false, length = 25)
    private Date data_nascimento;

//    @Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    @Column(nullable = false, length = 20)
    private LocalDate data_cadastro;

    @PrePersist
    protected void onCreate() {
        if (data_cadastro == null) {
            data_cadastro = LocalDate.now();
        }
    }


    @Column(nullable = true)
    private LocalDate data_atualizado;
}
