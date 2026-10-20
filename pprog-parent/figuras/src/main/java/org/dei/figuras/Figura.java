package org.dei.figuras;

public class Figura {

    private String cor;

    private static final String COR_POR_OMISSAO = "cinzento";

    public Figura(String cor) {
        this.cor = cor;
    }

    public Figura() {
        cor = COR_POR_OMISSAO;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double calcArea() {
        return 0;
    }

    @Override // Sobrescrita do Método toString() da Classe Object !
    public String toString() {
        return String.format("cor=%s", cor);
    }
    
}
