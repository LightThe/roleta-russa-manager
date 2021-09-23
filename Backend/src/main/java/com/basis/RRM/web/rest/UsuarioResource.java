package com.basis.RRM.web.rest;


import com.basis.RRM.service.UsuarioService;
import com.basis.RRM.service.dto.UsuarioDTO;
import com.basis.RRM.service.dto.UsuarioListagemDTO;
import com.basis.RRM.service.filter.UsuarioFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
public class UsuarioResource {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioListagemDTO>> exibirUsuariosAtivos() {
        return ResponseEntity.ok(usuarioService.mostrarTodosUsuariosAtivos());
    }
    @GetMapping("/inativos")
    public ResponseEntity<List<UsuarioListagemDTO>> exibirUsuariosInativos(){
        return ResponseEntity.ok(usuarioService.mostrarTodosUsuariosInativos());
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDTO> exibirUsuarioPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usuarioService.mostrarUsuarioPorId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDTO));
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.editarUsuario(usuarioDTO));
    }
    @PutMapping("{id}")
    public ResponseEntity<UsuarioDTO> ativarUsuario(@Valid @PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioService.ativarusuario(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarUsuario(@Valid @PathVariable("id") Long id) {
        usuarioService.inativarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<UsuarioListagemDTO>> exibirUsuariosFiltrado(@RequestBody UsuarioFilter usuario){
        return ResponseEntity.ok(usuarioService.mostrarTodosUsuariosFiltrado(usuario));
    }

}

