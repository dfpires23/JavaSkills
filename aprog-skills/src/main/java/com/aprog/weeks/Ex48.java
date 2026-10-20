package com.aprog.weeks;

import java.util.Scanner;

public class Ex48 {

    public static void main(String[] args) {
        int[] conjunto = new int[40];
        int count = preencherConjunto(conjunto);
        imprimirConjunto(conjunto, count);
    }

    public static int preencherConjunto(int[] conjunto) {
        Scanner ler = new Scanner(System.in);
        int i = 0;
        int n = ler.nextInt();
        while (n >= 0) {
            conjunto[i] = n;
            i++;
            n = ler.nextInt();
        }
        ler.close();
        return i;
    }

    public static void imprimirConjunto(int[] conjunto, int count) {
        for (int i = 1; i < count - 1; i++) {
            if (conjunto[i] > conjunto[i - 1] && conjunto[i] > conjunto[i + 1]) {
                System.out.println(conjunto[i]);
            }
        }
    }
}
