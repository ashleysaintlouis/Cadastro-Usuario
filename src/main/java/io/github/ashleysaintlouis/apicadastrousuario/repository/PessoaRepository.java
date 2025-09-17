package io.github.ashleysaintlouis.apicadastrousuario.repository;

import io.github.ashleysaintlouis.apicadastrousuario.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findByEmail(String email);

}
