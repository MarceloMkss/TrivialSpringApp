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

	Pregunta pregunta;
	
	private TriviaController() {
		pregunta = new Pregunta();
	}
	
	/**
	 * 
	 * @param categoria @PathVariable: anotación usada en métodos de controladores para indicar
	 *  que una parte de la URL de la petición	será pasada como parámetro al método.
	 * @return la respuesta de chatGpt con la pregunta que le hago mandando un json
	 */
	//@GetMapping("/question/{categoria}") // llama esa url si quieres utilizar chatGpt
	public String getQuestionByChatGpt(@PathVariable String categoria) {
		
		ChatGptClient chatGptClient = new ChatGptClient();
	    
	    String respuestaJsonChatGpt = chatGptClient.enviarPregunta("Estoy armando una trivia, necesito que me des una pregunta de la categoria" + categoria + "con la\r\n"
	    		+ " siguiente estructura de JSON. LA respuesta de la pregunta no siempre tiene que ser la\r\n"
	    		+ " primera, tiene que variar:\r\n"
	    		+ "\r\n"
	    		+ "    {\r\n"
	    		+ "        \"category\": \"aqui va el nombre de la categoria\",\r\n"
	    		+ "        \"question\": \"aqui va la pregunta,\r\n"
	    		+ "        \"options\": [\r\n"
	    		+ "        \"aca va la opcion 1\",\r\n"
	    		+ "        \"aca va la opcion 2\",\r\n"
	    		+ "        \"aca va la opcion 3\",\r\n"
	    		+ "        ]\r\n"
	    		+ "        \"answer\": \"aqui va la respuesta correcta en caso de ser la primera es el numero 0 en caso de ser la segunda es el numero 1 y en caso de                    ser la tercera es el numero 2\",\r\n"
	    		+ "        \"explanation\": \"aqui tienes que poner una explicacion de la respuesta correcta\",\r\n"
	    		+ "    }"); 
	 
	    return respuestaJsonChatGpt;
		
	}

	/**
	 * 
	 * @param categoria @PathVariable: anotación usada en métodos de controladores para indicar
	 *  que una parte de la URL de la petición	será pasada como parámetro al método.
	 * @return una Pregunta por su Categoria. datos metidos a Mano
	 */
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

	
	/**
	 * 
	 * @return una lista de preguntas por un motor de bases de datos SQL
	 *  que implementa la API de JDBC, o sea tengo una tabla portable.
	 */
	@GetMapping("/questions")
	public List<Pregunta> getQuestions() {
		
		return preguntasRepo.findAll();

	}

	/**
	 * 
	 * @param categoria @PathVariable anotación usada en métodos de controladores para indicar
	 *  que una parte de la URL de la petición	será pasada como parámetro al método.
	 * 
	 * @return una Pregunta por su categoria. utilizando un motor de bases de datos SQL y
	 *  que implementa la API de JDBC.
	 */
	@GetMapping("/questions/{categoria}")
	public Pregunta getTriviaQuestions(@PathVariable String categoria) {

		return preguntasRepo.findByCategory(categoria);
	}

	/**
	 * 
	 * @return una lista de categorias por un motor de bases de datos SQL y
	 *  que implementa la API de JDBC, o sea tengo una tabla portable.
	 */
	@GetMapping("/categories")
	public List<Categoria> getCategories() {

		return categoriaRepo.findAll();
	}
}
