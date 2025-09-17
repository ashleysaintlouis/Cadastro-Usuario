package io.github.ashleysaintlouis.apicadastrousuario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fatura_id;

    @Column(nullable = false)
    private String mes_referencia;

    @Column
    private LocalDate data_emissao;

    private Date data_vencimento;

    private Double valor;

    private StatusFatura status;


    @ManyToOne
    @JoinColumn(nullable = false)
    private CartaoLoja cartao;

}
