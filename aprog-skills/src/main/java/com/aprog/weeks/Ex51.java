package com.aprog.weeks;

import java.util.Scanner;

public class Ex51 {
    public static final Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int n = ler.nextInt();
        if (n <= 1 || n > 20)
            return;
        int q2 = 0, q1 = 0;
        int q3 = 0, q4 = 0;
        int meio = n / 2;
        boolean impar = (n % 2 != 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int valor = ler.nextInt();
                if (impar && (i == meio || j == meio)) {
                    continue;
                }
                if (i < meio) {
                    if (j < meio) {
                        q2 += valor;
                    } else {
                        q1 += valor;
                    }
                } else {
                    if (j < meio) {
                        q3 += valor;
                    } else {
                        q4 += valor;
                    }
                }
            }
        }
        System.out.println("[" + q2 + "][" + q1 + "]");
        System.out.println("[" + q3 + "][" + q4 + "]");
    }
}