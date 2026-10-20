package com.pprog;

public class ContaPropria extends Contribuinte {
    private static final float TAXA_RT = 0.03f;
    private static final float TAXA_OR_1 = 0.02f;
    private static final float TAXA_OR_2 = 0.05f;
    private static final float LIMITE = 50000f;
    
    private String profissao;
    private float valor;

    private static final String PROFISSAO_POR_OMISSAO = "sem profissao";
    private static final float VALOR_POR_OMISSAO = 0.0f;

    public ContaPropria(String nome, String morada, String profissao, float valor) {
        super(nome, morada);
        this.profissao = profissao;
        this.valor = valor;
    }

    public ContaPropria() {
        this.profissao = PROFISSAO_POR_OMISSAO;
        this.valor = VALOR_POR_OMISSAO;
    }

    public static float getLimite() {
        return LIMITE;
    }

    public static float getTaxaRT() {
        return TAXA_RT;
    }

    public static float getTaxaOR1() {
        return TAXA_OR_1;
    }

    public static float getTaxaOR2() {
        return TAXA_OR_2;
    }

    public String getProfissao() {
        return profissao;
    }

    public float getValor() {
        return valor;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("ContaPropria: %s", super.toString());
    }

    @Override
    public float calcularImposto() {
        if (valor <= LIMITE) {
            return valor * (TAXA_RT + TAXA_OR_1);
        } else {
            return valor * (TAXA_RT + TAXA_OR_2);
        }
    }
}
