package io.github.ashleysaintlouis.apicadastrousuario.repository;

import io.github.ashleysaintlouis.apicadastrousuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
