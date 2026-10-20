package com.aprog.weeks;

import java.util.*;

public class Ex22 {
    public static void main(String[] args) {
        int numAlunos, numDisciplinas, numAprovados, numReprovados;
        String disciplina;
        Scanner ler = new Scanner(System.in);
        numAlunos = ler.nextInt();
        numDisciplinas = ler.nextInt();
        for (int i = 0; i < numDisciplinas; i++) {
            ler.nextLine();
            disciplina = ler.nextLine();
            numAprovados = ler.nextInt();
            numReprovados = numAlunos - numAprovados;
            imprimirGrafico(disciplina, numAprovados, numReprovados);
        }
        ler.close();
    }

    public static void imprimirGrafico(String disciplina, int numAprovados, int numReprovados) {
        System.out.println("Subject: " + disciplina);
        System.out.print("- Approved: ");
        for (int i = 0; i < numAprovados; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print("- Failed: ");
        for (int i = 0; i < numReprovados; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
