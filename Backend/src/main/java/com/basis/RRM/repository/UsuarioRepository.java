package com.basis.RRM.repository;

import com.basis.RRM.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UsuarioRepository {

    @Repository
    public interface UsuarioRepositorio
        extends JpaRepository<Usuario, Long> {

    }
}
