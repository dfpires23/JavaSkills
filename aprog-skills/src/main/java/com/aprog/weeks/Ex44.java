package com.aprog.weeks;

import java.util.Scanner;

public class Ex44 {
    public static void main(String[] args) {
        int num;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();
        int[] sequencia = criarArray(num, ler);
        String comando = ler.nextLine();
        while (!comando.equals("exit")) {
            switch (comando) {
                case "right":
                    swiftRight(sequencia);
                    mostrarSequencia(sequencia);
                    break;
                case "left":
                    swiftLeft(sequencia);
                    mostrarSequencia(sequencia);
                    break;
                default:
                    break;
            }
            comando = ler.nextLine();
        }
    }

    public static int[] criarArray(int num, Scanner ler) {
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ler.nextInt();
        }
        return arr;
    }

    public static void swiftRight(int[] arr) {
        int ultimo = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = ultimo;
    }

    public static void swiftLeft(int[] arr) {
        int primeiro = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = primeiro;
    }

    public static void mostrarSequencia(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i] + "]");
        }
        System.out.println();
    }
}
