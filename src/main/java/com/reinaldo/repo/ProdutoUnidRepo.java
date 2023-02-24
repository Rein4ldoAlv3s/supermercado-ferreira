package com.reinaldo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinaldo.model.ProdutoUnidade;

@Repository
public interface ProdutoUnidRepo extends JpaRepository<ProdutoUnidade, Long>{

}
