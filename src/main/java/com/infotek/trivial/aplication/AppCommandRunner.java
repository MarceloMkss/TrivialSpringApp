package com.infotek.trivial.aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.infotek.trivial.aplication.repositorio.PreguntasRepo;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AppCommandRunner implements CommandLineRunner {
	
	@Autowired
	PreguntasRepo preguntasRepo;	
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		log.info("Preguntas:");		
		preguntasRepo.findAll().forEach(c -> log.info(c.toString()));
		
	}

}
