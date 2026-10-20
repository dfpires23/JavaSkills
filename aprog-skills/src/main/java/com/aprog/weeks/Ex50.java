package com.aprog.weeks;

import java.util.Scanner;

public class Ex50 {
    public static final Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int n = ler.nextInt();
        if (n <= 1 || n > 20) {
            return;
        }
        int matriz[][] = new int[n][n];
        preencherMatriz(matriz, n);
        imprimirDiagonaisSuperiores(matriz, n);
        imprimirDiagonaisInferiores(matriz, n);
    }

    public static void preencherMatriz(int matriz[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = ler.nextInt();
            }
        }
    }

    public static void imprimirDiagonaisSuperiores(int matriz[][], int n) {
        for (int i = n - 1; i >= 0; i--) {
            int linha = 0;
            int coluna = i;
            while (coluna < n && linha < n) {
                System.out.print("[" + matriz[linha][coluna] + "]");
                linha++;
                coluna++;
            }
            System.out.println();
        }
    }

    public static void imprimirDiagonaisInferiores(int matriz[][], int n) {
        for (int i = 1; i < n; i++) {
            int linha = i;
            int coluna = 0;
            while (linha < n && coluna < n) {
                System.out.print("[" + matriz[linha][coluna] + "]");
                linha++;
                coluna++;
            }
            System.out.println();
        }
    }
}
