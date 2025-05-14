package io.github.ashleysaintlouis.apicadastrousuario.repository.dto;


public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;


    public UsuarioDTO() {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
