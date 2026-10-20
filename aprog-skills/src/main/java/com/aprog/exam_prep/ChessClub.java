package com.aprog.exam_prep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChessClub {
    public static final int MAX_MESES = 6;
    public static final int COLUNAS = 4;

    public static void main(String[] args) throws FileNotFoundException {
        String[] meses = new String[MAX_MESES];
        int[][] jogos = new int[MAX_MESES][COLUNAS];

        readInformationFromFile("Input/xadrez1a6.txt", meses, jogos);
        String melhorMes = getTheMostVictoriousMonth(meses, jogos);
        System.out.println("Mes com maior % vitorias: " + melhorMes);
        double[] medias = getAverages(jogos);
        System.out.printf("Medias: Jogos=%.1f | Vit=%.1f | Der=%.1f | Emp=%.1f\n",
                medias[0], medias[1], medias[2], medias[3]);
        writeStatistics(meses, jogos, medias);
    }

    public static void readInformationFromFile(String filename, String[] meses, int[][] jogos)
            throws FileNotFoundException {
        Scanner in = new Scanner(new File(filename));
        int i = 0;
        while (in.hasNextLine() && i < MAX_MESES) {
            String linha = in.nextLine();
            String[] partes = linha.split(",");
            meses[i] = partes[0].trim();
            for (int j = 0; j < COLUNAS; j++) {
                jogos[i][j] = Integer.parseInt(partes[j + 1].trim());
            }
            i++;
        }
        in.close();
    }

    public static String getTheMostVictoriousMonth(String[] meses, int[][] jogos) {
        double maxPercentagem = -1.0;
        String mesVencedor = "";
        for (int i = 0; i < MAX_MESES; i++) {
            int totalJogos = jogos[i][0];
            int vitorias = jogos[i][1];
            double percentagem = (double) vitorias / totalJogos;
            if (percentagem > maxPercentagem) {
                maxPercentagem = percentagem;
                mesVencedor = meses[i];
            }
        }
        return mesVencedor;
    }

    public static double[] getAverages(int[][] jogos) {
        double[] medias = new double[COLUNAS];
        for (int j = 0; j < COLUNAS; j++) {
            int somaColuna = 0;
            for (int i = 0; i < MAX_MESES; i++) {
                somaColuna += jogos[i][j];
            }
            medias[j] = (double) somaColuna / MAX_MESES;
        }
        return medias;
    }

    public static void writeStatistics(String[] meses, int[][] jogos, double[] medias) {
        double mediaJogos = medias[0];
        System.out.printf("Meses com mais de %.1f jogos:\n", mediaJogos);
        for (int i = 0; i < MAX_MESES; i++) {
            if (jogos[i][0] > mediaJogos) {
                System.out.println(meses[i] + " : " + jogos[i][0]);
            }
        }
    }
}