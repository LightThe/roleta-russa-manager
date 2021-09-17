package com.basis.RRM.service;

import com.basis.RRM.dominio.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UsuarioServico {
    private final UsuarioRepository;
    public Usuario buscar(){

    };
}
