package com.fran.springboot.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fran.springboot.web.app.model.Superheroe;
import com.fran.springboot.web.app.repository.SuperheroeRepository;

@Service
public class SuperheroeServiceImpl implements SuperheroeService {
	
	@Autowired
	private SuperheroeRepository superheroeRepository;

	@Override
	public List<Superheroe> obtenerSuperheroes() {
		return superheroeRepository.findAll();
	}

	@Override
	public Optional<Superheroe> obtenerSuperheroe(Integer id) {
		return superheroeRepository.findById(id);
	}

	@Override
	public List<Superheroe> obtenerSuperheroesByName(String nombre) {
		return superheroeRepository.findByNombreContaining(nombre);
	}

	@Override
	public Superheroe insertarSuperheroe(Superheroe superheroe) {
		return superheroeRepository.save(superheroe);
	}

	@Override
	public Superheroe actualizarSuperheroe(Superheroe superheroe) {
		Optional<Superheroe> superheroeOptional = superheroeRepository.findById(superheroe.getId());
		Superheroe superheroeMod = null;
		
		if (superheroeOptional.isPresent()) {
			superheroeMod = superheroeOptional.get();
			superheroeMod.setNombre(superheroe.getNombre());
			superheroeMod = superheroeRepository.save(superheroeMod);
		}
		
		return superheroeMod;
	}

	@Override
	public Boolean eliminarSuperheroe(Integer id) {
		try {
			superheroeRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
		
	}

}
