package com.reinaldo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinaldo.model.Compra;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Long>{

}
