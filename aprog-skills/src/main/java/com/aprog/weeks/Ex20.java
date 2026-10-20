package com.aprog.weeks;

import java.util.*;

public class Ex20 {
    public static void main(String[] args) {
        int num, count = 0, countEven = 0, countOdd = 0, alg, max = 0;
        float perc = 0.0F;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();
        while (num > 0) {
            alg = num % 10;
            num = num / 10;
            count++;

            if (alg % 2 == 0) {
                countEven++;
            } else {
                if (max < alg) {
                    max = alg;
                }
                countOdd++;
            }
        }
        perc = countEven * 100 / count;
        System.out.printf("%.2f%%\n", perc);
        if (countOdd > 0) {
            System.out.printf("%d\n", max);
        } else {
            System.out.println("no odd digits");
        }
        ler.close();
    }
}