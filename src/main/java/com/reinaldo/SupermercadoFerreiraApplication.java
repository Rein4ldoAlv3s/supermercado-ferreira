package com.reinaldo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reinaldo.model.Compra;
import com.reinaldo.model.Endereco;
import com.reinaldo.model.Usuario;
import com.reinaldo.repo.CompraRepo;
import com.reinaldo.repo.EnderecoRepo;
import com.reinaldo.repo.UsuarioRepo;

@SpringBootApplication
public class SupermercadoFerreiraApplication implements CommandLineRunner{
	
	
	@Autowired
	private UsuarioRepo usuarioRepo;
	@Autowired
	private EnderecoRepo enderecoRepo;
	@Autowired
	private CompraRepo compraRepo;

	public static void main(String[] args) {
		SpringApplication.run(SupermercadoFerreiraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Criacao Endereco e1
		Endereco e1 = new Endereco(null, "Rua das Laranjeiras", "Av Anhanguera", 
				"Qd 50 Lote 9", 526, "Goiânia", "Goiás");
		
		//Compras c1 n pode ser setado aqui, pois n foi criado ainda
		Usuario u1 = new Usuario(null, "reinaldo.hu3", "Reinaldo Alves", "reinaldo@outlook.com",
				"senha123", e1);
		
		//Usuario u1 foi setado em Compra c1
		Compra c1 = new Compra(null, 30f, LocalDateTime.now(), 5, u1);
		
		//Compra c1 foi criado, então pode ser setado em Usuario u1
		u1.getCompras().add(c1);
		
		enderecoRepo.save(e1);
		usuarioRepo.save(u1);
		compraRepo.save(c1);
		
	}

}
