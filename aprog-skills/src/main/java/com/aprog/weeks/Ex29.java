package com.aprog.weeks;

import java.util.*;

public class Ex29 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int n = ler.nextInt();
        if (verificarFibonacci(n) == 1) {
            System.out.println("is a Fibonacci number");
        } else {
            System.out.println("is not a Fibonacci number");
        }
        ler.close();
    }

    public static int verificarFibonacci(int n) {
        int x = 0, y = 1, z = 0;
        while (z < n) {
            z = x + y;
            x = y;
            y = z;
        }
        if (z == n) {
            return 1;
        } else {
            return 0;
        }
    }
}