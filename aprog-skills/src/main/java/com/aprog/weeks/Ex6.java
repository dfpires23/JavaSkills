package com.aprog.weeks;

import java.util.*;

public class Ex6 {
    public static void main(String[] args) {
        int num, nump, alg, saco = 0;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();
        nump = num;
        while (num > 0) {
            alg = num % 10;
            num = num / 10;
            saco = saco * 10 + alg;
        }
        if (saco == nump) {
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");

        }
        ler.close();
    }
}