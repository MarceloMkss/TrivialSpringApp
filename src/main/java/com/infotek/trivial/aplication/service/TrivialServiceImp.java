package com.infotek.trivial.aplication.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;


@Service
public class TrivialServiceImp implements TrivialService {
	
	//private static final String API_URL = "https://the-trivia-api.com/v2/questions?category=";

	@Override
	public  String getTriviaQuestions(String category) {
        String triviaQuestionsJson = "";

        try {
            // URL de la API
            String apiUrl = "https://the-trivia-api.com/v2/questions?category=" + category;

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
