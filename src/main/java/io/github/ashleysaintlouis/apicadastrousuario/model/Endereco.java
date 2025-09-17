package io.github.ashleysaintlouis.apicadastrousuario.model;

import jakarta.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long endereco_id;
    @Column(nullable = false, length = 255)
    private String logradouro;
    @Column(nullable = false, length = 255)
    private String complemento;
    @Column(nullable = false, length = 100)
    private String bairro;
    @Column(nullable = false, length = 100)
    private String cidade;
    @Column(nullable = false, length = 20)
    private String cep;
    @Column(nullable = false, length = 50)
    private String estado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoEndereco tipo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente_id;

    public Endereco(long endereco_id,
                    String logradouro,
                    String complemento,
                    String bairro,
                    String cidade,
                    String cep,
                    String estado,
                    TipoEndereco tipo,
                    Cliente cliente_id)
    {
        this.endereco_id = endereco_id;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.tipo = tipo;
        this.cliente_id = cliente_id;
    }

    public Endereco() {

    }

    public long getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(long endereco_id) {
        this.endereco_id = endereco_id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Cliente cliente_id) {
        this.cliente_id = cliente_id;
    }


}
