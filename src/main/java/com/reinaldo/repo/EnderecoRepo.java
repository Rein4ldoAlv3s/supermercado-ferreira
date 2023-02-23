package com.reinaldo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reinaldo.model.Endereco;

public interface EnderecoRepo extends JpaRepository<Endereco, Long>{

}
