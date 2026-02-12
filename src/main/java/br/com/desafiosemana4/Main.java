package br.com.desafiosemana4;

import br.com.desafiosemana4.model.WeatherInfo;
import br.com.desafiosemana4.service.WeatherService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        WeatherService weatherService = new WeatherService();

        System.out.print("Digite o nome da cidade: ");
        String cidade = scanner.nextLine();

        try {
            WeatherInfo clima = weatherService.buscarClima(cidade);
            exibirResultado(clima);
        } catch (Exception e) {
            System.out.println("\nErro ao buscar clima.");
            System.out.println("Detalhes: " + e.getMessage());
        }
    }

    private static void exibirResultado(WeatherInfo clima) {
        System.out.println("\nClima em " + clima.getCidade());
        System.out.println("Temperatura: " + clima.getTemperatura() + "°C");
        System.out.println("Sensação térmica: " + clima.getSensacao() + "°C");
        System.out.println("Descrição: " + clima.getDescricao());
        System.out.println("Umidade: " + clima.getUmidade() + "%");
    }
}
