package com.aprog.projects;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class NB_1230414_1241793 {

    // ============================================================
    // Constantes
    public static final String FILE_PATH = "Input/moodMap.txt";

    // ============================================================
    public static void main(String[] args) throws FileNotFoundException {
        int[][] moodMap = lerMoodMapDeFicheiro();
        if (moodMap == null) {
            return; // Sai do programa se o moodMap não foi carregado corretamente
        }

        System.out.println("b) Mood (level/day(person)):");
        mostrarMoodMap(moodMap);

        System.out.println();
        System.out.println("c) Average mood each day:");
        mostrarMediaPorDia(moodMap);

        System.out.println();
        System.out.println("d) Average of each person's mood:");
        mostrarMediaPorPessoa(moodMap);

        System.out.println();
        System.out.print("e) Days with the highest average mood ");
        mostrarDiasMaiorHumor(moodMap);

        System.out.println();
        System.out.println("f) Percentage of mood levels:");
        mostrarPercentagens(moodMap);

        System.out.println();
        System.out.println("g) People with emotional disorders:");
        mostrarTranstornosEmocionais(moodMap);

        System.out.println();
        System.out.println("h) People's Mood Level Charts:");
        for (int i = 0; i < moodMap.length; i++) {
            // Passa um array que representa o humor da pessoa na linha i
            mostrarGraficoPessoa(moodMap[i], i);
        }

        System.out.println();
        System.out.println("i) Recommended therapy:");
        mostrarTerapiaRecomendada(moodMap);

        System.out.println();
        System.out.print("j) People with the most similar moods: ");
        mostrarMaisSemelhantes(moodMap);
    }

    // ============================================================
    // Método: lerMoodMapDeFicheiro()
    // == Formato esperado do ficheiro:
    // == 1ª linha: descrição (ignorada)
    // == 2ª linha: número de pessoas e de dias
    // == 3ª linha: começa a matriz moodMap
    // ============================================================
    public static int[][] lerMoodMapDeFicheiro() throws FileNotFoundException {
        File file = new File(FILE_PATH);
        Scanner in = new Scanner(file); // Para ler do ficheiro
        // Scanner in = new Scanner(System.in); // Para ler do teclado

        in.nextLine();
        int numPessoas = in.nextInt();
        int numDias = in.nextInt();

        if (numPessoas <= 0 || numDias <= 0) {
            System.out.println("Erro: Número de pessoas e dias devem ser superiores a 0.");
            in.close();
            return null;
        }
        in.nextLine();
        int[][] moodMap = definirMoodMap(numPessoas, numDias, in);

        in.close();
        return moodMap;
    }

    // ============================================================
    // Método: definirMoodMap()
    // ============================================================
    public static int[][] definirMoodMap(int numPessoas, int numDias, Scanner in) {
        int[][] moodMap = new int[numPessoas][numDias];

        for (int i = 0; i < moodMap.length; i++) { // Linhas
            for (int j = 0; j < moodMap[i].length; j++) { // Colunas
                int num = in.nextInt();

                if (num < 1 || num > 5) {
                    System.out
                            .println("Erro: Valor de humor inválido na linha " + (i + 1) + ", coluna " + (j + 1) + ".");
                    return null;
                } else {
                    moodMap[i][j] = num;
                }
            }
        }

        return moodMap;
    }

    // ============================================================
    // Método: imprimirCabecalho()
    // ============================================================
    public static void imprimirCabecalho(int numDias) {
        System.out.print("day       :");
        for (int i = 0; i < numDias; i++) {
            System.out.printf("%3d ", i);
        }
        System.out.println();

        System.out.print("----------|");
        for (int i = 0; i < numDias; i++) {
            System.out.print("---|");
        }
        System.out.println();
    }

    // ============================================================
    // Método: mostrarMoodMap()
    // ============================================================
    public static void mostrarMoodMap(int[][] moodMap) {
        imprimirCabecalho(moodMap[0].length); // O argumento passado é o número de colunas (dias)

        for (int i = 0; i < moodMap.length; i++) { // Linhas
            System.out.print("Person #" + i + " :");
            for (int j = 0; j < moodMap[i].length; j++) { // Colunas
                System.out.printf("%3d ", moodMap[i][j]);
            }
            System.out.println();
        }
    }

    // ============================================================
    // Método: mostrarMediaPorDia()
    // ============================================================
    public static void mostrarMediaPorDia(int[][] moodMap) {
        imprimirCabecalho(moodMap[0].length); // O argumento passado é o número de colunas (dias)

        System.out.print("mood       ");
        for (int dia = 0; dia < moodMap[0].length; dia++) { // Colunas
            double media = calcularMediaColuna(moodMap, dia);
            System.out.printf("%.1f ", media);
        }
        System.out.println();
    }

    // ============================================================
    // Método: mostrarDiasMaiorHumor()
    // ============================================================
    public static void mostrarDiasMaiorHumor(int[][] moodMap) {
        double[] medias = new double[moodMap[0].length]; // Array do tamanho do número de colunas (dias)
        double maxMedia = 0;

        for (int dia = 0; dia < moodMap[0].length; dia++) { // Colunas
            medias[dia] = calcularMediaColuna(moodMap, dia); // Guarda médias no array

            if (medias[dia] > maxMedia) {
                maxMedia = medias[dia]; // Atualiza o valor máximo encontrado
            }
        }
        System.out.printf("(%.1f): ", maxMedia);
        for (int dia = 0; dia < medias.length; dia++) {
            // Verifica se a média do dia nesta iteração é igual à média máxima
            if (medias[dia] == maxMedia) {
                System.out.print(dia + " ");
            }
        }
        System.out.println();
    }

    // ============================================================
    // Método: calcularMediaColuna()
    // ============================================================
    public static double calcularMediaColuna(int[][] moodMap, int coluna) { // Recebe uma coluna específica
        int soma = 0;

        for (int i = 0; i < moodMap.length; i++) { // Linhas
            soma += moodMap[i][coluna]; // Soma os valores da coluna específica
        }

        return (double) soma / moodMap.length; // Cast para double para evitar divisão inteira
    }

    // ============================================================
    // Método: mostrarMediaPorPessoa()
    // ============================================================
    public static void mostrarMediaPorPessoa(int[][] moodMap) {
        for (int pessoa = 0; pessoa < moodMap.length; pessoa++) { // Linhas
            double media = calcularMediaLinha(moodMap, pessoa);
            System.out.printf("Person #%d : %.1f\n", pessoa, media);
        }
    }

    // ============================================================
    // Método: calcularMediaLinha()
    // ============================================================
    public static double calcularMediaLinha(int[][] moodMap, int linha) { // Recebe uma linha específica
        int soma = 0;

        for (int j = 0; j < moodMap[linha].length; j++) { // Colunas
            soma += moodMap[linha][j]; // Soma os valores da linha específica
        }

        return (double) soma / moodMap[linha].length; // Cast para double para evitar divisão inteira
    }

    // ============================================================
    // Método: mostrarPercentagens()
    // ============================================================
    public static void mostrarPercentagens(int[][] moodMap) {
        int[] contagem = new int[6]; // Os níveis de humor variam entre 1 e 5, o zero não é usado
        int total = moodMap.length * moodMap[0].length; // Total de entradas no moodMap, altura x largura

        for (int i = 0; i < moodMap.length; i++) { // Linhas
            for (int j = 0; j < moodMap[i].length; j++) { // Colunas
                int valor = moodMap[i][j];

                if (valor >= 1 && valor <= 5) {
                    contagem[valor]++; // Acrescenta ao array de contagem na posição do valor
                }
            }
        }
        for (int nivel = 5; nivel >= 1; nivel--) {
            double percent = (contagem[nivel] * 100.0) / total;
            System.out.printf("Mood #%d: %.1f%%\n", nivel, percent);
        }
    }

    // ============================================================
    // Método: mostrarTranstornosEmocionais()
    // ============================================================
    public static void mostrarTranstornosEmocionais(int[][] moodMap) {
        boolean encontrou = false; // Começa false e muda para true se encontrar alguém

        for (int pessoa = 0; pessoa < moodMap.length; pessoa++) { // Linhas
            int maxConsecutivos = calcularMaxConsecutivosLowMood(moodMap[pessoa]);

            if (maxConsecutivos > 1) {
                System.out.printf("Person #%d : %d consecutive days\n", pessoa, maxConsecutivos);
                encontrou = true; // Basta encontrar uma pessoa para mudar para true
            }
        }
        if (!encontrou) { // Lê-se "não encontrou"
            System.out.println("Ninguém");
        }
    }

    // ============================================================
    // Método: mostrarGraficoPessoa()
    // ============================================================
    public static void mostrarGraficoPessoa(int[] humorDias, int pessoaId) { // Recebe um array com valores de uma
                                                                             // pessoa
        int min = 5, max = 1;

        for (int i = 0; i < humorDias.length; i++) { // Para criar o eixo Y do gráfico
            int valor = humorDias[i];

            if (valor < min)
                min = valor;
            if (valor > max)
                max = valor;
        }
        System.out.println("Person #" + pessoaId + ":");
        for (int nivel = max; nivel >= min; nivel--) { // Para criar o eixo Y do gráfico
            System.out.printf("%4d |", nivel);
            for (int i = 0; i < humorDias.length; i++) {
                int valor = humorDias[i];

                if (valor == nivel) {
                    System.out.print("*"); // Marca o ponto no gráfico se o valor corresponder ao nível atual do eixo Y
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.print("Mood +");
        for (int i = 0; i < humorDias.length; i++) {
            if (i % 5 == 0) {
                System.out.print("-----"); // 5 espaços entre cada marca no eixo X
            }
        }
        System.out.println();
        System.out.printf("%7d", 0);
        for (int i = 1; i < humorDias.length; i++) {
            if (i % 5 == 0)
                System.out.printf("%5d", i); // 5 espaços entre cada marca no eixo X
        }
        System.out.println();
    }

    // ============================================================
    // Método: mostrarTerapiaRecomendada()
    // ============================================================
    public static void mostrarTerapiaRecomendada(int[][] moodMap) {
        boolean encontrou = false; // Começa false e muda para true se encontrar alguém

        for (int pessoa = 0; pessoa < moodMap.length; pessoa++) {
            int maxConsecutivos = calcularMaxConsecutivosLowMood(moodMap[pessoa]);
            String terapia = null;

            if (maxConsecutivos >= 5) {
                terapia = "psychological support";
            } else if (maxConsecutivos >= 2) {
                terapia = "listen to music";
            }

            if (terapia != null) {
                System.out.printf("Person #%d : %s\n", pessoa, terapia);
                encontrou = true; // Basta encontrar uma pessoa para mudar para true
            }
        }
        if (!encontrou) { // Lê-se "não encontrou"
            System.out.println("Nenhuma");
        }
    }

    // ============================================================
    // Método: calcularMaxConsecutivosLowMood()
    // ============================================================
    public static int calcularMaxConsecutivosLowMood(int[] humorDias) { // Inicializa um array de inteiros que guarda a
                                                                        // linha do moodMap da pessoa no argumento
        int maxConsecutivos = 0;
        int atual = 0;

        for (int i = 0; i < humorDias.length; i++) {
            if (humorDias[i] < 3) {
                atual++; // Soma dias com humor inferior a 3
                if (atual > maxConsecutivos) { // Atualiza o número máximo de consecutivos
                    maxConsecutivos = atual;
                }
            } else {
                atual = 0; // Porque se o humor não for inferior a 3, reinicia o contador de consecutivos
            }
        }
        return maxConsecutivos;
    }

    // ============================================================
    // Método: mostrarMaisSemelhantes()
    // ============================================================
    public static void mostrarMaisSemelhantes(int[][] moodMap) {
        int maxCoincidencias = 0;
        int pessoaA = -1, pessoaB = -1;

        for (int i = 0; i < moodMap.length - 1; i++) { // Termina em length - 1 para evitar comparar a última pessoa com
                                                       // ela mesma
            for (int j = i + 1; j < moodMap.length; j++) { // Começa em i + 1 para evitar comparar a pessoa com ela
                                                           // mesma e repetições
                int coincidencias = 0;

                for (int k = 0; k < moodMap[i].length; k++) {
                    if (moodMap[i][k] == moodMap[j][k]) {
                        coincidencias++;
                    }
                }

                if (coincidencias > maxCoincidencias) { // Atualiza o máximo e grava os índices das pessoas
                    maxCoincidencias = coincidencias;
                    pessoaA = i;
                    pessoaB = j;
                }
            }
        }

        if (maxCoincidencias > 0) {
            System.out.printf("(Person #%d and Person #%d have the same mood on %d days)\n", pessoaA, pessoaB,
                    maxCoincidencias);
        } else {
            System.out.println("Nenhum");
        }
    }
}