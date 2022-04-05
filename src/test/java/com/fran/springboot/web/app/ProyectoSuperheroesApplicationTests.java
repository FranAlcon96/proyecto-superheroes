package com.fran.springboot.web.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fran.springboot.web.app.model.Superheroe;
import com.fran.springboot.web.app.service.SuperheroeService;

@SpringBootTest
class ProyectoSuperheroesApplicationTests {
	
	@Autowired
	SuperheroeService superheroeService;
	
	@Test
	public void probarListarNombres() {
		superheroeService.insertarSuperheroe(new Superheroe(1, "Superman"));
		superheroeService.insertarSuperheroe(new Superheroe(2, "Spiderman"));
		superheroeService.insertarSuperheroe(new Superheroe(3, "robin"));
		
		List<Superheroe> lista = superheroeService.obtenerSuperheroesByName("an");
		
		assertEquals(2, lista.size());
	}

	@Test
	public void probarListar() {
		superheroeService.insertarSuperheroe(new Superheroe(4, "Deadpool"));
		superheroeService.insertarSuperheroe(new Superheroe(5, "Batman"));
		superheroeService.insertarSuperheroe(new Superheroe(6, "Arrow"));
		
		List<Superheroe> lista = superheroeService.obtenerSuperheroes();
		
		assertEquals(3, lista.size());
	}

}
