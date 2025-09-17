package io.github.ashleysaintlouis.apicadastrousuario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class MovimentacaoCaixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movimentacao_caixa_id;

    @Column(length = 100)
    private TipoMovimentacaoCaixa tipo_movimentacao_caixa;
    @Column(length = 255)
    private String descricao;
    @Column(nullable = false)
    private Double valor;
    @Column(nullable = false)
    private LocalDate data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Caixa caixa;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;
}
