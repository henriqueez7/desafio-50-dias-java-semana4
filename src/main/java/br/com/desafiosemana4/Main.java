package br.com.desafiosemana4;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        String apiKey = null;
        try {
            apiKey = System.getenv("OPEN_WEATHER_KEY");

            if (apiKey == null || apiKey.isBlank()) {
                System.out.println("API Key não encontrada. Configure a variável de ambiente.");
                return;
            }

            String cidade = URLEncoder.encode("São Paulo", StandardCharsets.UTF_8);

            String url = String.format(
                    "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric&lang=pt_br",
                    cidade, apiKey
            );

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            System.out.println("Buscando dados do clima...");

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Resposta da API:");
            System.out.println(response.body());

        } catch (Exception e) {
            System.out.println("Erro ao acessar a API:");
            System.out.println(e.getMessage());
        }

    }
}
