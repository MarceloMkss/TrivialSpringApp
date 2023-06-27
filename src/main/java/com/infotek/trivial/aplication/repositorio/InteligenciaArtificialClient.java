package com.infotek.trivial.aplication.repositorio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class InteligenciaArtificialClient {
	
    public String enviarPregunta(String pregunta) {
    	 String triviaQuestionsJson = "";

         try {
             // URL de la API
             String apiUrl = "https://the-trivia-api.com/v2/questions?category=" + pregunta;

             // Establecer la conexión
             URL url = new URL(apiUrl);
             HttpURLConnection connection = (HttpURLConnection) url.openConnection();
             connection.setRequestMethod("GET");

             // Obtener la respuesta
             int responseCode = connection.getResponseCode();
             if (responseCode == HttpURLConnection.HTTP_OK) {
                 BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                 String line;
                 StringBuilder response = new StringBuilder();
                 while ((line = reader.readLine()) != null) {
                     response.append(line);
                 }
                 reader.close();

                 // Asignar la respuesta JSON
                 System.out.println(response.toString());
                 triviaQuestionsJson = response.toString();
             } else {
                 System.out.println("Error al realizar la solicitud. Código de respuesta: " + responseCode);
             }
         } catch (Exception e) {
             System.out.println("Ocurrió un error: " + e.getMessage());
         }

         return triviaQuestionsJson;
    }
	
	
}
