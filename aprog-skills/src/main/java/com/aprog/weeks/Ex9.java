package com.aprog.weeks;

import java.util.*;

public class Ex9 {
    public static void main(String[] args) {
        int numA, numB;
        Scanner ler = new Scanner(System.in);
        numA = ler.nextInt();
        numB = ler.nextInt();
        if (numA > 0 && numB > 0) {
            int max = Math.max(numA, numB);
            int i = max;
            int out = 0;
            while (out == 0) {
                if (i % numA == 0 && i % numB == 0) {
                    System.out.println(i);
                    out = 1;
                }
                i++;
            }
        } else {
            System.out.println("negative number");
        }
        ler.close();
    }
}