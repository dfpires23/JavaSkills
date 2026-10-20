package com.aprog.exam_prep;

public class PtRaces {
    public static final int PILOTOS = 8;
    public static final int CORRIDAS = 6;
    public static final int[] PONTUACAO = { 10, 8, 5, 2, 1 };

    public static void main(String[] args) {
        int[][] classificacoes = lerClassificacoes();
        if (saoClassificacoesCorretas(classificacoes)) {
            int[] pontosTotaisDosPilotos = obterPontuacaoTotalDosPilotos(classificacoes, PONTUACAO);
            mostrarPilotosEmPrimeiroLugar(pontosTotaisDosPilotos);
        }
    }

    public static int[][] lerClassificacoes() {
        return new int[][] {
                { 1, 1, 1, 1, 1, 8 },
                { 2, 2, 2, 2, 2, 7 },
                { 3, 3, 3, 3, 3, 6 },
                { 4, 4, 4, 4, 4, 5 },
                { 5, 5, 5, 5, 5, 4 },
                { 6, 6, 6, 6, 6, 3 },
                { 7, 7, 7, 7, 7, 2 },
                { 8, 8, 8, 8, 8, 1 }
        };
    }

    public static boolean saoClassificacoesCorretas(int[][] array) {
        for (int j = 0; j < CORRIDAS; j++) {
            boolean[] isErro = new boolean[PILOTOS];

            for (int i = 0; i < PILOTOS; i++) {
                int classif = array[i][j];
                if (classif < 1 || classif > PILOTOS) {
                    return false;
                }
                if (isErro[classif - 1]) {
                    return false;
                }
                isErro[classif - 1] = true;
            }
        }
        return true;
    }

    public static int[] obterPontuacaoTotalDosPilotos(int[][] array, int[] pontos) {
        int[] ptsTotais = new int[PILOTOS];

        for (int i = 0; i < PILOTOS; i++) {
            for (int j = 0; j < CORRIDAS; j++) {
                int classif = array[i][j];
                if (classif <= pontos.length) {
                    ptsTotais[i] += pontos[classif - 1];
                }
            }
        }
        return ptsTotais;
    }

    public static void mostrarPilotosEmPrimeiroLugar(int[] array) {
        int max = array[0];
        for (int i = 0; i < PILOTOS; i++) {
            if (array[i] > max)
                max = array[i];
        }
        System.out.printf("Pontuacao maxima=%d :Pilotos=", max);
        for (int i = 0; i < PILOTOS; i++) {
            if (array[i] == max)
                System.out.printf("[%d]", i + 1);
        }
    }
}
