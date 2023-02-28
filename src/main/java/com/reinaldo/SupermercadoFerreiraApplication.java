package com.reinaldo;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reinaldo.model.Compra;
import com.reinaldo.model.Endereco;
import com.reinaldo.model.Produto;
import com.reinaldo.model.ProdutoUnidade;
import com.reinaldo.model.Usuario;
import com.reinaldo.model.enums.Tipo;
import com.reinaldo.repo.CompraRepo;
import com.reinaldo.repo.EnderecoRepo;
import com.reinaldo.repo.ProdutoRepo;
import com.reinaldo.repo.ProdutoUnidRepo;
import com.reinaldo.repo.UsuarioRepo;

@SpringBootApplication
public class SupermercadoFerreiraApplication implements CommandLineRunner{
	
	@Autowired
	private ProdutoRepo produtoRepo;
	@Autowired
	private ProdutoUnidRepo produtoUnidRepo;
	@Autowired
	private EnderecoRepo enderecoRepo;
	@Autowired
	private UsuarioRepo usuarioRepo;
	@Autowired
	private CompraRepo compraRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SupermercadoFerreiraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Ordem instanciação/salvar objetos
		//1
		Endereco e1 = new Endereco(null, "Rua das Laranjeiras", "Av Anhanguera", 
				"Qd 50 Lote 9", 526, "Goiânia", "Goiás", null);
		//2
		Usuario u1 = new Usuario(null, "reinaldo.hu3", "Reinaldo Alves", "reinaldo@outlook.com",
				"senha123", e1);
		u1.setCompras(null);
		//3
		Produto p1 = new Produto(null, "Cereal Nescau 500g", 6.5f, "Fabricado por Nestle BR", Tipo.DOCE);
		//4
		ProdutoUnidade pu1 = new ProdutoUnidade(null, 2, p1, null);
		//3
		Produto p2 = new Produto(null, "Achocolatado Toddy 300g", 4f, "Fabricado por Pepsico BR", Tipo.DOCE);
		//4
		ProdutoUnidade pu2 = new ProdutoUnidade(null, 2, p2, null);
		//5
		//recebe produto unidade em compra
		Compra c1 = new Compra(null, LocalDateTime.now(), 2, u1);
		c1.setProdutosUnidade(Arrays.asList(pu1,pu2));
		
		//recebe compra em produto unidade
		pu1.setCompra(c1);
		pu2.setCompra(c1);
		
		
		//1
		enderecoRepo.save(e1);
		//2
		usuarioRepo.save(u1);	
		//3
		produtoRepo.saveAll(Arrays.asList(p1,p2));
		//5
		compraRepo.save(c1);
		//4
		produtoUnidRepo.saveAll(Arrays.asList(pu1,pu2));
		
		
		
	}

}
