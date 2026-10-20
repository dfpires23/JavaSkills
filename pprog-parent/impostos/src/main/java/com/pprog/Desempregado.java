package com.pprog;

public class Desempregado extends Contribuinte {
    
    private static final float TAXA_OR = 0.03f;
    
    private int mesesParagem;
    private float valor;

    private static final int MESES_PARAGEM_POR_OMISSAO = 0;
    private static final float VALOR_POR_OMISSAO = 0.0f;

    public Desempregado(String nome, String morada, int mesesParagem, float valor) {
        super(nome, morada);
        this.mesesParagem = mesesParagem;
        this.valor = valor;
    }

    public Desempregado() {
        this.mesesParagem = MESES_PARAGEM_POR_OMISSAO;
        this.valor = VALOR_POR_OMISSAO;
    }

    public static float getTaxaOR() {
        return TAXA_OR;
    }

    public int getMesesParagem() {
        return mesesParagem;
    }
    
    public float getValor() {
        return valor;
    }
    
    public void setMesesParagem(int mesesParagem) {
        this.mesesParagem = mesesParagem;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("Desempregado: %s", super.toString());
    }

    @Override
    public float calcularImposto() {
        return valor * TAXA_OR;
    }
}
