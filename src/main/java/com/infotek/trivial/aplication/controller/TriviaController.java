package com.infotek.trivial.aplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotek.trivial.aplication.dominio.Categoria;
import com.infotek.trivial.aplication.dominio.Pregunta;
import com.infotek.trivial.aplication.repositorio.CategoriaRepo;
import com.infotek.trivial.aplication.repositorio.PreguntasRepo;

@RestController
@RequestMapping("/trivia")
public class TriviaController {

	@Autowired
	PreguntasRepo preguntasRepo;

	@Autowired
	CategoriaRepo categoriaRepo;

	Pregunta pregunta = new Pregunta();

	@GetMapping("/question/{categoria}")
	public Pregunta getQuestion(@PathVariable String categoria) {

		// Sin Stram modo tradicional datos a mano de momento
		List<String> options = new ArrayList<>();

		if (categoria.equals("Historia")) {

			pregunta.setId(1L);
			pregunta.setCategory(categoria);
			pregunta.setQuestion("¿En qué año fue la Revolución Francesa?");
			pregunta.setAnswer(0);
			pregunta.setExplanation("La Revolución Francesa comenzó en 1789 y tuvo un impacto significativo en la historia de Francia y Europa.");
			options.add("1789");
			options.add("1804");
			options.add("1815");
			options.add("1830");

			pregunta.setOptions(options);
			
		} else if (categoria.equals("Ciencia")) {

			pregunta.setId(2L);
			pregunta.setCategory(categoria);
			pregunta.setQuestion("¿Cuál es el elemento químico más abundante en el universo?");
			pregunta.setAnswer(0);
			pregunta.setExplanation("El hidrógeno es el elemento más abundante en el universo.");

			options.add("Hidrógeno");
			options.add("Oxígeno");
			options.add("Carbono");
			options.add("Helio");

			pregunta.setOptions(options);
			
		} else if (categoria.equals("Cultura")) {

			pregunta.setId(3L);
			pregunta.setCategory(categoria);
			pregunta.setQuestion("¿Cuál es el río más largo del mundo?");
			pregunta.setAnswer(1);
			pregunta.setExplanation("El río Nilo es considerado el más largo del mundo, con una longitud aproximada de 6,650 kilómetros.");

			options.add("Amazonas");
			options.add("Nilo");
			options.add("Yangtsé");
			options.add("Misisipi");

			pregunta.setOptions(options);
			
		} else if (categoria.equals("Deportes")) {

			pregunta.setId(4L);
			pregunta.setCategory(categoria);
			pregunta.setQuestion("¿En qué deporte se utiliza una raqueta?");
			pregunta.setAnswer(1);
			pregunta.setExplanation(
					"El tenis es un deporte en el que se utiliza una raqueta para golpear una pelota sobre una red.");

			options.add("Fútbol");
			options.add("Tenis");
			options.add("Baloncesto");
			options.add("Natación");

			pregunta.setOptions(options);
			
		} else if (categoria.equals("Arte")) {

			pregunta.setId(5L);
			pregunta.setCategory(categoria);
			pregunta.setQuestion("¿Quién pintó La Mona Lisa?");
			pregunta.setAnswer(0);
			pregunta.setExplanation(
					"La Mona Lisa fue pintada por Leonardo da Vinci, uno de los artistas más famosos del Renacimiento.");

			options.add("Leonardo da Vinci");
			options.add("Pablo Picasso");
			options.add("Vincent van Gogh");
			options.add("Michelangelo");

			pregunta.setOptions(options);
			
		} else if (categoria.equals("Cine")) {

			pregunta.setId(6L);
			pregunta.setCategory(categoria);
			pregunta.setQuestion("¿Cuál fue la primera película de la saga de Star Wars?");
			pregunta.setAnswer(1);
			pregunta.setExplanation(
					"La primera película de la saga de Star Wars fue Una Nueva Esperanza, estrenada en 1977.");

			options.add("El Imperio Contraataca");
			options.add("Una Nueva Esperanza");
			options.add("El Retorno del Jedi");
			options.add("La Amenaza Fantasma");

			pregunta.setOptions(options);
		}
		return pregunta;

	}

	@GetMapping("/questions")
	public List<Pregunta> getQuestions() {

		// aqui uso la data.sql
		var listaPreguntas = preguntasRepo.findAll();

		return listaPreguntas;

	}

	@GetMapping("/questions/{categoria}")
	public Pregunta getTriviaQuestions(@PathVariable String categoria) {

		// utilizando data.sql
		return preguntasRepo.findByCategory(categoria);
	}

	@GetMapping("/categories")
	public List<Categoria> getCategories() {

		List<Categoria> listaCategorias = new ArrayList<>();

		listaCategorias.add(new Categoria(1L, "Historia", "Preguntas relacionadas con la Historia."));
		listaCategorias.add(new Categoria(2l, "Ciencia", "Preguntas relacionadas con la Ciencia."));
		listaCategorias.add(new Categoria(3L, "Cultura", "Preguntas relacionadas con la Cultura."));
		listaCategorias.add(new Categoria(4L, "Deportes", "Preguntas relacionadas con el Deportes."));
		listaCategorias.add(new Categoria(5L, "Arte", "Preguntas relacionadas con el Arte."));
		listaCategorias.add(new Categoria(6L, "Cine", "Preguntas relacionadas con el Cine."));

		return listaCategorias;
	}
}
