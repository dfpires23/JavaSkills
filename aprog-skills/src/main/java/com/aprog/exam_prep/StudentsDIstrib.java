package com.aprog.exam_prep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentsDIstrib {
    public static final int MAX_ALUNOS = 100;
    public static final String FILE_NAME = "Input/alunos.txt";
    public static final int FILAS = 7;
    public static final int LUGARES_POR_FILA = 10;
    public static final String[] TURMAS = { "1DA", "1DB", "1DC", "1DD" };

    public static void main(String[] args) throws FileNotFoundException {
        int[] numeros = new int[MAX_ALUNOS];
        String[][] nomesTurmas = new String[MAX_ALUNOS][2];
        int totalAlunos = lerInformacaoDoFicheiro(FILE_NAME, numeros, nomesTurmas);
        int[][] ocupacaoDaSala = obterDistribuicaoDosAlunos(totalAlunos, numeros);
        int[] alunosPorTurma = obterQuantidadeDeAlunosPorTurma(totalAlunos, nomesTurmas);

        // Print a mais
        System.out.println("Distribuicao feita. Total Inscritos: " + totalAlunos);
        for (int i : alunosPorTurma)
            System.out.print(i + " ");

        System.out.println();
        for (int i = 0; i < ocupacaoDaSala.length; i++) {
            for (int j = 0; j < ocupacaoDaSala[0].length; j++) {
                System.out.printf("%-7d ", ocupacaoDaSala[i][j]);
            }
            System.out.println();
        }
    }

    public static int lerInformacaoDoFicheiro(String fileName, int[] numeros, String[][] nomesTurmas)
            throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileName));
        int count = 0;
        while (in.hasNextLine() && count < MAX_ALUNOS) {
            String linha = in.nextLine();
            String[] valores = linha.split(",");
            nomesTurmas[count][0] = valores[0].trim();
            numeros[count] = Integer.parseInt(valores[1]);
            nomesTurmas[count][1] = valores[2].trim();
            count++;
        }
        in.close();
        return count;
    }

    public static int[][] obterDistribuicaoDosAlunos(int totalAlunos, int[] numeros) {
        int[][] distrib = new int[FILAS][LUGARES_POR_FILA];

        int count = 0;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < LUGARES_POR_FILA; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    if (count < totalAlunos) {
                        distrib[i][j] = numeros[count];
                        count++;
                    }
                } else {
                    distrib[i][j] = 0;
                }
            }
        }
        return distrib;
    }

    public static int[] obterQuantidadeDeAlunosPorTurma(int totalAlunos, String[][] nomesTurmas) {
        int[] count = new int[TURMAS.length];

        int capacidadeSala = 0;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < LUGARES_POR_FILA; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    capacidadeSala++;
                }
            }
        }

        int min = capacidadeSala;
        if (min > totalAlunos)
            min = totalAlunos;

        for (int i = 0; i < min; i++) {
            for (int j = 0; j < TURMAS.length; j++) {
                if (nomesTurmas[i][1].equals(TURMAS[j]))
                    count[j]++;
            }
        }
        return count;
    }
}
