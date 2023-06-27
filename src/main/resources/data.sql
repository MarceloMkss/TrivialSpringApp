-- Creación de la tabla "preguntas"
CREATE TABLE pregunta (
  id INT PRIMARY KEY AUTO_INCREMENT,
  category VARCHAR(255),
  question VARCHAR(255),
  options VARCHAR(255),
  answer INT,
  explanation VARCHAR(255)
);


-- Inserción de las preguntas
INSERT INTO pregunta (category, question, options, answer, explanation)
VALUES 
  ('Ciencia', '¿Cuál es el elemento químico más abundante en el universo?', '{"A. Hidrógeno", "B. Oxígeno", "C. Carbono", "D. Helio"}', 1, 'El hidrógeno es el elemento más abundante en el universo.'),
  ('Historia', '¿En qué año fue la Revolución Francesa?', '{"A. 1789", "B. 1804", "C. 1815", "D. 1830"}', 1, 'La Revolución Francesa comenzó en 1789 y tuvo un impacto significativo en la historia de Francia y Europa.'),
  ('Deportes', '¿En qué deporte se utiliza una raqueta?', '{"A. Tenis", "B. Fútbol", "C. Baloncesto", "D. Natación"}', 1, 'El tenis es un deporte en el que se utiliza una raqueta para golpear una pelota sobre una red.'),
  ('Geografía', '¿Cuál es el río más largo del mundo?', '{"A. Amazonas", "B. Nilo", "C. Yangtsé", "D. Misisipi"}', 2, 'El río Nilo es considerado el más largo del mundo, con una longitud aproximada de 6,650 kilómetros.'),
  ('Arte', '¿Quién pintó La Mona Lisa?', '{"A. Leonardo da Vinci", "B. Pablo Picasso", "C. Vincent van Gogh", "D. Michelangelo"}', 1, 'La Mona Lisa fue pintada por Leonardo da Vinci, uno de los artistas más famosos del Renacimiento.'),
  ('Cine', '¿Cuál fue la primera película de la saga de Star Wars en ser lanzada?', '{"A. Star Wars: Episodio IV - Una nueva esperanza", "B. Star Wars: Episodio I - La amenaza fantasma", "C. Star Wars: Episodio VI - El retorno del Jedi", "D. Star Wars: Episodio V - El imperio contraataca"}', 1, 'La primera película de la saga de Star Wars en ser lanzada fue "Star Wars: Episodio IV - Una nueva esperanza" en 1977.'),
  ('Literatura', '¿Quién escribió el libro "Cien años de soledad"?', '{"A. Gabriel García Márquez", "B. Jorge Luis Borges", "C. Mario Vargas Llosa", "D. Julio Cortázar"}', 1, 'El libro "Cien años de soledad" fue escrito por Gabriel García Márquez, un reconocido escritor colombiano y premio Nobel de Literatura.'),
  ('Música', '¿Quién compuso la famosa sinfonía "La Quinta"?', '{"A. Ludwig van Beethoven", "B. Wolfgang Amadeus Mozart", "C. Johann Sebastian Bach", "D. Franz Schubert"}', 1, 'La famosa sinfonía "La Quinta" fue compuesta por Ludwig van Beethoven, uno de los compositores más influyentes de la música clásica.');


