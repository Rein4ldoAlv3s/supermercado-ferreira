package com.reinaldo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.reinaldo.model.Compra;
import com.reinaldo.model.ProdutoUnidade;
import com.reinaldo.model.Usuario;
import com.reinaldo.repo.CompraRepo;
import com.reinaldo.repo.ProdutoUnidRepo;
import com.reinaldo.repo.UsuarioRepo;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepo usuarioRepo;
	@Autowired
	private ProdutoUnidRepo produtoUnidRepo;
	@Autowired
	private CompraRepo compraRepo;
	
	@GetMapping("/usuarios")
	private List<Usuario> findAll(){
		return usuarioRepo.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	private ResponseEntity<Usuario> findById(@PathVariable Long id) {
		 Usuario u1 = usuarioRepo.findById(id).orElse(null);
		 return ResponseEntity.ok().body(u1);
	}
	
	@GetMapping("/produtosUnidade")
	private List<ProdutoUnidade> findAllProdutoUnidade(){
		return produtoUnidRepo.findAll();
	}
	
	@GetMapping("/compras")
	private List<Compra> findAllCompras(){
		return compraRepo.findAll();
	}
	
}
