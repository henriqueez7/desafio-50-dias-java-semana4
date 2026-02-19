package br.com.desafiosemana4.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherInfoValidationTest {

    @Test
    void deveLancarExcecaoQuandoCidadeForInvalida() {
        assertThrows(IllegalArgumentException.class, () ->
                new WeatherInfo(
                        "",
                        25.0,
                        26.0,
                        "céu limpo",
                        60
                )
        );
    }

    @Test
    void deveLancarExcecaoQuandoUmidadeForInvalida() {
        assertThrows(IllegalArgumentException.class, () ->
                new WeatherInfo(
                        "São Paulo",
                        25.0,
                        26.0,
                        "céu limpo",
                        -10
                )
        );
    }
}
