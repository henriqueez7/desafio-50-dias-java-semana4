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
}
