package io.github.ashleysaintlouis.apicadastrousuario.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class MovimentacaoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movimentacao_estoque_id;

    @Column(nullable = false)
    private LocalDate data_movimentacao;

    @Column(nullable = false)
    private Integer quantidad;

    @Column(nullable = false)
    private TipoMovimentacaoEstoque tipo_movimento;

    @Column(nullable = false)
    private OrigemMovimentacao origem;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    private Referencia referencia;

}

