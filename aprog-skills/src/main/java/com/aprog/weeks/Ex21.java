package com.aprog.weeks;

import java.util.*;

public class Ex21 {

    public static final int MAX_NUMBERS = 5;

    public static void main(String[] args) {
        int num, n, soma = 0, count = 0;
        float media = 0.0F;
        Scanner ler = new Scanner(System.in);
        n = ler.nextInt();
        num = ler.nextInt();
        while (contarAlgarismos(num) < n && count < MAX_NUMBERS) {
            soma += num;
            count++;
            if (count < MAX_NUMBERS) {
                num = ler.nextInt();
            }
        }
        if (count > 0) {
            media = soma / (float) count;
        } else
            media = (float) count;
        System.out.printf("%.2f\n", media);
        ler.close();
    }

    public static int contarAlgarismos(int num) {
        int qtd = 1;
        while (num > 9) {
            num /= 10;
            qtd++;
        }
        return qtd;
    }
}