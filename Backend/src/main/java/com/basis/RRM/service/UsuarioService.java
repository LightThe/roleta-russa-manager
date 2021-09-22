package com.basis.RRM.service;

import com.basis.RRM.dominio.Usuario;
import com.basis.RRM.repository.UsuarioRepository;
import com.basis.RRM.service.dto.UsuarioDTO;
import com.basis.RRM.service.dto.UsuarioListagemDTO;
import com.basis.RRM.service.exception.RegraNegocioException;
import com.basis.RRM.service.mapper.UsuarioListagemMapper;
import com.basis.RRM.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioListagemMapper usuarioListagemMapper;


    public List<UsuarioListagemDTO> mostrarTodosUsuariosAtivos() {
        return usuarioListagemMapper.toDto(usuarioRepository.findByStatusTrue());
    }
    public List<UsuarioListagemDTO> mostrarTodosUsuariosInativos(){
        return usuarioListagemMapper.toDto(usuarioRepository.findByStatusFalse());
    }

    public UsuarioDTO mostrarUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Usuario não existe"));
        return usuarioMapper.toDto(usuario);
    }

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {

        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
        throw new RegraNegocioException("CPF já existe");
        }else if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RegraNegocioException("E-mail ja existe");
        }else{
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
            return usuarioMapper.toDto(usuarioSalvo);
        }


    }

    public void inativarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Usuário Não existe"));
        usuario.setStatus(false);
        usuarioRepository.save(usuario);
    }

    public UsuarioDTO ativarusuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Usuário Não Existe"));
        usuario.setStatus(true);
        Usuario usuariosalvar = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuariosalvar);

    }

}
