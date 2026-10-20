package com.aprog.weeks;

import java.util.*;

public class Ex25 {
    public static void main(String[] args) {
        int N, a = 0, b = 0;
        Scanner ler = new Scanner(System.in);
        N = ler.nextInt();
        if (N > 0) {
            for (int i = 0; i < N; i++) {
                int x = ler.nextInt();
                int y = ler.nextInt();
                int result = contarAlgarismos(x, y);
                if (result > 0) {
                    a = x;
                    b = y;
                }
            }
        }
        if (a == 0 && b == 0) {
            System.out.println("no results");
        } else {
            System.out.printf("%d/%d\n", a, b);
        }
        ler.close();
    }

    public static int contarAlgarismos(int x, int y) {
        int count = 0;
        x = reverterNumero(x);
        y = reverterNumero(y);
        while (x > 0 && y > 0) {
            int algX = x % 10;
            x = x / 10;
            int algY = y % 10;
            y = y / 10;

            if (algX == algY) {
                count++;
            }
        }
        return count;
    }

    public static int reverterNumero(int x) {
        int rev = 0;
        while (x > 0) {
            int alg = x % 10;
            rev = rev * 10 + alg;
            x = x / 10;
        }
        return rev;
    }
}