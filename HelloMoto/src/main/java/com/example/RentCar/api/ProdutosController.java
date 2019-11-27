package com.example.RentCar.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RentCar.domain.Produto;
import com.example.RentCar.domain.ProdutoService;



@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutosController {
	@Autowired //Dependency Injection
	private ProdutoService service;
	
//	@GetMapping()
//	public ResponseEntity<Iterable<Produto>> get() {
//		return new ResponseEntity<>(service.getProdutos(),
//												HttpStatus.INTERNAL_SERVER_ERROR)
//				;
//	}
	
	@GetMapping()
	public String get() {
		return "ae";
	}
	
	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		Optional<Produto> produto = service.getProdutosById(id);
		
		
		
		return produto.isPresent()?
					ResponseEntity.ok(produto):
					ResponseEntity.notFound().build();	
	}								//sem argumentos => .build
	
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity  get(@PathVariable("tipo") String tipo) {
		List<Produto> produtos = service.getProdutosByTipo(tipo);
		
		return produtos.isEmpty()?
				ResponseEntity.noContent().build():
				ResponseEntity.ok(produtos);
			
	}
	
	@PostMapping
	public String post(@RequestBody Produto produto) {
		Produto p = service.save(produto);
		
		return "Produto salvo com sucesso: " + p.getId();
		}
	
	@PutMapping("/{id}")
	public String put(@PathVariable("id") Long id, @RequestBody Produto produto) {
		Produto c = service.update(produto,id);
		 return "Produto atualizado com sucesso " + c.getId(); 
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long  id) {
		service.delete(id);
		return "produto deletado otariooo";
	}
}
