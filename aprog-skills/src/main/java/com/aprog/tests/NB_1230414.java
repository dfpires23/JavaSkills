package com.aprog.tests;

import java.util.Scanner;

public class NB_1230414 {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int qntFichas;
        do {
            qntFichas = ler.nextInt();
        } while (!validar(qntFichas, 1, 20));

        int tempoTotal = 0;
        int lucroManha = 0, lucroTarde = 0;
        int viagensManha = 0, viagensTarde = 0;

        for (int i = 0; i < qntFichas; i++) {
            int pista;
            do {
                pista = ler.nextInt();
            } while (!validar(pista, 1, 8));

            int tipo;
            do {
                tipo = ler.nextInt();
            } while (!validar(tipo, 1, 2));

            tempoTotal += tipo;

            int lucroAtual;
            if (tipo == 1) {
                lucroAtual = 3;
            } else {
                lucroAtual = 5;
            }

            if (pista % 2 != 0) {
                lucroManha += lucroAtual;
                viagensManha++;
            } else {
                lucroTarde += lucroAtual;
                viagensTarde++;
            }
        }

        if (qntFichas > 0) {
            float tempoMedio = (float) tempoTotal / qntFichas;
            System.out.printf("O tempo médio das viagens foi de %.1f minutos\n", tempoMedio);

            int lucroTotal = lucroManha + lucroTarde;
            float percManha = (float) lucroManha / lucroTotal * 100;
            float percTarde = (float) lucroTarde / lucroTotal * 100;
            System.out.printf("O lucro foi: manha=%.1f%% e tarde=%.1f%%\n", percManha, percTarde);
        }

        imprimirResultadoViagens(viagensManha, viagensTarde);
        ler.close();
    }

    public static boolean validar(int valor, int min, int max) {
        return valor >= min && valor <= max;
    }

    public static void imprimirResultadoViagens(int manha, int tarde) {
        if (manha > tarde) {
            System.out.println("O período da manha teve mais viagens");
        } else if (tarde > manha) {
            System.out.println("O período da tarde teve mais viagens");
        } else {
            System.out.println("Os períodos tiveram a mesma quantidade de viagens");
        }
    }
}