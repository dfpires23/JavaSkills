package com.aprog.exam_prep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SmartPark {
    public static final String INPUT = "Input/entradas.txt";
    public static final String OUTPUT = "Output/relatorio_entradas.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String[][] parque = criarParque();
        inserirEntradas(parque);
        imprimirEntradas(parque);
    }

    public static String[][] criarParque() throws FileNotFoundException {
        Scanner in = new Scanner(new File(INPUT));
        String cabecalho = in.nextLine();
        String[] dims = cabecalho.split(" ");
        int pisos = Integer.parseInt(dims[0].trim());
        int lugares = Integer.parseInt(dims[1].trim());

        String[][] parque = new String[pisos][lugares];
        for (int i = 0; i < pisos; i++) {
            for (int j = 0; j < lugares; j++) {
                parque[i][j] = "LIVRE";
            }
        }
        in.close();
        return parque;
    }

    public static void inserirEntradas(String[][] parque) throws FileNotFoundException {
        Scanner in = new Scanner(new File(INPUT));
        if (in.hasNextLine()) {
            in.nextLine();
        }

        while (in.hasNextLine()) {
            String linha = in.nextLine();
            String[] entrada = linha.split(";");
            if (entrada.length < 4)
                continue;

            String matricula = entrada[0];
            int piso = Integer.parseInt(entrada[1].trim());
            int lugar = Integer.parseInt(entrada[2].trim());
            String veiculo = entrada[3];

            if (piso >= 0 && piso < parque.length && lugar >= 0 && lugar < parque[0].length) {
                if (parque[piso][lugar].equals("LIVRE")) {
                    switch (veiculo) {
                        case "Mota":
                            parque[piso][lugar] = "(M) " + matricula;
                            break;
                        case "Carro":
                            parque[piso][lugar] = "(C) " + matricula;
                            break;
                        case "VIP":
                            parque[piso][lugar] = "*** " + matricula + " ***";
                            break;
                        default:
                            break;
                    }
                } else {
                    System.out.println("Veiculo: " + matricula + " nao tem lugar vago");
                }
            } else {
                System.out.println("Coordenadas inválidas para o veículo: " + matricula);
            }
        }
        in.close();
    }

    public static void imprimirEntradas(String[][] parque) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File(OUTPUT));
        int pisos = parque.length;
        int lugares = parque[0].length;
        for (int i = 0; i < pisos; i++) {
            for (int j = 0; j < lugares; j++) {
                out.printf("%-20s", parque[i][j]);
            }
            out.println();
        }
        out.close();
    }
}
