package com.aprog.weeks;

import java.util.Scanner;

public class Ex46 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String[] nomes = new String[40];
        int[] salarios = new int[40];
        int count = lerNomesEValores(nomes, salarios, ler);
        ordenarPorSalario(nomes, salarios, count);
        imprimirTop3(nomes, salarios, count);
    }

    public static int lerNomesEValores(String[] nomes, int[] salarios, Scanner ler) {
        int i = 0;
        nomes[i] = ler.nextLine();
        while (!nomes[i].equals("END") && i < nomes.length - 1) {
            salarios[i] = ler.nextInt();
            ler.nextLine();
            i++;
            nomes[i] = ler.nextLine();
        }
        return i;
    }

    public static void ordenarPorSalario(String[] nomes, int[] salarios, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (salarios[j] < salarios[j + 1] ||
                        (salarios[j] == salarios[j + 1] &&
                                nomes[j].compareToIgnoreCase(nomes[j + 1]) > 0)) {

                    int tempSalario = salarios[j];
                    salarios[j] = salarios[j + 1];
                    salarios[j + 1] = tempSalario;

                    String tempNome = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = tempNome;
                }
            }
        }
    }

    public static void imprimirTop3(String[] nomes, int[] salarios, int count) {
        int limite = Math.min(3, count);
        for (int i = 0; i < limite; i++) {
            System.out.printf("#%d:%s:%d\n", i + 1, nomes[i], salarios[i]);
        }
    }
}