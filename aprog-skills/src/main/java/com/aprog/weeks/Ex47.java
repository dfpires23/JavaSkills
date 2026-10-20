package com.aprog.weeks;

import java.util.Scanner;

public class Ex47 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int n = ler.nextInt();
        int[] conjunto = new int[n];
        preencherConjunto(conjunto, ler);
        imprimirConjuntoSemRepetidos(conjunto);
    }

    public static void preencherConjunto(int[] conjunto, Scanner ler) {
        for (int i = 0; i < conjunto.length; i++) {
            conjunto[i] = ler.nextInt();
        }
    }

    public static void imprimirConjuntoSemRepetidos(int[] conjunto) {
        for (int i = 0; i < conjunto.length; i++) {
            boolean repetido = false;
            for (int j = 0; j < i; j++) {
                if (conjunto[i] == conjunto[j]) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                System.out.println(conjunto[i]);
            }
        }
    }
}