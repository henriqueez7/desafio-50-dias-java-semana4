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

    public void buscarClima(String cidade) {

        try {
            String apiKey = System.getenv("OPENWEATHER_API_KEY");

            if (apiKey == null || apiKey.isBlank()) {
                throw new RuntimeException("API Key não encontrada.");
            }

            apiKey = apiKey.trim();

            System.out.println("Buscando dados do clima...");

            String cidadeEncoded =
                    URLEncoder.encode(cidade, StandardCharsets.UTF_8);

            String urlCompleta = API_URL
                    + "?q=" + cidadeEncoded
                    + "&appid=" + apiKey
                    + "&units=metric"
                    + "&lang=pt_br";

            URI uri = new URI(urlCompleta);
            HttpURLConnection connection =
                    (HttpURLConnection) uri.toURL().openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status != 200) {
                throw new RuntimeException("Erro na API (HTTP " + status + ")");
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

            WeatherInfo info = processarResposta(response.toString());
            info.exibir();

        } catch (Exception e) {
            System.out.println("\nErro ao buscar clima.");
            System.out.println("Detalhes: " + e.getMessage());
        }
    }

    private WeatherInfo processarResposta(String json) {

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
