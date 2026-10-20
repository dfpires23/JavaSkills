package com.aprog.weeks;

import java.util.Scanner;

public class Ex40 {
    public static void main(String[] args) {
        int[] notas;
        Scanner ler = new Scanner(System.in);
        int n = ler.nextInt();
        notas = new int[n];
        guardarNotas(notas, ler);
        determFrequencia(notas);
        ler.close();
    }

    public static void guardarNotas(int[] notas, Scanner ler) {
        for (int i = 0; i < notas.length; i++) {
            notas[i] = ler.nextInt();
        }
    }

    public static void determFrequencia(int[] notas) {
        int[] frequencia = new int[21];
        for (int nota : notas) {
            if (nota >= 0 && nota <= 20) {
                frequencia[nota]++;
            }
        }
        for (int i = 0; i < frequencia.length; i++) {
            System.out.println(i + " " + frequencia[i]);
        }
    }
}
