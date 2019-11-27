package com.example.RentCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository rep;
	
	public Iterable<Produto> getProdutos(){
		return rep.findAll();
	}
	
	public List<Produto> getProdutosFake(){
		List<Produto> produtos = new ArrayList<>();
		
		produtos.add(new Produto("Fusca",1L));
		produtos.add(new Produto("Brasilia",2L));

		return produtos;
	}

	public Optional<Produto> getProdutosById(Long id) {
		return rep.findById(id);
	}

	public List<Produto> getProdutosByTipo(String tipo) {
		return rep.findByTipo(tipo);
	}

	public Produto save(Produto produto) {
		return rep.save(produto);
	}

	public Produto update(Produto produto, Long id) {
		Assert.notNull(id,"não deu");
		Optional<Produto> optional =  getProdutosById(id);
		if(optional.isPresent()) {
			Produto db = optional.get();
			
			db.setNome(produto.getNome());
			db.setTipo(produto.getTipo());
			System.out.println( "Produto id: " + db.getId());
			
			rep.save(db);
			
			return db;
		}else {
			throw new RuntimeException("Nao foi possivel att");
		}
		
		
	}

	public void delete(Long id) {
		Optional<Produto> produto = getProdutosById(id);
		if(produto.isPresent()) {
			rep.deleteById(id);
		}else {
			throw new RuntimeException("não tem esse carro");
		}
	}

	
	
}
