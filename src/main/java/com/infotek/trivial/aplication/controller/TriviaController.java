package com.infotek.trivial.aplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotek.trivial.aplication.dominio.Categoria;
import com.infotek.trivial.aplication.repositorio.InteligenciaArtificialClient;
import com.infotek.trivial.aplication.service.TrivialService;

@RestController
@RequestMapping("/trivia")
public class TriviaController {

	private final TrivialService trivialService;

	public TriviaController(TrivialService trivialService) {
		this.trivialService = trivialService;
	}

	@GetMapping("/question/{categoria}")
	public String getQuestion(@PathVariable String categoria) {

		InteligenciaArtificialClient triviaClient = new InteligenciaArtificialClient();

		// ChatGptClient chatGpt = new ChatGptClient();
		return triviaClient.enviarPregunta("Estoy armando una trivia, necesito que me des una pregunta de la categoria "
				+ categoria
				+ ", con la siguiente estructura de JSON. LA respuesta de la pregunta no siempre tiene que ser la primera, tiene que variar:\n"
				+ "\n" + "{\n" + "  \"category\": \"aca va el nombre de la categoria\",\n"
				+ "  \"question\": \"aca va la pregunta\",\n" + "  \"options\": [\n" + "    \"aca va la opcion 1\",\n"
				+ "    \"aca va la opcion 2\",\n" + "    \"aca va la opcion 3\"\n" + "  ],\n"
				+ "  \"answer\": aqui va la respuesta correcta en caso de ser la primera es el numero 0 en caso de ser la segunda es el 1 y en caso de ser la tercera es el 2,\n"
				+ "  \"explanation\": \"aca tienes que poner una explicacion diciendo porque es la respuesta correcta\"\n"
				+ "}");

	}

	@GetMapping("/questions/{categoria}")
	public String getTriviaQuestions(@PathVariable String categoria){
		
			return trivialService.getTriviaQuestions(categoria);
		
		
	}

	@GetMapping("/categories")
	public Categoria[] getCategories() {

		Categoria cat = new Categoria();
		cat.setCategory("Arte");
		cat.setDescription("Preguntas relacionadas con arte, literatura, música y otras expresiones culturales.");

		Categoria cat2 = new Categoria();
		cat2.setCategory("Deportes");
		cat2.setDescription("Preguntas relacionadas con diversos deportes y eventos deportivos.");

		Categoria[] categorias = new Categoria[2];
		categorias[0] = cat;
		categorias[1] = cat2;
		return categorias;
	}
}
