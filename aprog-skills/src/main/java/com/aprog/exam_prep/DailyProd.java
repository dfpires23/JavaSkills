package com.aprog.exam_prep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DailyProd {
    public static final String INPUT = "Input/producao.txt";
    public static final String OUTPUT = "Output/relatorio_prod.txt";

    public static void main(String[] args) throws FileNotFoundException {
        int[][] mat = lerFicheiro();
        int[] totais = calcTotal(mat);
        int pico = descobrirPico(mat);
        escreverRelatorio(totais, pico);
    }

    public static int[][] lerFicheiro() throws FileNotFoundException {
        Scanner in = new Scanner(new File(INPUT));
        String cabecalho = in.nextLine();
        String[] dims = cabecalho.split(" ");
        int linhas = Integer.parseInt(dims[0].trim());
        int colunas = Integer.parseInt(dims[1].trim());
        int[][] matriz = new int[linhas][colunas];

        int i = 0;
        while (in.hasNextLine() && i < linhas) {
            String linha = in.nextLine();
            String[] valores = linha.split(" ");
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = Integer.parseInt(valores[j].trim());
            }
            i++;
        }
        in.close();
        return matriz;
    }

    public static int[] calcTotal(int[][] mat) {
        int maq = mat.length;
        int tur = mat[0].length;
        int[] arr = new int[maq];

        for (int i = 0; i < maq; i++) {
            int soma = 0;
            for (int j = 0; j < tur; j++) {
                soma += mat[i][j];
            }
            arr[i] = soma;
        }
        return arr;
    }

    public static int descobrirPico(int[][] mat) {
        int maq = mat.length;
        int tur = mat[0].length;
        int[] arr = new int[tur];

        for (int j = 0; j < tur; j++) {
            int soma = 0;
            for (int i = 0; i < maq; i++) {
                soma += mat[i][j];
            }
            arr[j] = soma;
        }
        return calcPico(arr);
    }

    public static int calcPico(int[] arr) {
        int idxMax = -1;
        int max = arr[0];
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            if (arr[i] > max) {
                max = arr[i];
                idxMax = i;
            }
        }
        return idxMax;
    }

    public static void escreverRelatorio(int[] arr, int pico) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File(OUTPUT));
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            out.printf("A producao da maquina nr%d foi: %d\n", i, arr[i]);
        }

        if (pico != -1) {
            out.printf("O pico de producao foi no turno: %d\n", pico);
        } else {
            out.println("Nao houve picos de producao");
        }
        out.close();
    }
}
