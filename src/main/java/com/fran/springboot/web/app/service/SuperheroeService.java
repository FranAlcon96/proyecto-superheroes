package com.fran.springboot.web.app.service;

import java.util.List;
import java.util.Optional;

import com.fran.springboot.web.app.model.Superheroe;

public interface SuperheroeService {

	/**
	 * Método que consulta todos los súper héroes.
	 * @return
	 */
	public List<Superheroe> obtenerSuperheroes();
	
	/**
	 * Método que consulta un único súper héroe por el id.
	 * @param id
	 * @return
	 */
	public Optional<Superheroe> obtenerSuperheroe(Integer id);
	
	/**
	 * Método que Consulta todos los súper héroes que contienen, en su nombre, el valor de un parámetro enviado en la petición.
	 * @param cadena
	 * @return
	 */
	public List<Superheroe> obtenerSuperheroesByName(String cadena);
	
	/**
	 * Método que inserta un super héroe
	 * @param superheroe
	 * @return
	 */
	public Superheroe insertarSuperheroe(Superheroe superheroe);
	
	/**
	 * Método que actualiza un super héroe
	 * @param superheroe
	 * @return
	 */
	public Superheroe actualizarSuperheroe(Superheroe superheroe);
	
	/**
	 * Método que elimina un super héroe
	 * @param id
	 * @return
	 */
	public Boolean eliminarSuperheroe(Integer id);
	
}
