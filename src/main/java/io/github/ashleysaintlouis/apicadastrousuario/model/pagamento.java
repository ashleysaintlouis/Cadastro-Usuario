package io.github.ashleysaintlouis.apicadastrousuario.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pagamento_id;

    @Column
    private TipoTransacao tipo_transacao;

    private Referencia referencia;

    @Column
    private Double valor_transacao;

    @Column
    private String descricao;

    @Column
    private MetodoPagamento metodo_pagamento;

    @Column
    private LocalDate data_pagamento;

    @Column
    private StatusPagamento status;

    @ManyToOne
    @JoinColumn
    private Cliente cliente;



}
