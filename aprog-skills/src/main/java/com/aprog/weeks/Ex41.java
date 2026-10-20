package com.aprog.weeks;

import java.util.Scanner;

public class Ex41 {
    public static void main(String[] args) {
        String[] nomes = new String[20];
        double[] salarios = new double[20];
        Scanner ler = new Scanner(System.in);
        int count = lerNomesEValores(nomes, salarios, ler);
        double media = mediaSalarios(salarios, count);
        mostrarResultados(nomes, salarios, media, count);
    }

    public static int lerNomesEValores(String[] nomes, double[] salarios, Scanner ler) {
        int i = 0;
        nomes[i] = ler.nextLine();
        while (!nomes[i].equals("end") && i < nomes.length - 1) {
            salarios[i] = ler.nextDouble();
            ler.nextLine();
            i++;
            nomes[i] = ler.nextLine();
        }
        return i;
    }

    public static double mediaSalarios(double[] salarios, int count) {
        double soma = 0;
        for (int i = 0; i < count; i++) {
            soma += salarios[i];
        }
        return soma / count;
    }

    public static void mostrarResultados(String[] nomes, double[] salarios, double media, int count) {
        System.out.printf("%.1f\n", media);
        for (int i = 0; i < count; i++) {
            if (salarios[i] < media) {
                System.out.printf("%s\n", nomes[i]);
            }
        }
    }
}
