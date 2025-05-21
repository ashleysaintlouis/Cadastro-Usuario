package io.github.ashleysaintlouis.apicadastrousuario.controller;

import io.github.ashleysaintlouis.apicadastrousuario.model.Usuario;
import io.github.ashleysaintlouis.apicadastrousuario.repository.dtos.AuthRequest;
import io.github.ashleysaintlouis.apicadastrousuario.repository.dtos.AuthResponse;
import io.github.ashleysaintlouis.apicadastrousuario.repository.dtos.UsuarioDTO;
import io.github.ashleysaintlouis.apicadastrousuario.service.user.TokenService;
import io.github.ashleysaintlouis.apicadastrousuario.service.user.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final TokenService tokenService;

    public UsuarioController(UsuarioService usuarioService,  TokenService tokenService) {
        this.usuarioService = usuarioService;
        this.tokenService = tokenService;
    }
    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return usuarioService.autenticar(request.email(), request.senha())
                .map(user -> ResponseEntity.ok(new AuthResponse(tokenService.gerarToken(user.getEmail()))))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

}

