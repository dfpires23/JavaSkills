package com.aprog.weeks;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        int num, alg, soma = 0;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();
        while (num > 0) {
            alg = num % 10;
            num = num / 10;
            if (alg % 2 == 0) {
                soma = soma + alg;
            }
        }
        System.out.println(soma);
        ler.close();
    }
}
