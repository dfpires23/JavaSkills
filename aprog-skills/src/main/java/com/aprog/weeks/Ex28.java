package com.aprog.weeks;

import java.util.*;

public class Ex28 {
    public static void main(String[] args) {
        int num, saco = 0, count = 0;
        Scanner ler = new Scanner(System.in);
        do {
            num = ler.nextInt();
            saco = verificarPalindrome(num);
            if (saco == num) {
                System.out.println("palindrome");
            } else {
                count++;
                if (count == 5) {
                    System.out.println("attempts exceeded");
                }
            }
        } while (saco != num && count < 5);
        ler.close();
    }

    public static int verificarPalindrome(int numero) {
        int num = numero;
        int saco = 0;
        int alg;
        while (num > 0) {
            alg = num % 10;
            num = num / 10;
            saco = saco * 10 + alg;
        }
        return saco;
    }
}