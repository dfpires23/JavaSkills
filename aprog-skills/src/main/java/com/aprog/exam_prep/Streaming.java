package com.aprog.exam_prep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Streaming {
    public static void main(String[] args) throws FileNotFoundException {
        String[] musics = { "On my way", "Memories", "Perfect", "Havana" };
        double[][] info = { { 201.6, 3.25 }, { 189, 2.80 }, { 256.8, 2.75 }, { 202.8, 2.35 } };
        String mostExpensiveMusic = findMostExpensiveMusic(musics, info);
        System.out.println("A mais cara: " + mostExpensiveMusic);
        sort(musics, info);
        double diff = calculateBiggestDifference(info);
        System.out.printf("A maior diferenca: %.2fs", diff);
        writeToFile(musics, info);
    }

    public static String findMostExpensiveMusic(String[] musicas, double[][] info) {
        double max = info[0][1];
        int idx = 0;
        double custo = 0.0;
        for (int i = 0; i < info.length; i++) {
            custo = info[i][1];
            if (custo >= max) {
                max = custo;
                idx = i;
            }
        }
        return musicas[idx];
    }

    public static void sort(String[] musicas, double[][] info) {
        int n = info.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean trocar = false;
                if (info[j][0] > info[j + 1][0]) {
                    trocar = true;
                } else if (info[j][0] == info[j + 1][0]) {
                    if (musicas[j].compareTo(musicas[j + 1]) > 0) {
                        trocar = true;
                    }
                }

                if (trocar) {
                    double[] tempInfo = info[j];
                    info[j] = info[j + 1];
                    info[j + 1] = tempInfo;

                    String tempMusic = musicas[j];
                    musicas[j] = musicas[j + 1];
                    musicas[j + 1] = tempMusic;
                }
            }
        }
    }

    public static double calculateBiggestDifference(double[][] info) {
        int linhas = info.length;
        double min = info[0][0];
        double max = info[linhas - 1][0];
        double diff = max - min;
        return diff;
    }

    public static void writeToFile(String[] musicas, double[][] info) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("Output/musics.txt"));
        for (int i = 0; i < info.length; i++) {
            out.printf("%s / %.2fs / %.2f€\n", musicas[i], info[i][0], info[i][1]);
        }
        out.close();
    }
}
