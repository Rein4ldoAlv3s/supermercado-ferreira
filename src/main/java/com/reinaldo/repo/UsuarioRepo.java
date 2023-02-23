package com.reinaldo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reinaldo.model.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Long>{

	@Query("SELECT obj FROM Usuario obj")
	List<Usuario> findAll();
	
	@Query("SELECT DISTINCT obj FROM Usuario obj WHERE obj.id = ?1")
	Optional<Usuario> findById(Long id);
}
