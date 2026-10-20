package com.aprog.weeks;

import java.util.Scanner;

public class Ex43 {
    public static void main(String[] args) {
        int num;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();
        int[] sequencia = criarArray(num, ler);
        trocarElementos(sequencia);
        mostrarSequencia(sequencia);
    }

    public static int[] criarArray(int num, Scanner ler) {
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ler.nextInt();
        }
        return arr;
    }

    public static void trocarElementos(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void mostrarSequencia(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
