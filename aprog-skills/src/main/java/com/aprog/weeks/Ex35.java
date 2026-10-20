package com.aprog.weeks;

import java.util.Scanner;

public class Ex35 {
    public static void main(String[] args) {
        int numA = 0, numB = 0;
        Scanner ler = new Scanner(System.in);
        numA = readPositiveValue(ler, numA);
        numB = readPositiveValue(ler, numB);
        showTablesInRange(numA, numB);
        ler.close();
    }

    public static int readPositiveValue(Scanner ler, int num) {
        do {
            num = ler.nextInt();
        } while (num <= 0);
        return num;
    }

    public static void showTablesInRange(int numA, int numB) {
        if (numA > numB) {
            int temp = numA;
            numA = numB;
            numB = temp;
        }
        for (int i = numA; i <= numB; i++) {
            showTableOfNumber(i);
        }
    }

    public static void showTableOfNumber(int num) {
        System.out.println("Multiplication table of " + num);
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }
}
