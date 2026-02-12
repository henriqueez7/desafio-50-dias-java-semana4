package br.com.desafiosemana4.service;

import br.com.desafiosemana4.model.WeatherInfo;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class WeatherService {

    private static final String API_URL =
            "https://api.openweathermap.org/data/2.5/weather";

    public WeatherInfo buscarClima(String cidade) throws Exception {

        String apiKey = System.getenv("OPENWEATHER_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            throw new RuntimeException("API Key não encontrada.");
        }

        apiKey = apiKey.trim();

        String cidadeEncoded =
                URLEncoder.encode(cidade, StandardCharsets.UTF_8);

        String urlCompleta = API_URL +
                "?q=" + cidadeEncoded +
                "&appid=" + apiKey +
                "&units=metric" +
                "&lang=pt_br";

        URI uri = new URI(urlCompleta);
        HttpURLConnection connection =
                (HttpURLConnection) uri.toURL().openConnection();

        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("Erro ao buscar clima.");
        }

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream())
                );

        StringBuilder response = new StringBuilder();
        String linha;

        while ((linha = reader.readLine()) != null) {
            response.append(linha);
        }

        reader.close();
        connection.disconnect();

        return parsearResposta(response.toString());
    }

    private WeatherInfo parsearResposta(String json) {

        JsonObject jsonObject =
                JsonParser.parseString(json).getAsJsonObject();

        String cidade = jsonObject.get("name").getAsString();

        JsonObject main = jsonObject.getAsJsonObject("main");

        double temperatura = main.get("temp").getAsDouble();
        double sensacao = main.get("feels_like").getAsDouble();
        int umidade = main.get("humidity").getAsInt();

        String descricao =
                jsonObject.getAsJsonArray("weather")
                        .get(0)
                        .getAsJsonObject()
                        .get("description")
                        .getAsString();

        return new WeatherInfo(
                cidade,
                temperatura,
                sensacao,
                descricao,
                umidade
        );
    }
}
