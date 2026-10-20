package com.aprog.exam_prep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GIF {
    public static final String FILENAME = "Output/histogram.txt";
    public static final String INPUT = "Input/pictureGIF.txt";

    public static void main(String[] args) throws FileNotFoundException {
        int[][] mat256 = readPicture();
        int[][] mat10 = reduceTo10Colours(mat256);
        double[] frequencies = getFrequencies(mat10);
        writeHistogram(FILENAME, frequencies);
    }

    public static int[][] readPicture() {
        return new int[][] {
                { 0, 10, 20, 30, 40 },
                { 50, 100, 150, 200, 255 },
                { 255, 255, 0, 0, 128 },
                { 10, 10, 10, 10, 10 },
                { 5, 5, 5, 5, 5 }
        };
    }

    public static int[][] reduceTo10Colours(int[][] mat256) {
        int rows = mat256.length;
        int cols = mat256[0].length;
        int[][] mat10 = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int valor = mat256[i][j];
                mat10[i][j] = (valor * 10) / 256;
            }
        }
        return mat10;
    }

    public static double[] getFrequencies(int[][] mat10) {
        double[] frequencies = new double[10];
        int[] count = new int[10];

        int rows = mat10.length;
        int cols = mat10[0].length;
        int total = rows * cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int valor = mat10[i][j];
                count[valor]++;
            }
        }

        for (int i = 0; i < frequencies.length; i++) {
            double freq = (double) count[i] / total;
            frequencies[i] = freq * 100.0;
        }
        return frequencies;
    }

    public static void writeHistogram(String fileName, double[] frequencies) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File(fileName));

        for (int i = 0; i < frequencies.length; i++) {
            out.printf("%d ", i);
            out.printf("(%5.1f%%): ", frequencies[i]);

            int qtd = (int) frequencies[i] / 10;
            for (int j = 0; j < qtd; j++) {
                out.print("*");
            }
            out.println();
        }
        out.close();
    }
}
