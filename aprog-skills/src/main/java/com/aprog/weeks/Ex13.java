package com.aprog.weeks;

import java.util.*;

public class Ex13 {
    public static void main(String[] args) {
        int n, x = 0, y = 1, z = 0;
        Scanner ler = new Scanner(System.in);
        n = ler.nextInt();
        for (int i = 0; i < n; i++) {
            if (i <= 1) {
                z = i;
            } else {
                z = x + y;
                x = y;
                y = z;
            }
            System.out.println(z);
        }
        ler.close();
    }
}