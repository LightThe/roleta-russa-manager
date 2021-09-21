package com.basis.RRM.web.rest;


import com.basis.RRM.service.UsuarioService;
import com.basis.RRM.service.dto.UsuarioDTO;
import com.basis.RRM.service.dto.UsuarioListagemDTO;
import com.basis.RRM.service.filter.UsuarioFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
public class UsuarioResource {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioListagemDTO>> exibirUsuarios() {
        return ResponseEntity.ok(usuarioService.mostrarTodosUsuarios());
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDTO> exibirUsuarioPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usuarioService.mostrarUsuarioPorId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDTO));
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDTO));
    }
    @PutMapping("{id}")
    public ResponseEntity<UsuarioDTO> ativarUsuario(@PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioService.ativarusuario(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable("id") Long id) {
        usuarioService.inativarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("filtro")
    public ResponseEntity<List<UsuarioListagemDTO>> exibirUsuariosFiltrado(@RequestBody UsuarioFilter usuario){
        return ResponseEntity.ok(usuarioService.mostrarTodosUsuariosFiltrado(usuario));
    }

}

