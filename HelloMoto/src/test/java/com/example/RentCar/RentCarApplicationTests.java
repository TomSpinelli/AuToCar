package com.example.RentCar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.RentCar.domain.Carro;
import com.example.RentCar.domain.CarroService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentCarApplicationTests {
	
	@Autowired
	private CarroService service;
	
	@Test
	public void test1() {
		Carro carro = new Carro();
		carro.setNome("ferrari");
		carro.setTipo("esportivo");
		service.save(carro);
	}
	
	
	@Test
	public void contextLoads() {
	}

}
