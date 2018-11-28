package com.dms.caixa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dms.caixa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByEmail(String email);

}
