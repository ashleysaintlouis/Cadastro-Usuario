package io.github.ashleysaintlouis.apicadastrousuario.service.user;

import io.github.ashleysaintlouis.apicadastrousuario.model.Usuario;
import io.github.ashleysaintlouis.apicadastrousuario.repository.UsuarioRepository;
import io.github.ashleysaintlouis.apicadastrousuario.repository.dtos.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvarUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(encoder.encode(dto.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> autenticar(String email, String senha) {
        return usuarioRepository.findByEmail(email)
                .filter(user -> encoder.matches(senha, user.getSenha()));
    }

}
