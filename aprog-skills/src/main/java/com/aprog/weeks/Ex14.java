package com.aprog.weeks;

import java.util.*;

public class Ex14 {
    public static void main(String[] args) {
        int num, ant, alg;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();
        ant = num;
        while (num >= 0) {
            if (num > ant) {
                ant = num;
                int count = 0;
                int numA = num % 10;
                num = num / 10;
                while (num > 0) {
                    alg = num % 10;
                    num = num / 10;

                    if (alg >= numA) {
                        count++;
                    }
                    numA = alg;
                }
                if (count == 0) {
                    System.out.println(ant);
                }
            } else {
                ant = num;
            }
            num = ler.nextInt();
        }
        ler.close();
    }
}