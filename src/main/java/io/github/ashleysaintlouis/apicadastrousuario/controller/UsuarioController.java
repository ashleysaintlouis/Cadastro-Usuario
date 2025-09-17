package io.github.ashleysaintlouis.apicadastrousuario.controller;

import io.github.ashleysaintlouis.apicadastrousuario.configuration.SecurityConfiguration;
import io.github.ashleysaintlouis.apicadastrousuario.dtos.usuario.UsuarioResponseDto;
import io.github.ashleysaintlouis.apicadastrousuario.dtos.usuario.AuthRequest;
import io.github.ashleysaintlouis.apicadastrousuario.dtos.usuario.AuthResponse;
import io.github.ashleysaintlouis.apicadastrousuario.dtos.usuario.UsuarioDto;
import io.github.ashleysaintlouis.apicadastrousuario.service.TokenService;
import io.github.ashleysaintlouis.apicadastrousuario.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Usuário", description = "Endpoints para gerenciamento de usuários")
@SecurityRequirement(name = SecurityConfiguration.SEGURITY)
@RequestMapping("usuario")


public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private TokenService tokenService;


    @PostMapping("/register")
    @Operation(summary = "Registrar novo usuário", description = "Cria um novo usuário no sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Usuário cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Usuário já existe"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<UsuarioResponseDto> register(@RequestBody UsuarioDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvarUsuario(dto));
    }


    @PostMapping("/login")
    @Operation(summary = "Login de usuário", description = "Autentica usuário e retorna token JWT")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso"),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    })
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return usuarioService.autenticar(request)
                .map(usuario -> {
                    String token = tokenService.gerarToken(usuario.getEmail());
                    AuthResponse response = new AuthResponse();
                    response.setEmail(usuario.getEmail());
                    response.setToken(token);
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }


    @GetMapping
    @Operation(summary = "Listar todos os usuários", description = "Retorna a lista de todos os usuários")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public List<UsuarioResponseDto> listarTodos() {
        return usuarioService.listarTodos();
    }


    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuário por ID", description = "Retorna um usuário pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public UsuarioResponseDto buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }


    @GetMapping("/{email}")
    @Operation(summary = "Buscar usuário por e-mail", description = "Retorna um usuário pelo e-mail")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public Optional<UsuarioResponseDto> buscarPorEmail(@PathVariable String email) {
        return usuarioService.buscarUsuarioPorEmail(email);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Atualizar usuário", description = "Atualiza dados de um usuário existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public UsuarioResponseDto atualizar(@RequestBody UsuarioDto dto) {
       return usuarioService.atualizarUsuario(dto);
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir usuário", description = "Remove um usuário pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Usuário excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            usuarioService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
