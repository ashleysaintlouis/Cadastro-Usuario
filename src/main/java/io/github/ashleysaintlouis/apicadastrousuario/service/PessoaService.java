package io.github.ashleysaintlouis.apicadastrousuario.service;

import io.github.ashleysaintlouis.apicadastrousuario.dtos.PessoaDto;
import io.github.ashleysaintlouis.apicadastrousuario.exceptions.ExceptionsPessoa;
import io.github.ashleysaintlouis.apicadastrousuario.model.Pessoa;
import io.github.ashleysaintlouis.apicadastrousuario.repository.PessoaRepository;
import io.github.ashleysaintlouis.apicadastrousuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public PessoaDto salvarPessoa(PessoaDto dto) {
        pessoaRepository.findByEmail(dto.getEmail())
                .ifPresent(p -> { throw new ExceptionsPessoa.EmailPessoaJaCadastradoException(dto.getEmail()); });

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setEmail(dto.getEmail());
        pessoa.setTelefone(dto.getTelefone());
        pessoa.setData_nascimento(dto.getData_nascimento());
        pessoa.setNumero_documento(dto.getNumero_documento());
        pessoa.setTipo_documento(dto.getTipo_documento());

        return converterParaDto(pessoaRepository.save(pessoa));
    }

    public PessoaDto atualizarPessoa(PessoaDto dto) {
        return pessoaRepository.findById(dto.getId())
                .map(pessoa -> {
                    pessoa.setNome(dto.getNome());
                    pessoa.setEmail(dto.getEmail());
                    pessoa.setTelefone(dto.getTelefone());
                    pessoa.setData_nascimento(dto.getData_nascimento());
                    pessoa.setNumero_documento(dto.getNumero_documento());
                    pessoa.setTipo_documento(dto.getTipo_documento());
                    return converterParaDto(pessoaRepository.save(pessoa));
                })
                .orElseThrow(() -> new ExceptionsPessoa.PessoaNaoEncontradaException(dto.getId()));
    }

    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new ExceptionsPessoa.PessoaNaoEncontradaException(id));
    }

    public void deletarPessoa(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new ExceptionsPessoa.PessoaNaoEncontradaException(id));

        boolean usuarioVinculado = usuarioRepository.findByPessoaPessoaId(id).isPresent();
        if (usuarioVinculado) {
            throw new RuntimeException("Não é possível excluir: existe usuário vinculado a essa pessoa.");
        }

        pessoaRepository.delete(pessoa);
    }

    public Optional<PessoaDto> buscarPorEmail(String email) {
        return pessoaRepository.findByEmail(email).map(this::converterParaDto);
    }

    public List<PessoaDto> listarTodos() {
        return pessoaRepository.findAll().stream()
                .map(this::converterParaDto)
                .toList();
    }

    public PessoaDto converterParaDto(Pessoa pessoa) {
        PessoaDto dto = new PessoaDto();
        dto.setId(pessoa.getPessoaId());
        dto.setNome(pessoa.getNome());
        dto.setEmail(pessoa.getEmail());
        dto.setTelefone(pessoa.getTelefone());
        dto.setData_nascimento(pessoa.getData_nascimento());
        dto.setNumero_documento(pessoa.getNumero_documento());
        dto.setTipo_documento(pessoa.getTipo_documento());
        return dto;
    }
}
