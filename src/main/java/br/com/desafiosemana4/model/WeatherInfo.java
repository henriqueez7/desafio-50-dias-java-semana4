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

        if (cidade == null || cidade.isBlank()) {
            throw new IllegalArgumentException("Cidade não pode ser vazia");
        }

        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia");
        }

        if (umidade < 0 || umidade > 100) {
            throw new IllegalArgumentException("Umidade deve estar entre 0 e 100");
        }

        this.cidade = cidade;
        this.temperatura = temperatura;
        this.sensacao = sensacao;
        this.descricao = descricao;
        this.umidade = umidade;
    }

    public String getCidade() {
        return cidade;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getSensacao() {
        return sensacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getUmidade() {
        return umidade;
    }

    public void exibir() {
        System.out.println("\nClima em " + cidade);
        System.out.println("Temperatura: " + temperatura + "°C");
        System.out.println("Sensação térmica: " + sensacao + "°C");
        System.out.println("Descrição: " + descricao);
        System.out.println("Umidade: " + umidade + "%");
    }
}
