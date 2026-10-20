package com.aprog.weeks;

import java.util.*;

public class Ex3 {
    public static void main(String[] args) {
        int num, alg, prod = 0;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();
        while (num > 0) {
            alg = num % 10;
            num = num / 10;
            if (alg % 2 != 0) {
                if (prod == 0) {
                    prod = 1;
                }
                prod = prod * alg;
            }
        }
        if (prod == 0) {
            System.out.println("no odd digits");
        } else {
            System.out.println(prod);
        }
        ler.close();
    }
}