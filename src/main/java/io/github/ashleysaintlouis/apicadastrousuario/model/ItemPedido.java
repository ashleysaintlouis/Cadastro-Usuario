package io.github.ashleysaintlouis.apicadastrousuario.model;

public class ItemPedido {
    private Long item_pedido_id;
    private Integer quantidade;
    private Double preco_unitario;
    private String observacao;


    private Produto produto_id;
    private Pedido pedido_id;
}
