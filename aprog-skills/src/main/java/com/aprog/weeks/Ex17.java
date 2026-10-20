package com.aprog.weeks;

import java.util.*;

public class Ex17 {
    public static void main(String[] args) {
        int num, number = 0;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();
        while (num != 0) {
            int temp = num;
            int rev = 0;
            while (temp > 0) {
                int alg = temp % 10;
                rev = rev * 10 + alg;
                temp = temp / 10;
            }
            while (rev > 0) {
                int copy = number;
                int count = 0;
                int algA = rev % 10;
                rev = rev / 10;
                while (copy > 0) {
                    int algB = copy % 10;
                    copy = copy / 10;
                    if (algA == algB) {
                        count++;
                    }
                }
                if (count == 0 && algA != 0) {
                    number = number * 10 + algA;
                }
            }
            num = ler.nextInt();
        }
        if (number != 0) {
            System.out.println(number);
        }
        ler.close();
    }
}