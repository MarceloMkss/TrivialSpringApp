package com.infotek.trivial.aplication.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infotek.trivial.aplication.dominio.Pregunta;

@Repository
public interface PreguntasRepo extends CrudRepository<Pregunta, Long> {

	List<Pregunta> findAll();
	List<Pregunta> findByCategory(String categoria);
}
