package com.aprog.weeks;

import java.util.*;

public class Ex24 {
    public static void main(String[] args) {
        int m, n, c, p;
        Scanner ler = new Scanner(System.in);
        m = ler.nextInt();
        n = ler.nextInt();
        if (m >= n) {
            c = combinations(m, n);
            System.out.printf("C(%d,%d)=%d\n", m, n, c);
            p = permutations(m, n);
            System.out.printf("P(%d,%d)=%d\n", m, n, p);
        }
        ler.close();
    }

    public static int factorial(int x) {
        int result = 1;
        for (int i = 2; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public static int combinations(int m, int n) {
        int result = factorial(m) / (factorial(n) * factorial(m - n));
        return result;
    }

    public static int permutations(int m, int n) {
        int result = factorial(m) / factorial(m - n);
        return result;
    }
}