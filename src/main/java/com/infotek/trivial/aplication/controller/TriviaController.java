package com.infotek.trivial.aplication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotek.trivial.aplication.dominio.Categoria;
import com.infotek.trivial.aplication.dominio.Pregunta;
import com.infotek.trivial.aplication.repositorio.InteligenciaArtificialClient;
import com.infotek.trivial.aplication.repositorio.PreguntasRepo;
import com.infotek.trivial.aplication.service.TrivialService;

@RestController
@RequestMapping("/trivia")
public class TriviaController {
	
	@Autowired
	PreguntasRepo preguntasRepo;

	private final TrivialService trivialService;

	public TriviaController(TrivialService trivialService) {
		this.trivialService = trivialService;
	}

	//// ChatGptClient
	@GetMapping("/question/{categoria}")
	public String getQuestion(@PathVariable String categoria) {

		InteligenciaArtificialClient triviaClient = new InteligenciaArtificialClient();

		// ChatGptClient chatGpt = new ChatGptClient();
		/*
		 * return triviaClient.
		 * enviarPregunta("Estoy armando una trivia, necesito que me des una pregunta de la categoria "
		 * + categoria +
		 * ", con la siguiente estructura de JSON. LA respuesta de la pregunta no siempre tiene que ser la primera, tiene que variar:\n"
		 * + "\n" + "{\n" + "  \"category\": \"aca va el nombre de la categoria\",\n" +
		 * "  \"question\": \"aca va la pregunta\",\n" + "  \"options\": [\n" +
		 * "    \"aca va la opcion 1\",\n" + "    \"aca va la opcion 2\",\n" +
		 * "    \"aca va la opcion 3\"\n" + "  ],\n" +
		 * "  \"answer\": aqui va la respuesta correcta en caso de ser la primera es el numero 0 en caso de ser la segunda es el 1 y en caso de ser la tercera es el 2,\n"
		 * +
		 * "  \"explanation\": \"aca tienes que poner una explicacion diciendo porque es la respuesta correcta\"\n"
		 * + "}");
		 */
		
		return triviaClient.enviarPregunta(categoria);

	}
	
	@GetMapping("/questions")
	public List<Pregunta> getQuestions(){
		
		// aqui uso la data.sql
		var listaPreguntas = preguntasRepo.findAll();
		
		
		return listaPreguntas;	
		
	}

	@GetMapping("/questions/{categoria}")
	public Pregunta getTriviaQuestions(@PathVariable String categoria){		
		
		// utilizando data.sql		
		return preguntasRepo.findByCategory(categoria);
	}

	@GetMapping("/categories")
	public List<Categoria> getCategories() {
		
		List<Categoria> listaCategorias = new ArrayList<>();
		
		listaCategorias.add(new Categoria("Historia", "Preguntas relacionadas con la Historia."));
		listaCategorias.add(new Categoria("Ciencia", "Preguntas relacionadas con la Ciencia."));
		listaCategorias.add(new Categoria("Cultura", "Preguntas relacionadas con la Cultura."));
		listaCategorias.add(new Categoria("Deportes", "Preguntas relacionadas con el Deportes."));
		listaCategorias.add(new Categoria("Arte", "Preguntas relacionadas con el Arte."));
		listaCategorias.add(new Categoria("Cine", "Preguntas relacionadas con el Cine."));
		
		return listaCategorias;
	}
}
