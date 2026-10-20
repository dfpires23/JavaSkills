package com.aprog.exam_prep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FireGuard {
    public static final String INPUT = "Input/floresta.txt";
    public static final String OUTPUT = "Output/alerta_incendios.txt";

    public static void main(String[] args) throws FileNotFoundException {
        int[][] floresta = lerSensores();
        double media = calcTempMedia(floresta);
        gerarRelatorioDeRisco(floresta, media);
    }

    public static int[][] lerSensores() throws FileNotFoundException {
        Scanner in = new Scanner(new File(INPUT));
        String head = in.nextLine();
        String[] dims = head.split(" ");
        int r = Integer.parseInt(dims[0].trim());
        int c = Integer.parseInt(dims[1].trim());
        int[][] mat = new int[r][c];

        int i = 0;
        while (in.hasNextLine() && i < r) {
            String linha = in.nextLine();
            String[] valores = linha.split(" ");
            for (int j = 0; j < c; j++) {
                mat[i][j] = Integer.parseInt(valores[j].trim());
            }
            i++;
        }
        in.close();
        return mat;
    }

    public static double calcTempMedia(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int total = r * c;
        double media = 0.0;
        int soma = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                soma += mat[i][j];
            }
        }
        media = (double) soma / total;
        return media;
    }

    public static void gerarRelatorioDeRisco(int[][] mat, double media) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File(OUTPUT));
        out.printf("Media: %.2f\n", media);
        int count = 0;
        int r = mat.length;
        int c = mat[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                boolean risco = false;
                if (mat[i][j] >= 50) {
                    if (i > 0) {
                        if (mat[i - 1][j] >= 40)
                            risco = true;
                    }
                    if (i < r - 1) {
                        if (mat[i + 1][j] >= 40)
                            risco = true;
                    }
                    if (j > 0) {
                        if (mat[i][j - 1] >= 40)
                            risco = true;
                    }
                    if (j < c - 1) {
                        if (mat[i][j + 1] >= 40)
                            risco = true;
                    }
                }

                if (risco) {
                    out.printf("Explosivo: (%d:%d)\n", i, j);
                    count++;
                }
            }
        }
        out.printf("Total de zonas explosivas: %d\n", count);
        out.close();
    }
}
