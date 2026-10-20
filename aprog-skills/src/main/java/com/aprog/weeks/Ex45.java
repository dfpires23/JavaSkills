package com.aprog.weeks;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Ex45 {
    public static final String FILE_PATH = "src/main/java/com/aprog/input45.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String[][] predio = lerDeFicheiro(); // construir predio
        Scanner ler = new Scanner(System.in);
        String proprietario = ler.nextLine(); // inserir proprietario
        encontrarApartamento(predio, proprietario);
        ler.close();
    }

    public static String[][] lerDeFicheiro() throws FileNotFoundException {
        File file = new File(FILE_PATH);
        String[][] predio = new String[3][4];
        Scanner in = new Scanner(file);
        for (int i = 0; i < predio.length; i++) {
            for (int j = 0; j < predio[i].length; j++) {
                if (in.hasNextLine()) {
                    predio[i][j] = in.nextLine();
                } else {
                    predio[i][j] = "";
                }
            }
        }
        in.close();
        return predio;
    }

    public static void encontrarApartamento(String[][] predio, String proprietario) {
        int count = 0;
        for (int i = 0; i < predio.length; i++) {
            for (int j = 0; j < predio[i].length; j++) {
                if (predio[i][j].equals(proprietario)) {
                    System.out.println("name=" + proprietario);
                    System.out.println("entrance=" + (i));
                    System.out.println("floor=" + (j));
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Do not live in the building");
        }
    }
}
