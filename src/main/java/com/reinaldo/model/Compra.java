package com.reinaldo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Float valorTotal;
	private LocalDateTime diaHorarioCompra;

	private Integer qtdProdutos;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@OneToMany(mappedBy = "compra")
	private List<ProdutoUnidade> produtosUnidade;

	public Compra() {
		super();
	}

	public Compra(Long id, Float valorTotal, LocalDateTime diaHorarioCompra, Integer qtdProdutos, Usuario usuario) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
		this.diaHorarioCompra = diaHorarioCompra;
		this.qtdProdutos = qtdProdutos;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDateTime getDiaHorarioCompra() {
		return diaHorarioCompra;
	}

	public void setDiaHorarioCompra(LocalDateTime diaHorarioCompra) {
		this.diaHorarioCompra = diaHorarioCompra;
	}

	public Integer getQtdProdutos() {
		return qtdProdutos;
	}

	public void setQtdProdutos(Integer qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ProdutoUnidade> getProdutosUnidade() {
		return produtosUnidade;
	}

	public void setProdutosUnidade(List<ProdutoUnidade> produtosUnidade) {
		this.produtosUnidade = produtosUnidade;
	}

}
