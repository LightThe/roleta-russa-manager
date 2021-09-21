package com.basis.RRM.repository;

import com.basis.RRM.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByStatusTrue();
    boolean existsByCpf(String cpf);
    Usuario getByCpf(String cpf);

}
