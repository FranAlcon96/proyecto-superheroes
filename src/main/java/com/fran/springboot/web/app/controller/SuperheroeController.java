package com.fran.springboot.web.app.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fran.springboot.web.app.model.Superheroe;
import com.fran.springboot.web.app.service.SuperheroeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/superheroes")
public class SuperheroeController {

	@Autowired
	private SuperheroeService superheroeService;

	@ApiOperation(value="Obtiene todos los super héroes")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Super héroes listados con éxito"),
	        @ApiResponse(code = 204, message = "No se han encontrado resultados")} )
	@GetMapping(value="/listar")
	public ResponseEntity<List<Superheroe>> obtenerSuperheroes(){
		
		List<Superheroe> listaResultado = superheroeService.obtenerSuperheroes(); 
		
		return !listaResultado.isEmpty() ? new ResponseEntity<>(listaResultado, HttpStatus.OK) : 
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="Obtiene un super héroe recibiendo su id como parámetro")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Super héroe encontrado con éxito"),
	        @ApiResponse(code = 204, message = "No se ha encontrado resultado")} )
	@GetMapping(value="/listar/{id}")
	public ResponseEntity<Superheroe> obtenerSuperheroe(@PathVariable Integer id){
		
		Optional<Superheroe> op = superheroeService.obtenerSuperheroe(id);
		ResponseEntity<Superheroe> response;
		
		if (op.isPresent()) {
			response = new ResponseEntity<>(op.get(), HttpStatus.OK);
		}else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return response;
	}

	@ApiOperation(value="Obtiene todos los super héroes que incluyan la cadena en su nombre")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Super héroes listados por nombre con éxito"),
	        @ApiResponse(code = 204, message = "No se han encontrado resultados")} )
	@RequestMapping(value = "/like/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Superheroe>> obtenerSuperheroesPorNombre(@PathVariable String name){
		
		List<Superheroe> listaResultado = superheroeService.obtenerSuperheroesByName(name);
		ResponseEntity<List<Superheroe>> response;
		
		if (!listaResultado.isEmpty()) {
			response = new ResponseEntity<>(listaResultado, HttpStatus.OK);
		}else{
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return response;
	}
	
	@ApiOperation(value="Inserta un super héroe")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Super héroe listado con éxito"),
	        @ApiResponse(code = 500, message = "Error al insertar")} )
	@PostMapping(value="/insertar")
	public ResponseEntity<Superheroe> insertarSuperheroe(@RequestBody Superheroe superheroe){
		
		Superheroe creado = superheroeService.insertarSuperheroe(superheroe);
		ResponseEntity<Superheroe> response;
		
		if (creado != null) {
			response = new ResponseEntity<>(creado, HttpStatus.OK);
		}else {
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	@ApiOperation(value="Modifica un super héroe")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Super héroe listado con éxito"),
	        @ApiResponse(code = 500, message = "Error al insertar")} )
	@PutMapping(value="/modificar")
	public ResponseEntity<Superheroe> modificarSuperheroe(@RequestBody Superheroe superheroe){
		
		Superheroe creado = superheroeService.actualizarSuperheroe(superheroe);
		ResponseEntity<Superheroe> response;
		
		if (creado != null) {
			response = new ResponseEntity<>(creado, HttpStatus.OK);
		}else {
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}

	@ApiOperation(value="Elimina un super héroe")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Super héroe eliminado con éxito"),
	        @ApiResponse(code = 500, message = "Error al borrar")} )
	@DeleteMapping(value="eliminar")
	public ResponseEntity<Superheroe> insertarSuperheroe(@RequestBody Integer id){
		ResponseEntity<Superheroe> response;
		
		if (superheroeService.eliminarSuperheroe(id)) {
			response = new ResponseEntity<>(HttpStatus.OK);
		}else {
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}


}
