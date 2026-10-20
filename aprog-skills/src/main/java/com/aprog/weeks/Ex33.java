package com.aprog.weeks;

import java.util.*;

public class Ex33 {
    public static void main(String[] args) {
        int num, countUnique = 0, countTot = 0, countPos = 0, countNeg = 0;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();
        while (num != 0) {
            int n = contarAlgarismos(num);
            countUnique += contarAlgarismosUnicos(num, n);
            if (num > 0) {
                countPos++;
            } else {
                countNeg++;
            }
            countTot++;
            num = ler.nextInt();
        }
        if (countTot != 0) {
            mostrarEstatísticas(countUnique, countPos, countNeg, countTot);
        }
        ler.close();
    }

    public static int contarAlgarismos(int num) {
        int count = 0;
        num = Math.abs(num);
        while (num > 0) {
            num = num / 10;
            count++;
        }
        return count;
    }

    public static int contarAlgarismosUnicos(int num, int n) {
        int count = 0, copia = num;
        num = Math.abs(num);
        for (int i = 0; i < n; i++) {
            int alg = num % 10;
            num = num / 10;
            int num2 = num;
            for (int j = i + 1; j < n; j++) {
                int alg2 = num2 % 10;
                if (alg == alg2) {
                    count++;
                }
                num2 = num2 / 10;
            }
        }
        if (count == 0) {
            System.out.println(copia);
            return 1;
        }
        return 0;
    }

    public static void mostrarEstatísticas(int countUnique, int countPos, int countNeg, int countTot) {
        float percPos = (countPos * 100.0f) / countTot;
        float percNeg = (countNeg * 100.0f) / countTot;
        float percUnique = (countUnique * 100.0f) / countTot;
        System.out.printf("negatives: %.2f%%\n", percNeg);
        System.out.printf("positives: %.2f%%\n", percPos);
        System.out.printf("with unique digits: %.2f%%\n", percUnique);
    }
}
