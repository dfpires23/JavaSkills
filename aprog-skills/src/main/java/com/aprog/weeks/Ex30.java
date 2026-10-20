package com.aprog.weeks;

import java.util.*;

public class Ex30 {
    public static void main(String[] args) {
        int num;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();
        if (num <= 100) {
            int quant = somarTriplas(num);
            System.out.println("triples=" + quant);
        }
        ler.close();
    }

    public static int somarTriplas(int n) {
        int count = 0;
        for (int i = n; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                for (int k = j; k >= 1; k--) {
                    if (i + j + k == n) {
                        System.out.println(i + " + " + j + " + " + k);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
