package com.aprog.weeks;

import java.util.*;

public class Ex31 {
    public static void main(String[] args) {
        int num;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();
        somarValores(num);
        ler.close();
    }

    public static void somarValores(int num) {
        int soma = 0, copia = 0;
        int number = reverterNum(num);
        while (number != 0) {
            int alg = number % 10;
            if (alg >= 1 && alg <= 6) {
                if (alg == copia) {
                    soma = Math.abs(soma) * -1;
                }
                if (copia == alg) {
                    soma -= alg;
                } else {
                    soma += alg;
                }
            }
            number /= 10;
            copia = alg;
        }

        System.out.println("points=" + soma);
    }

    public static int reverterNum(int n) {
        int rev = 0;
        while (n != 0) {
            int alg = n % 10;
            rev = rev * 10 + alg;
            n /= 10;
        }
        return rev;
    }
}
