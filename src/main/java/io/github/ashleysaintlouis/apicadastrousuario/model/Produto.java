package io.github.ashleysaintlouis.apicadastrousuario.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter @NotBlank
@AllArgsConstructor @NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produto_id;
    @Column(length = 255)
    @NotBlank
    private String nome;
    @Column(length = 100)
    private String descricao;
    @Column(nullable = false)
    private Double preco;
    @Column
    private String url_image;
    @Column(nullable = false)
    private Integer estoque;
    @Column(nullable = false, length = 20)
    private LocalDate data_criacao;
    @Column(nullable = false, length = 20)
    private LocalDate data_atualizacao;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Categoria categoria_id;
}
