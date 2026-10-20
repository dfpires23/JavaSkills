package com.aprog.weeks;

import java.util.Scanner;

public class Ex34 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int num = ler.nextInt();
        if (num > 0) {
            int slow = num;
            int fast = num;
            do {
                slow = somarQuadradosDigitos(slow);
                fast = somarQuadradosDigitos(somarQuadradosDigitos(fast));
            } while (slow != fast && slow != 1 && fast != 1);

            if (slow == 1 || fast == 1) {
                imprimirStable(num);
            } else {
                slow = num;
                while (slow != fast) {
                    slow = somarQuadradosDigitos(slow);
                    fast = somarQuadradosDigitos(fast);
                }
                imprimirCyclic(num, slow);
            }
        }
        ler.close();
    }

    public static void imprimirStable(int n) {
        int count = 0;
        int atual = n;
        System.out.print(atual);
        while (atual != 1) {
            int prox = somarQuadradosDigitos(atual);
            count++;
            System.out.print(" > " + prox);
            atual = prox;
        }
        System.out.print("\nStable : " + count);
    }

    public static void imprimirCyclic(int n, int marca) {
        int count = 0;
        int atual = n;
        boolean passouMarca = false;
        System.out.print(atual);
        int prox = somarQuadradosDigitos(atual);
        while (!passouMarca || prox != marca) {
            count++;
            System.out.print(" > " + prox);
            if (prox == marca) {
                passouMarca = true;
            }
            atual = prox;
            prox = somarQuadradosDigitos(atual);
        }
        count++;
        System.out.print(" > " + marca + " ...");
        System.out.print("\nCyclic : " + count);
    }

    public static int somarQuadradosDigitos(int num) {
        int soma = 0;
        while (num != 0) {
            int digito = num % 10;
            soma += digito * digito;
            num /= 10;
        }
        return soma;
    }
}