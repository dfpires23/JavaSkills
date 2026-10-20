package com.pprog;

public class MainTrabalhador {
    public static void main(String[] args) {
        TrabalhadorPeca t1 = new TrabalhadorPeca("Jorge Silva", 53, 62);
        TrabalhadorComissao t2 = new TrabalhadorComissao("Susana Ferreira", 650.00f, 4.25f, 2731.50f);
        TrabalhadorHora t3 = new TrabalhadorHora("Carlos Miguel", 168, 4.50f);

        Trabalhador[] trabs = new Trabalhador[10];
        trabs[0] = t1;
        trabs[1] = t2;
        trabs[2] = t3;

        System.out.println("================================");
        for (int i = 0; i < trabs.length; i++) {
            if (trabs[i] != null)
                System.out.println(trabs[i]);
        }

        System.out.println("================================");
        for (int i = 0; i < trabs.length; i++) {
            if (trabs[i] instanceof TrabalhadorHora) {
                System.out.println(trabs[i]);
            }
        }

        System.out.println("================================");
        for (int i = 0; i < trabs.length; i++) {
            if (trabs[i] != null)
                System.out.println(trabs[i].getNome() + " - Vencimento: " + trabs[i].calcularVencimento());
        }
    }
}