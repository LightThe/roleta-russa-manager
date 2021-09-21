package com.basis.RRM.service;

import com.basis.RRM.dominio.Usuario;
import com.basis.RRM.repository.UsuarioRepository;
import com.basis.RRM.service.dto.UsuarioDTO;
import com.basis.RRM.service.dto.UsuarioListagemDTO;
import com.basis.RRM.service.exception.RegraNegocioException;
import com.basis.RRM.service.filter.UsuarioFilter;
import com.basis.RRM.service.mapper.UsuarioListagemMapper;
import com.basis.RRM.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLOutput;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioListagemMapper usuarioListagemMapper;
    private final UsuarioFilter usuarioFilter;



    public List<UsuarioListagemDTO>mostrarTodosUsuarios(){
        return usuarioListagemMapper.toDto(usuarioRepository.findByStatusTrue());
    }

    public List<UsuarioListagemDTO>mostrarTodosUsuariosFiltrado(UsuarioFilter filtro){
        return usuarioListagemMapper.toDto(usuarioRepository.findAll(filtro.filtro()));

    }

    public UsuarioDTO mostrarUsuarioPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Usuario não existe"));
        return usuarioMapper.toDto(usuario);
    }

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {

        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        usuarioRepository.existsByCpf(usuario.getCpf());
        return usuarioMapper.toDto(usuarioSalvo);
    }

    public void inativar (Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Usuário Não existe"));
        usuario.setStatus(!usuario.getStatus());
        Usuario usuarioSave = usuarioRepository.save(usuario);
    }
}
