package com.aprog.weeks;

import java.util.Scanner;

public class Ex39 {
    public static void main(String[] args) {
        int[] numbers;
        Scanner ler = new Scanner(System.in);
        int n = ler.nextInt();
        numbers = new int[n];
        guardarNumeros(numbers, ler);
        System.out.println("always ascending = " + verificarOrdem(numbers));
        ler.close();
    }

    public static void guardarNumeros(int[] numbers, Scanner ler) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = ler.nextInt();
        }
    }

    public static boolean verificarOrdem(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] >= numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
