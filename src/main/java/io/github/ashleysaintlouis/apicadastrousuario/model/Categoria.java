package io.github.ashleysaintlouis.apicadastrousuario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long categoria_id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100)
    private CategoriaEnum nome;

    @Column(length = 255)
    private String descricao;


}
