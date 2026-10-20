package com.aprog.exam_prep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AirportOrg {
    public static final String FILENAME = "Input/flights.txt";
    public static final int MAX_LINES = 72;
    public static final int MAX_COLUMNS = 3;

    public static void main(String[] args) throws FileNotFoundException {
        String[] hours = new String[MAX_LINES];
        int[][] airstrips = new int[MAX_LINES][MAX_COLUMNS];

        readFlightsFromFile(FILENAME, hours, airstrips);
        int pista = getAirstripBusiest(airstrips);
        System.out.println("Pista mais movimentada: " + pista);
        int[] soma = getAllAirstripFlights(airstrips);
        for (int i = 0; i < MAX_COLUMNS; i++) {
            System.out.printf("Qtd da pista %d: %d\n", i + 1, soma[i]);
        }
        writeStatistics(hours, airstrips);
    }

    public static void readFlightsFromFile(String fileName, String[] horas, int[][] pistas)
            throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileName));

        int i = 0;
        while (in.hasNextLine() && i < MAX_LINES) {
            String linha = in.nextLine();
            String[] valores = linha.split(",");
            horas[i] = valores[0].trim();
            for (int j = 1; j <= MAX_COLUMNS; j++) {
                pistas[i][j - 1] = Integer.parseInt(valores[j].trim());
            }
            i++;
        }
        in.close();
    }

    public static int getAirstripBusiest(int[][] pistas) {
        int max = pistas[0][1] + pistas[0][2];
        int pista = 0;
        for (int i = 0; i < MAX_LINES; i++) {
            int soma = 0;
            for (int j = 1; j < MAX_COLUMNS; j++) {
                soma += pistas[i][j];
            }
            if (soma > max) {
                max = soma;
                pista = pistas[i][0];
            }
        }
        return pista;
    }

    public static int[] getAllAirstripFlights(int[][] pistas) {
        int[] soma = new int[MAX_COLUMNS];
        int pista;
        for (int i = 0; i < MAX_LINES; i++) {
            pista = pistas[i][0];
            soma[pista - 1] += pistas[i][1] + pistas[i][2];
        }
        return soma;
    }

    public static void writeStatistics(String[] horas, int[][] pistas) {
        int totChegadas = 0;
        int totPartidas = 0;
        for (int i = 0; i < MAX_LINES; i++) {
            totChegadas += pistas[i][1];
            totPartidas += pistas[i][2];
        }
        double medChegadas = (double) totChegadas / MAX_LINES;
        double medPartidas = (double) totPartidas / MAX_LINES;
        System.out.printf("Media de chegadas: %.2f e de partidas: %.2f\n", medChegadas, medPartidas);

        for (int i = 0; i < MAX_LINES; i++) {
            System.out.printf("%s pista %d\n", horas[i], pistas[i][0]);
        }
    }
}
