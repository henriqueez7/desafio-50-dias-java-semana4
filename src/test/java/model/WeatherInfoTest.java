package model;

import br.com.desafiosemana4.model.WeatherInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherInfoTest {

    @Test
    void deveCriarObjetoWeatherInfoCorretamente() {

        WeatherInfo info = new WeatherInfo(
                "São Paulo",
                25.0,
                26.5,
                "céu limpo",
                60
        );

        assertNotNull(info);
    }

    @Test
    void deveArmazenarDadosCorretamente() {

        WeatherInfo info = new WeatherInfo(
                "Rio de Janeiro",
                30.0,
                32.0,
                "ensolarado",
                55
        );

        assertEquals("Rio de Janeiro", info.getCidade());
        assertEquals(30.0, info.getTemperatura());
        assertEquals(32.0, info.getSensacao());
        assertEquals("ensolarado", info.getDescricao());
        assertEquals(55, info.getUmidade());
    }
}

