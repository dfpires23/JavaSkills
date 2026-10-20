package com.aprog.weeks;

import java.util.*;

public class Ex15 {
    public static void main(String[] args) {
        int alergs, num, ingreds, alg1, alg2, temp, s = 0;
        Scanner ler = new Scanner(System.in);
        alergs = ler.nextInt();
        num = ler.nextInt();
        for (int i = 0; i < num; i++) {
            int count = 0;
            ingreds = ler.nextInt();
            int copy = ingreds;
            while (ingreds > 0) {
                temp = alergs;
                alg1 = ingreds % 10;
                ingreds = ingreds / 10;
                do {
                    alg2 = temp % 10;
                    temp = temp / 10;

                    if (alg1 == alg2) {
                        count++;
                    }
                } while (temp > 0);
            }
            if (count == 0) {
                s += 1;
                System.out.printf("Suggestion #%d:%d\n", s, copy);
            }
        }
        ler.close();
    }
}