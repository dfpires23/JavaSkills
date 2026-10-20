package com.aprog.weeks;

import java.util.*;

public class Ex5 {
    public static void main(String[] args) {
        int num, alg, i = 0;
        double soma = 0;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();
        while (num > 0) {
            soma = 0;
            i = 0;
            while (num > 0) {
                alg = num % 10;
                num = num / 10;
                soma = soma + alg * Math.pow(8, i);
                i++;
            }
            System.out.println((int) soma);
            num = ler.nextInt();
        }
        ler.close();
    }
}