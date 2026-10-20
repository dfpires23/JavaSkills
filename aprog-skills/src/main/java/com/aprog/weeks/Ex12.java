package com.aprog.weeks;

import java.util.*;

public class Ex12 {
    public static void main(String[] args) {
        int n, count = 0, number = 2;
        Scanner ler = new Scanner(System.in);
        n = ler.nextInt();
        while (count < n) {
            int soma = 0;
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    soma += i;
                }
            }
            if (soma == number) {
                System.out.println(number);
                count++;
            }
            number++;
        }
        ler.close();
    }
}
