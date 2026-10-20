package com.pprog;

public class Reformado extends Contribuinte {
    private static final float TAXA_RT = 0.01f;
    private static final float TAXA_OR = 0.03f;
    
    private float valor;
    
    private static final float VALOR_POR_OMISSAO = 0.0f;

    public Reformado(String nome, String morada, float valor) {
        super(nome, morada);
        this.valor = valor;
    }
    
    public Reformado() {
        this.valor = VALOR_POR_OMISSAO;
    }

    
    public float getValor() {
        return valor;
    }
    
    public static float getTaxaRT() {
        return TAXA_RT;
    }
    
    public static float getTaxaOR() {
        return TAXA_OR;
    }
    
    public void setValor(float valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return String.format("Reformado: %s", super.toString());
    }

    @Override
    public float calcularImposto() {
        return valor * (TAXA_RT + TAXA_OR);
    }
}
