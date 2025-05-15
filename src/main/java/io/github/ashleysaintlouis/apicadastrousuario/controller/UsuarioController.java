package io.github.ashleysaintlouis.apicadastrousuario.controller;

import io.github.ashleysaintlouis.apicadastrousuario.model.Usuario;
import io.github.ashleysaintlouis.apicadastrousuario.repository.dto.UsuarioDTO;
import io.github.ashleysaintlouis.apicadastrousuario.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public UsuarioDTO atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioService.atualizarUsuarioPorId(usuario);
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.listarTodosUsuarios();
    }

    @GetMapping("{id}")
    public Object buscarUsuarioPorId(@PathVariable("id") Long id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    @DeleteMapping("/{id}")
    public void removerUsuario(@PathVariable("id") Long id) {
        usuarioService.removerUsuarioPorId(id);
    }


}
