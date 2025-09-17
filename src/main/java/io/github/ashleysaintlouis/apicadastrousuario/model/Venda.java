package io.github.ashleysaintlouis.apicadastrousuario.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venda_id;

    @Column(nullable = false)
    private String tipo_venda;

    @Column(nullable = false)
    private StatusVenda status;

    @Column(nullable = false)
    private Double valor_total;

    @Column(nullable = false)
    private LocalDate data_venda;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Endereco endereco_entrega;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Caixa caixa;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

}
