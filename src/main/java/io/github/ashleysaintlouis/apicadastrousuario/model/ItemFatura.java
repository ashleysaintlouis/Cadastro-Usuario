package io.github.ashleysaintlouis.apicadastrousuario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class ItemFatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_fatura_id;
    @Column
    private Double valor;
    @Column
    private LocalDate data_lancamento;
    @ManyToOne
    @JoinColumn
    private Fatura fatura;


}
