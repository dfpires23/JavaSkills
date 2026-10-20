package com.aprog.weeks;

import java.util.Scanner;

public class Ex49 {
    public static void main(String[] args) {
        int[] conjunto = new int[50];
        int count = preencherConjunto(conjunto);
        int[] countDigitos = new int[count];
        contarDigitosDiferentes(conjunto, count, countDigitos);
        imprimirConjunto(conjunto, countDigitos, count);
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

    public static void contarDigitosDiferentes(int[] conjunto, int count, int[] countDigitos) {
        for (int i = 0; i < count; i++) {
            int num = conjunto[i];
            boolean[] digitosVistos = new boolean[10];
            int diferentes = 0;
            if (num == 0) {
                diferentes = 1;
            } else {
                while (num > 0) {
                    int digito = num % 10;
                    if (!digitosVistos[digito]) {
                        digitosVistos[digito] = true;
                        diferentes++;
                    }
                    num /= 10;
                }
            }
            countDigitos[i] = diferentes;
        }
    }

    public static void imprimirConjunto(int[] conjunto, int[] countDigitos, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(conjunto[i] + ":" + countDigitos[i]);
        }
    }
}
