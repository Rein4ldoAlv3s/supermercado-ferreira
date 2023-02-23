package com.reinaldo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Float valorTotal;
	private LocalDateTime diaHorarioCompra;

	private Integer qtdProdutos;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

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
	
	

}
