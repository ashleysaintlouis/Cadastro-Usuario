package io.github.ashleysaintlouis.apicadastrousuario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartaoLoja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartao_loja_id;
    private String numero_cartao;
    private StatusCartao status;
    private Double limite_disponivel;
    private Double limite_credito;

    @OneToOne
    @JoinColumn
    private Cliente cliente;
}
