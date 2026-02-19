package br.com.desafiosemana4.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherInfoValidationTest {

    @Test
    void deveLancarErroQuandoCidadeForVazia() {
        assertThrows(IllegalArgumentException.class, () ->
                new WeatherInfo(
                        "",
                        20.0,
                        22.0,
                        "nublado",
                        70
                )
        );
    }

    @Test
    void deveLancarErroQuandoDescricaoForVazia() {
        assertThrows(IllegalArgumentException.class, () ->
                new WeatherInfo(
                        "São Paulo",
                        20.0,
                        22.0,
                        "",
                        70
                )
        );
    }

    @Test
    void deveLancarErroQuandoUmidadeForNegativa() {
        assertThrows(IllegalArgumentException.class, () ->
                new WeatherInfo(
                        "São Paulo",
                        20.0,
                        22.0,
                        "chuva",
                        -10
                )
        );
    }

    @Test
    void deveLancarErroQuandoUmidadeForMaiorQue100() {
        assertThrows(IllegalArgumentException.class, () ->
                new WeatherInfo(
                        "São Paulo",
                        20.0,
                        22.0,
                        "sol",
                        150
                )
        );
    }
}
