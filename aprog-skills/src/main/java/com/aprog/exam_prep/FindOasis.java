package com.aprog.exam_prep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindOasis {
    public static final String INPUT = "Input/dados_satelite.txt";
    public static final String OUTPUT = "Output/relatorio_oasis.txt";
    public static final int MAX_HUMIDADE = 50;
    public static final int MAX_HUM_VIZINHOS = 20;

    public static void main(String[] args) throws FileNotFoundException {
        int[][] dados = lerDados();
        boolean[][] oasis = encontrarOasis(dados);
        escreverCoordenadas(oasis);
    }

    public static int[][] lerDados() throws FileNotFoundException {
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
                if (j < valores.length) {
                    matriz[i][j] = Integer.parseInt(valores[j].trim());
                }
            }
            i++;
        }
        in.close();
        return matriz;
    }

    public static boolean[][] encontrarOasis(int[][] mat) {
        int linhas = mat.length;
        int colunas = mat[0].length;
        boolean[][] isOasis = new boolean[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                int humidadeAtual = mat[i][j];
                if (humidadeAtual >= MAX_HUMIDADE) {
                    isOasis[i][j] = true;
                    if (i > 0) {
                        if (mat[i - 1][j] >= MAX_HUM_VIZINHOS)
                            isOasis[i][j] = false;
                    }
                    if (i < linhas - 1) {
                        if (mat[i + 1][j] >= MAX_HUM_VIZINHOS)
                            isOasis[i][j] = false;
                    }
                    if (j > 0) {
                        if (mat[i][j - 1] >= MAX_HUM_VIZINHOS)
                            isOasis[i][j] = false;
                    }
                    if (j < colunas - 1) {
                        if (mat[i][j + 1] >= MAX_HUM_VIZINHOS)
                            isOasis[i][j] = false;
                    }
                } else {
                    isOasis[i][j] = false;
                }
            }
        }
        return isOasis;
    }

    public static void escreverCoordenadas(boolean[][] oasis) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File(OUTPUT));
        int linhas = oasis.length;
        int colunas = oasis[0].length;

        out.println("== Oasis Encontrados ==");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (oasis[i][j]) {
                    out.printf("Coordenadas (%d:%d)\n", i, j);
                }
            }
        }
        out.close();
    }
}
