package io.github.ashleysaintlouis.apicadastrousuario.repository;

import io.github.ashleysaintlouis.apicadastrousuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
