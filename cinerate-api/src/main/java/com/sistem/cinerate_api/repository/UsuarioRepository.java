package com.sistem.cinerate_api.repository;

import com.sistem.cinerate_api.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
