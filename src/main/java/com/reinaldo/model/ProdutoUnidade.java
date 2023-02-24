package com.reinaldo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ProdutoUnidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer qtd;
	private Float valorTotal;
	@OneToOne
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "compra_id")
	private Compra compra;

	public ProdutoUnidade() {
		super();
	}

	public ProdutoUnidade(Long id, Integer qtd, Produto produto, Compra compra) {
		super();
		this.id = id;
		this.qtd = qtd;
		this.valorTotal = produto.getPreco() * qtd;
		this.produto = produto;
		this.compra = compra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	

}
