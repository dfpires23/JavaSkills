package com.aprog.weeks;

import java.util.*;

public class Ex8 {
    public static void main(String[] args) {
        int num, count = 0;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();
        if (num > 0) {
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println("prime");
            } else {
                System.out.println("not prime");
            }
        } else {
            System.out.println("negative number");
        }
        ler.close();
    }
}