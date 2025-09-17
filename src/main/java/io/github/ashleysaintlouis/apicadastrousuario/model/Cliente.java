package io.github.ashleysaintlouis.apicadastrousuario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cliente_id;
    @Column(nullable = false, length = 20)
    private LocalDate data_cadastrado;
    @Column(nullable = false, length = 20)
    private LocalDate data_atualizado;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa_id;

}
