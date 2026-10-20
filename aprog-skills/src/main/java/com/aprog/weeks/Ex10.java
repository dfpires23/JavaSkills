package com.aprog.weeks;

import java.util.*;

public class Ex10 {
    public static void main(String[] args) {
        int n, num, div, count, digits, alg;
        float perc;
        float maxPerc = 0.0F;
        Scanner ler = new Scanner(System.in);
        n = ler.nextInt();
        if (n < 0) {
            ler.close();
            return;
        }
        for (int i = 0; i < n; i++) {
            count = 0;
            digits = 0;
            num = ler.nextInt();
            div = num;
            int temp = num;
            while (temp > 0) {
                alg = temp % 10;
                temp = temp / 10;
                digits++;
                if (alg != 0 && div % alg == 0) {
                    count++;
                }
            }
            perc = ((float) count / digits) * 100;
            System.out.printf("%.2f%%\n", perc);
            if (perc > maxPerc) {
                maxPerc = perc;
            }
        }
        System.out.printf("(%.2f%%)\n", maxPerc);
        ler.close();
    }
}