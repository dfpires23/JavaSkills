package com.aprog.weeks;

import java.util.*;

public class Ex27 {
    public static void main(String[] args) {
        int N;
        Scanner ler = new Scanner(System.in);
        N = ler.nextInt();
        for (int i = 0; i < N; i++) {
            int result = verificarArmstrong(i);
            if (result == 1) {
                System.out.println(i);
            }
        }
        ler.close();
    }

    public static int verificarArmstrong(int num) {
        int alg, soma = 0, count = 0;
        int copia = num;
        while (copia > 0) {
            copia /= 10;
            count++;
        }

        copia = num;
        while (copia > 0) {
            alg = copia % 10;
            copia /= 10;
            soma += Math.pow(alg, count);
        }
        if (num == soma) {
            return 1;
        } else {
            return 0;
        }
    }
}
