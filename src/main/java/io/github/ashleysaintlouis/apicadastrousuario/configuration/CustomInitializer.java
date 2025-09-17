package io.github.ashleysaintlouis.apicadastrousuario.configuration;

import io.github.ashleysaintlouis.apicadastrousuario.dtos.PessoaDto;
import io.github.ashleysaintlouis.apicadastrousuario.dtos.usuario.UsuarioDto;
import io.github.ashleysaintlouis.apicadastrousuario.model.StatusPerfilUsuario;
import io.github.ashleysaintlouis.apicadastrousuario.service.PessoaService;
import io.github.ashleysaintlouis.apicadastrousuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class CustomInitializer implements ApplicationRunner {
    private final UsuarioService usuarioService;

    public CustomInitializer(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        PessoaDto pessoaDto = new PessoaDto();
        pessoaDto.setEmail("ashley@gmail.com");
        pessoaDto.setNome("Ashley");
        pessoaDto.setTelefone("+314 555-5555");
        pessoaDto.setNumero_documento("754554545545");
        pessoaDto.setTipo_documento("Identidade");
        pessoaDto.setData_nascimento(sdf.parse("2025-02-11"));

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setSenha("123456@as");
        usuarioDto.setPessoa(pessoaDto);
        usuarioDto.setStatus(StatusPerfilUsuario.ATIVO); // Enum
        usuarioDto.setPerfil_usuario(null); // ou perfil padrão

        usuarioService.salvarUsuario(usuarioDto);

        System.out.println("Usuário inicial criado com sucesso!");
    }
}

