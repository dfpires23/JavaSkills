package com.aprog.weeks;

import java.util.*;

public class Ex7 {
    public static void main(String[] args) {
        int num, count = 0;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();
        if (num > 0) {
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    System.out.println(i);
                    count++;
                }
            }
        } else {
            System.out.println("negative number");
        }
        System.out.println("(" + count + ")");
        ler.close();
    }
}