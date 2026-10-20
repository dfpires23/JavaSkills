package com.aprog.weeks;

import java.util.Scanner;

public class Ex38 {
    public static void main(String[] args) {
        int[] numbers;
        int i = 0;
        Scanner ler = new Scanner(System.in);
        numbers = new int[10];
        numbers[0] = ler.nextInt();
        while (numbers[i] >= 0) {
            i++;
            numbers[i] = ler.nextInt();
        }
        if (i > 0) {
            System.out.printf("min=%d\n", encontrarMinimo(numbers, i));
            System.out.printf("occurrences=%d\n", encontrarOcorrencias(numbers, i));
        }
        ler.close();
    }

    public static int encontrarMinimo(int[] numbers, int length) {
        int min = numbers[0];
        for (int i = 1; i < length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static int encontrarOcorrencias(int[] numbers, int length) {
        int min = encontrarMinimo(numbers, length);
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] == min) {
                count++;
            }
        }
        return count;
    }
}
