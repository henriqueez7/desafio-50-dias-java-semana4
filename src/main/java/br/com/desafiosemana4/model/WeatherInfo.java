package br.com.desafiosemana4.model;

public class WeatherInfo {

    private String cidade;
    private double temperatura;
    private double sensacao;
    private String descricao;
    private int umidade;

    public WeatherInfo(String cidade,
                       double temperatura,
                       double sensacao,
                       String descricao,
                       int umidade) {

        this.cidade = cidade;
        this.temperatura = temperatura;
        this.sensacao = sensacao;
        this.descricao = descricao;
        this.umidade = umidade;
    }

    public void exibir() {
        System.out.println("\nClima em " + cidade);
        System.out.println("Temperatura: " + temperatura + "°C");
        System.out.println("Sensação térmica: " + sensacao + "°C");
        System.out.println("Descrição: " + descricao);
        System.out.println("Umidade: " + umidade + "%");
    }
}
