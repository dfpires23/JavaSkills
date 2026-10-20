package com.pprog;

public class ContaOutrem extends Contribuinte {
    private static final float TAXA_RT_1 = 0.01f;
    private static final float TAXA_RT_2 = 0.02f;
    private static final float TAXA_OR = 0.02f;
    private static final float LIMITE = 30000f;
    
    private String nomeEmpresa;
    private float valor;

    private static final String NOME_EMPRESA_POR_OMISSAO = "sem nome";
    private static final float VALOR_POR_OMISSAO = 0.0f;

    public ContaOutrem(String nome, String morada, String nomeEmpresa, float valor) {
        super(nome, morada);
        this.nomeEmpresa = nomeEmpresa;
        this.valor = valor;
    }

    public ContaOutrem() {
        this.nomeEmpresa = NOME_EMPRESA_POR_OMISSAO;
        this.valor = VALOR_POR_OMISSAO;
    }

    public static float getLimite() {
        return LIMITE;
    }

    public static float getTaxaRT1() {
        return TAXA_RT_1;
    }

    public static float getTaxaRT2() {
        return TAXA_RT_2;
    }

    public static float getTaxaOR() {
        return TAXA_OR;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public float getValor() {
        return valor;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("ContaOutrem: %s", super.toString());
    }

    @Override
    public float calcularImposto() {
        if (valor <= LIMITE) {
            return valor * TAXA_RT_1 + valor * TAXA_OR;
        } else {
            return valor * TAXA_RT_2 + valor * TAXA_OR;
        }
    }
}
