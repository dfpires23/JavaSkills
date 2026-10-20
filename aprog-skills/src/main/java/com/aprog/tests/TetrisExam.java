package com.aprog.tests;

public class TetrisExam {
    public static void main(String[] args) {
        int[][] boardGame = new int[5][6];
        int[] piecesToRelease = { 2, 3, 4, 2, 5, 1, 0, 0, 3, 4, 5, 1 };

        boolean allReleased = playGame(boardGame, piecesToRelease);
        if (allReleased) {
            System.out.println("YOU WON");
        } else {
            System.out.println("YOU LOST");
        }
    }

    public static int releasePiece(int[][] board, int coluna) {
        int linhas = board.length;
        for (int i = linhas - 1; i >= 0; i--) {
            if (board[i][coluna] == 0) {
                board[i][coluna] = 1;
                return i;
            }
        }
        return -1;
    }

    public static boolean hasFilledLine(int[][] board, int linha) {
        int colunas = board[0].length;
        for (int j = 0; j < colunas; j++) {
            if (board[linha][j] == 0) {
                return false;
            }
        }
        return true;
    }

    public static void removeLine(int[][] board, int linha) {
        int colunas = board[0].length;
        for (int i = linha; i > 0; i--) {
            for (int j = 0; j < colunas; j++) {
                board[i][j] = board[i - 1][j];
            }
        }
        for (int k = 0; k < colunas; k++) {
            board[0][k] = 0;
        }
    }

    public static boolean playGame(int[][] board, int[] jogadas) {
        int n = jogadas.length;
        for (int i = 0; i < n; i++) {
            int coluna = jogadas[i];
            int linha = releasePiece(board, coluna);
            if (linha == -1) {
                return false;
            }
            if (hasFilledLine(board, linha)) {
                removeLine(board, linha);
            }
        }
        return true;
    }
}
