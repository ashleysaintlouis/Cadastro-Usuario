package io.github.ashleysaintlouis.apicadastrousuario.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Caixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caixa_id;

    @Column(length = 255)
    private String observacao;

    @Column(length = 25)
    private LocalDate data_abertura;

    @Column(length = 25)
    private LocalDate data_fechamento;

    @Column(length = 50)
    private StatusCaixa status;

    @Column(nullable = false)
    private Double valor_abertura;

    @Column(nullable = false)
    private Double valor_fechamento;

    @ManyToOne
    @JoinColumn
    private Usuario usuario;

}
