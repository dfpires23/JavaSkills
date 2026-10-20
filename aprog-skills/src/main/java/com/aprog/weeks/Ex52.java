package com.aprog.weeks;

import java.util.Scanner;

public class Ex52 {
    public static final Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int n = ler.nextInt();
        if (n < 0 || n > 100000000)
            return;
        int x = ler.nextInt();
        if (x < 0 || x > 100000000)
            return;
        int[] fatoriais = preencherFatoriais();
        int count = 0;
        for (int i = 0; i <= n; i++) {
            int num = somarFatoriais(i, fatoriais);
            if (num > x)
                count++;
        }
        System.out.println(count);
    }

    public static int[] preencherFatoriais() {
        int[] fatoriais = new int[10];
        for (int i = 0; i <= 9; i++) {
            fatoriais[i] = fatorial(i);
        }
        return fatoriais;
    }

    public static int fatorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int somarFatoriais(int n, int[] fatoriais) {
        int soma = 0;
        while (n > 0) {
            int digito = n % 10;
            soma += fatoriais[digito];
            n /= 10;
        }
        return soma;
    }
}
