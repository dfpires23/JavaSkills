package com.pprog;

public class Contribuinte {
    private String nome;
    private String morada;

    private static final String NOME_POR_OMISSAO = "sem nome";
    private static final String MORADA_POR_OMISSAO = "sem morada";

    public Contribuinte(String nome, String morada) {
        this.nome = nome;
        this.morada = morada;
    }

    public Contribuinte() {
        this.nome = NOME_POR_OMISSAO;
        this.morada = MORADA_POR_OMISSAO;
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public float calcularImposto() {
        return 0.0f;
    }

    @Override
    public String toString() {
        return String.format("nome=%s, morada=%s", nome, morada);
    }
}
