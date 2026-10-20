package org.dei.tributaveis;

public class MainTributaveis {

    public static void main(String[] args) {
        Veiculo v1 = new Veiculo("22-33-CC", 1000, "encarnado");
        System.out.println(v1);
        Veiculo v2 = new Veiculo("44-55-DD", 2500, Cores.AZUL);
        System.out.println(v2);
        Veiculo v3 = new Veiculo("11-22-BB", 1400, Veiculo.VERDE);
        System.out.println(v3);

        Moradia m1 = new Moradia("Rua do Bocage", 90.0f, Moradia.CINZENTO);
        System.out.println(m1);

        Object o1 = v1;
        System.out.println(o1);

        Object[] tributaveis = new Object[4];
        tributaveis[0] = v1;
        tributaveis[1] = v2;
        tributaveis[2] = v3;
        tributaveis[3] = m1;

        for (int i = 0; i < tributaveis.length; i++) {
            if (tributaveis[i] instanceof Tributaveis) {
                Tributaveis t = (Tributaveis) tributaveis[i];
                imprimirValorImposto(t);
            }
        }
    }

    public static void imprimirValorImposto(Tributaveis t) {
        System.out.printf("Valor do imposto: %.2f\n", t.calcularValorImposto());
    }
}
