package com.infotek.trivial.aplication.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infotek.trivial.aplication.dominio.Categoria;

@Repository
public interface CategoriaRepo extends CrudRepository<Categoria, Long>{
	
	List<Categoria> findAll();

}
