package com.reinaldo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinaldo.model.Produto;

@Repository
public interface ProdutoRepo extends JpaRepository<Produto, Long>{

}
