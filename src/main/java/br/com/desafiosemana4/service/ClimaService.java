package br.com.desafiosemana4.service;

import br.com.desafiosemana4.model.Clima;
import br.com.desafiosemana4.util.ApiClient;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ClimaService {

    private static final String API_URL =
            "https://api.openweathermap.org/data/2.5/weather";

    public Clima buscarClima(String cidade) throws Exception {

        String apiKey = System.getenv("OPENWEATHER_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            throw new RuntimeException("API Key não encontrada.");
        }

        String cidadeEncoded =
                URLEncoder.encode(cidade, StandardCharsets.UTF_8);

        String url = API_URL +
                "?q=" + cidadeEncoded +
                "&appid=" + apiKey +
                "&units=metric" +
                "&lang=pt_br";

        String json = ApiClient.get(url);

        return converterJsonParaClima(json);
    }

    private Clima converterJsonParaClima(String json) {

        JsonObject obj =
                JsonParser.parseString(json).getAsJsonObject();

        String cidade = obj.get("name").getAsString();

        JsonObject main = obj.getAsJsonObject("main");

        double temp = main.get("temp").getAsDouble();
        double sensacao = main.get("feels_like").getAsDouble();
        int umidade = main.get("humidity").getAsInt();

        String descricao =
                obj.getAsJsonArray("weather")
                        .get(0)
                        .getAsJsonObject()
                        .get("description")
                        .getAsString();

        return new Clima(cidade, temp, sensacao, descricao, umidade);
    }
}
