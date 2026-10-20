package com.aprog.weeks;

import java.util.*;

public class Ex16 {
    public static void main(String[] args) {
        int num, number, temp, algA, algB;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();
        while (num >= 0) {
            number = num;
            int countA = 0, count = 0;
            while (num > 0) {
                countA++;
                algA = num % 10;
                num = num / 10;
                int countB = 0;
                temp = number;
                while (temp > 0 && count < 1) {
                    countB++;
                    if (countA != countB) {
                        algB = temp % 10;
                        temp = temp / 10;
                        if (algA == algB) {
                            System.out.printf("%d : digit (%d) repeated in positions (%d) and (%d)\n", number, algA,
                                    countA, countB);
                            count++;
                        }
                    } else {
                        temp = temp / 10;
                    }
                }
            }
            num = ler.nextInt();
        }
        ler.close();
    }
}