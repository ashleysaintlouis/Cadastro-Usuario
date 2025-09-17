package io.github.ashleysaintlouis.apicadastrousuario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_venda_id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private Double preco_unitario;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Venda venda;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produto;

}
