package com.example.RentCar.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{

	List<Produto> findByTipo(String tipo);
 
}
