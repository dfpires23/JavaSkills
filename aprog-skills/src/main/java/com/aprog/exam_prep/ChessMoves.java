package com.aprog.exam_prep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChessMoves {
    public static final String FILENAME = "Input/chessMoves.txt";
    public static final int BOARD_SIZE = 8;

    public static void main(String[] args) throws FileNotFoundException {
        String[][] board = initializeBoard();
        displayBoard(board);

        System.out.println();
        int[][] jogadas = readMoves(FILENAME);
        int result = playGame(board, jogadas);

        System.out.println();
        if (result == 1) {
            System.out.println("Maiúsculas");
        } else if (result == -1) {
            System.out.println("Minúsculas");
        } else {
            System.out.println("Empate");
        }
    }

    public static String[][] initializeBoard() {
        String[][] board = {
                { "r", "n", "b", "q", "k", "b", "n", "r" },
                { "p", "p", "p", "p", "p", "p", "p", "p" },
                { " ", " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " ", " " },
                { "P", "P", "P", "P", "P", "P", "P", "P" },
                { "R", "N", "B", "Q", "K", "B", "N", "R" }
        };
        return board;
    }

    public static void displayBoard(String[][] mat) {
        int linhas = mat.length;
        int colunas = mat[0].length;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("|");
                System.out.print(mat[i][j]);
            }
            System.out.println("|");
        }
    }

    public static int[][] readMoves(String fileName) throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileName));
        String cabecalho = in.nextLine().trim();
        int qtd = Integer.parseInt(cabecalho);
        int[][] mat = new int[qtd][4];

        int i = 0;
        while (in.hasNextLine() && i < qtd) {
            String linha = in.nextLine();
            String[] valores = linha.split(" ");
            for (int j = 0; j < 4; j++) {
                mat[i][j] = Integer.parseInt(valores[j].trim());
            }
            i++;
        }
        in.close();
        return mat;
    }

    public static int playGame(String[][] tabuleiro, int[][] jogadas) {
        int qtdJogadas = jogadas.length;
        for (int i = 0; i < qtdJogadas; i++) {
            int y1 = jogadas[i][0];
            int x1 = jogadas[i][1];
            int y2 = jogadas[i][2];
            int x2 = jogadas[i][3];
            tabuleiro[y2][x2] = tabuleiro[y1][x1];
            tabuleiro[y1][x1] = " ";
        }
        displayBoard(tabuleiro);

        int count = 0;
        int linhas = tabuleiro.length;
        int colunas = tabuleiro[0].length;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (tabuleiro[i][j].equals("K"))
                    count += 1;
                if (tabuleiro[i][j].equals("k"))
                    count += -1;
            }
        }
        return count;
    }
}
