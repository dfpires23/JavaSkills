package com.aprog.weeks;

import java.util.*;

public class Ex11 {
    public static void main(String[] args) {
        int n, count = 0;
        Scanner ler = new Scanner(System.in);
        n = ler.nextInt();
        if (n < 0) {
            ler.close();
            return;
        }
        for (int i = 2; i <= n; i++) {
            count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(i);
            }
        }
        ler.close();
    }
}