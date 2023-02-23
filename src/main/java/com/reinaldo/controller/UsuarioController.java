package com.reinaldo.controller;

import java.util.List;
import java.util.Locale;
import java.text.NumberFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.reinaldo.model.Usuario;
import com.reinaldo.repo.UsuarioRepo;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepo usuarioRepo;
	
	@GetMapping("/usuarios")
	private List<Usuario> findAll(){
		return usuarioRepo.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	private ResponseEntity<Usuario> findById(@PathVariable Long id) {
		 Usuario u1 = usuarioRepo.findById(id).orElse(null);
		 return ResponseEntity.ok().body(u1);
	}
}
