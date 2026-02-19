package br.com.desafiosemana4.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherInfoTest {

    @Test
    void deveCriarWeatherInfoComDadosCorretos() {
        WeatherInfo info = new WeatherInfo(
                "São Paulo",
                25.0,
                27.0,
                "céu limpo",
                60
        );

        assertEquals("São Paulo", info.getCidade());
    }

    @Test
    void deveRetornarTemperaturaESensacaoCorretas() {
        WeatherInfo info = new WeatherInfo(
                "Rio de Janeiro",
                30.5,
                33.0,
                "ensolarado",
                55
        );

        assertEquals(30.5, info.getTemperatura());
        assertEquals(33.0, info.getSensacao());
    }

    @Test
    void deveRetornarDescricaoEUmidadeCorretas() {
        WeatherInfo info = new WeatherInfo(
                "Curitiba",
                18.0,
                17.0,
                "nublado",
                80
        );

        assertEquals("nublado", info.getDescricao());
        assertEquals(80, info.getUmidade());
    }
}


