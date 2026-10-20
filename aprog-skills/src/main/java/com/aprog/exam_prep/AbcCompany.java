package com.aprog.exam_prep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class AbcCompany {
    public static void main(String[] args) throws FileNotFoundException {
        final String FILE_TO_SAVE = "Output/linesWithRepeatedValues.txt";
        int[] singles;
        int[][] temperatures = getTemperatures();
        singles = getHowManySingleTemperaturesPerLine(temperatures);
        printThermalHoles(temperatures);
        saveLinesWithoutSingleTemperatures(singles, temperatures, FILE_TO_SAVE);
    }

    public static int[][] getTemperatures() {
        return new int[][] {
                { 10, 10, 20, 20, 50 },
                { 50, 80, 90, 80, 50 },
                { 40, 50, 10, 50, 40 },
                { 30, 30, 100, 30, 30 },
                { 5, 5, 5, 5, 5 }
        };
    }

    public static int countSingleTemperatures(int[] arr) {
        int singles = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    if (arr[i] == arr[j]) {
                        count++;
                        break;
                    }
                }
            }
            if (count == 0) {
                singles++;
            }
        }
        return singles;
    }

    public static int[] getHowManySingleTemperaturesPerLine(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] qtdSingles = new int[rows];
        for (int i = 0; i < rows; i++) {
            int[] linha = new int[cols];
            for (int j = 0; j < cols; j++) {
                linha[j] = mat[i][j];
            }
            qtdSingles[i] = countSingleTemperatures(linha);
        }
        return qtdSingles;
    }

    public static void printThermalHoles(int[][] mat) {
        int count = 0;
        int rows = mat.length;
        int cols = mat[0].length;
        for (int i = 0; i < rows; i++) {
            int hole = 0;
            for (int j = 0; j < cols; j++) {
                int value = mat[i][j];
                if (i > 0) {
                    if (value < mat[i - 1][j]) {
                        hole++;
                    }
                }
                if (i < rows - 1) {
                    if (value < mat[i + 1][j]) {
                        hole++;
                    }
                }
                if (j > 0) {
                    if (value < mat[i][j - 1]) {
                        hole++;
                    }
                }
                if (j < cols - 1) {
                    if (value < mat[i][j + 1]) {
                        hole++;
                    }
                }
                if (hole == 4) {
                    System.out.printf("Thermal hole : (%d,%d)\n", i, j);
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("No Thermal holes");
        }
    }

    public static void saveLinesWithoutSingleTemperatures(int[] arr, int[][] mat, String fileName)
            throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File(fileName));

        int rows = mat.length;
        int cols = mat[0].length;
        for (int i = 0; i < rows; i++) {
            if (arr[i] == 0) {
                for (int j = 0; j < cols; j++) {
                    out.printf("%3d", mat[i][j]);
                }
                out.println();
            }
        }
        out.close();
    }
}
