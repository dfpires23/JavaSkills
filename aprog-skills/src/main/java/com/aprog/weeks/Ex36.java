package com.aprog.weeks;

import java.util.Scanner;

public class Ex36 {
    public static void main(String[] args) {
        int numA, numB, count = 0;
        Scanner ler = new Scanner(System.in);
        numA = ler.nextInt();
        numB = ler.nextInt();
        for (int i = numA; i <= numB; i++) {
            if (determinarPrimo(i) == 1 && primoTempoInteiro(i) == 1) {
                System.out.printf("%d\n", i);
                count++;
            }
        }
        System.out.printf("(%d)\n", count);
        ler.close();
    }

    public static int determinarPrimo(int num) {
        if (num < 2) {
            return 0;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int primoTempoInteiro(int num) {
        int dig = contarDigitos(num);
        int pot = potencia10(dig - 1);
        for (int i = 0; i < dig - 1; i++) {
            int ult = num % 10;
            num = num / 10 + ult * pot;
            if (determinarPrimo(num) == 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int contarDigitos(int n) {
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static int potencia10(int exp) {
        int pot = 1;
        for (int i = 0; i < exp; i++) {
            pot *= 10;
        }
        return pot;
    }
}
