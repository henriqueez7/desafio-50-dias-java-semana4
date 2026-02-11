package br.com.desafiosemana4.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;

public class ApiClient {

    public static String get(String url) throws Exception {

        URI uri = new URI(url);
        HttpURLConnection connection =
                (HttpURLConnection) uri.toURL().openConnection();

        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int status = connection.getResponseCode();

        if (status != 200) {
            throw new RuntimeException("Erro HTTP: " + status);
        }

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String linha;

        while ((linha = reader.readLine()) != null) {
            response.append(linha);
        }

        reader.close();
        connection.disconnect();

        return response.toString();
    }
}
