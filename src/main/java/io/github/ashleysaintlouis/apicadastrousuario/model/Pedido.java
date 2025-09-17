package io.github.ashleysaintlouis.apicadastrousuario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedido_id;
    private LocalDate data_pedido;
    private LocalDate data_atualizacao;
    private StatusPedido status;
    private Double preco_total;

    @OneToOne
    @JoinColumn
    private Endereco endereco_pedido;

    @OneToOne
    @JoinColumn
    private Cliente cliente_id;

    @OneToOne
    @JoinColumn
    private Usuario usuario_id;


}
