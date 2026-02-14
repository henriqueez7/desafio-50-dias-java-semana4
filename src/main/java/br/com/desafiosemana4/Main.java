package br.com.desafiosemana4;

import br.com.desafiosemana4.service.WeatherService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        WeatherService weatherService = new WeatherService();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== MENU CLIMA ===");
            System.out.println("1 - Buscar clima por cidade");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            String entrada = scanner.nextLine();

            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite apenas números.");
                continue;
            }

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o nome da cidade: ");
                    String cidade = scanner.nextLine();

                    if (cidade.isBlank()) {
                        System.out.println("Cidade não pode ser vazia.");
                        continue;
                    }

                    weatherService.buscarClima(cidade);
                }
                case 0 -> System.out.println("Encerrando aplicação...");
                default -> System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
