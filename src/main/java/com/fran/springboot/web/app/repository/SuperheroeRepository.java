package com.fran.springboot.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fran.springboot.web.app.model.Superheroe;

@Repository
public interface SuperheroeRepository extends JpaRepository<Superheroe, Integer> {

	List<Superheroe> findByNombreContaining(String nombre);
}
