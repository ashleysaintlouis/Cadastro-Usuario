package io.github.ashleysaintlouis.apicadastrousuario.service;

import io.github.ashleysaintlouis.apicadastrousuario.model.Usuario;
import io.github.ashleysaintlouis.apicadastrousuario.repository.UsuarioRepository;
import io.github.ashleysaintlouis.apicadastrousuario.repository.dto.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioDTO> listarTodosUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> new  UsuarioDTO(
                )).collect(Collectors.toList());
    }

    public Object buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public UsuarioDTO atualizarUsuarioPorId(Usuario usuario) {
        var usuarioAtual = usuarioRepository.findById(usuario.getId()).orElse(null);

        usuarioAtual.setNome(usuario.getNome());
        usuarioAtual.setEmail(usuario.getEmail());

        return usuarioRepository.save(usuarioAtual);
    }

    public void removerUsuarioPorId(Long id) {
        usuarioRepository.deleteById(id);
    }

}
