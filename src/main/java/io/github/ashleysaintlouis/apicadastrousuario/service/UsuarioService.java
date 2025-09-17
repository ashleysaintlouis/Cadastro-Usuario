package io.github.ashleysaintlouis.apicadastrousuario.service;

import io.github.ashleysaintlouis.apicadastrousuario.dtos.PessoaDto;
import io.github.ashleysaintlouis.apicadastrousuario.dtos.usuario.AuthRequest;
import io.github.ashleysaintlouis.apicadastrousuario.dtos.usuario.AuthResponse;
import io.github.ashleysaintlouis.apicadastrousuario.dtos.usuario.UsuarioDto;
import io.github.ashleysaintlouis.apicadastrousuario.dtos.usuario.UsuarioResponseDto;
import io.github.ashleysaintlouis.apicadastrousuario.exceptions.ExceptionsUsuario;
import io.github.ashleysaintlouis.apicadastrousuario.exceptions.ExceptionsPessoa;
import io.github.ashleysaintlouis.apicadastrousuario.model.Pessoa;
import io.github.ashleysaintlouis.apicadastrousuario.model.Usuario;
import io.github.ashleysaintlouis.apicadastrousuario.repository.PessoaRepository;
import io.github.ashleysaintlouis.apicadastrousuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PasswordEncoder encoder;

    public UsuarioResponseDto salvarUsuario(UsuarioDto dto) {
        pessoaRepository.findByEmail(dto.getPessoa().getEmail())
                .ifPresent(

        p -> { throw new ExceptionsPessoa.EmailPessoaJaCadastradoException(dto.getPessoa().getEmail()); });

        PessoaDto pessoaSalvaDto = pessoaService.salvarPessoa(dto.getPessoa());
        Pessoa pessoaEntity = pessoaService.buscarPorId(pessoaSalvaDto.getId());

        Usuario usuario = new Usuario();
        usuario.setSenha(encoder.encode(dto.getSenha()));
        usuario.setPerfilUsuario(dto.getPerfil_usuario());
        usuario.setStatus(dto.getStatus());
        usuario.setPessoa(pessoaEntity);

        return converterParaResponseDto(usuarioRepository.save(usuario));
    }

    public Optional<AuthResponse> autenticar(AuthRequest request) {
        return pessoaRepository.findByEmail(request.getEmail())
                .flatMap(pessoa ->
                        usuarioRepository.findByPessoaPessoaId(pessoa.getPessoaId())
                                .filter(usuario -> encoder.matches(request.getSenha(), usuario.getSenha()))
                                .map(usuario -> {
                                    AuthResponse response = new AuthResponse();
                                    response.setEmail(pessoa.getEmail());
                                    return response;
                                })
                );
    }

    public List<UsuarioResponseDto> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(this::converterParaResponseDto)
                .toList();
    }

    public UsuarioResponseDto buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .map(this::converterParaResponseDto)
                .orElseThrow(() -> new ExceptionsUsuario.UsuarioNaoEncontradoException(id));
    }

    public UsuarioResponseDto atualizarUsuario(UsuarioDto dto) {
        PessoaDto pessoaAtualizada = pessoaService.atualizarPessoa(dto.getPessoa());

        return usuarioRepository.findById(dto.getId())
                .map(usuario -> {
                    usuario.setPerfilUsuario(dto.getPerfil_usuario());
                    usuario.setStatus(dto.getStatus());
                    usuario.setPessoa(pessoaService.buscarPorId(pessoaAtualizada.getId()));

                    if (dto.getSenha() != null && !dto.getSenha().isEmpty()) {
                        usuario.setSenha(encoder.encode(dto.getSenha()));
                    }

                    return converterParaResponseDto(usuarioRepository.save(usuario));
                })
                .orElseThrow(() -> new ExceptionsUsuario.UsuarioNaoEncontradoException(dto.getId()));
    }

    public Optional<UsuarioResponseDto> buscarUsuarioPorEmail(String email) {
        return pessoaRepository.findByEmail(email)
                .flatMap(pessoa ->
                        usuarioRepository.findByPessoaPessoaId(pessoa.getPessoaId())
                                .map(this::converterParaResponseDto)
                );
    }


    public void excluir(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ExceptionsUsuario.UsuarioNaoEncontradoException(id);
        }
        usuarioRepository.deleteById(id);
    }

    private UsuarioResponseDto converterParaResponseDto(Usuario usuario) {
        UsuarioResponseDto dto = new UsuarioResponseDto();
        dto.setId(usuario.getUsuarioId());
        dto.setPerfil_usuario(usuario.getPerfilUsuario());
        dto.setStatus(usuario.getStatus());
        dto.setPessoa(pessoaService.converterParaDto(usuario.getPessoa()));
        return dto;
    }
}
