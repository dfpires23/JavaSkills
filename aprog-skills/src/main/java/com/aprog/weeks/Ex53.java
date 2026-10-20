package com.aprog.weeks;

import java.util.Scanner;

public class Ex53 {
    public static final Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int entradas = ler.nextInt();
        int pisos = ler.nextInt();
        ler.nextLine();
        if (entradas <= 0 || pisos <= 0)
            return;
        String[][] predio = preencherPredio(entradas, pisos);
        String busca = ler.nextLine();
        procurarProprietario(predio, busca);
    }

    public static String[][] preencherPredio(int entradas, int pisos) {
        String[][] predio = new String[pisos][entradas];
        for (int i = 0; i < entradas; i++) {
            for (int j = 0; j < pisos; j++) {
                predio[j][i] = ler.nextLine();
            }
        }
        return predio;
    }

    public static void procurarProprietario(String[][] predio, String busca) {
        int pisos = predio.length;
        int entradas = predio[0].length;
        boolean found = false;
        for (int i = 0; i < entradas; i++) {
            for (int j = 0; j < pisos; j++) {
                if (predio[j][i].equals(busca)) {
                    System.out.println("name=" + busca);
                    System.out.println("entrance=" + i);
                    System.out.println("floor=" + j);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Do not live in the building");
        }
    }
}
