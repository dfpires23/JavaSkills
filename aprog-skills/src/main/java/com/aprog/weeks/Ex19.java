package com.aprog.weeks;

import java.util.*;

public class Ex19 {
    public static void main(String[] args) {
        int num, count = 0;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0 && i % 3 == 0) {
                System.out.println(i);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("without dividers multiples of 3");
        }
        ler.close();
    }
}