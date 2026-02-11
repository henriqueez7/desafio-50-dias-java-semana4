package br.com.desafiosemana4.model;

public class Clima {

    private String cidade;
    private double temperatura;
    private double sensacaoTermica;
    private String descricao;
    private int umidade;

    public Clima(String cidade, double temperatura, double sensacaoTermica,
                 String descricao, int umidade) {
        this.cidade = cidade;
        this.temperatura = temperatura;
        this.sensacaoTermica = sensacaoTermica;
        this.descricao = descricao;
        this.umidade = umidade;
    }

    public String getCidade() {
        return cidade;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getSensacaoTermica() {
        return sensacaoTermica;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getUmidade() {
        return umidade;
    }
}
