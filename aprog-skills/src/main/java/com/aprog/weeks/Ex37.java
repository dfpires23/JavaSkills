package com.aprog.weeks;

import java.util.Scanner;

public class Ex37 {
    public static void main(String[] args) {
        int[] notas;
        Scanner ler = new Scanner(System.in);
        int n = ler.nextInt();
        notas = new int[n];
        for (int i = 0; i < notas.length; i++) {
            notas[i] = ler.nextInt();
        }
        System.out.printf("average=%.1f\n", calcularMedia(notas));
        System.out.printf("failures=%d\n", contarReprovados(notas));
        ler.close();
    }

    public static double calcularMedia(int[] notas) {
        int soma = 0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }
        return (double) soma / notas.length;
    }

    public static int contarReprovados(int[] notas) {
        int count = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 10) {
                count++;
            }
        }
        return count;
    }
}