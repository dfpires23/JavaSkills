package com.cumprimentar;

import java.util.Scanner;

/**
 * Classe principal do programa de cumprimentar.
 */
public class MainCumprimentar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Qual o teu nome?");
        Pessoa p1 = new Pessoa(in.nextLine());
        System.out.println("Que idade tens?");
        p1.setIdade(in.nextInt());
        System.out.println(p1.toString());

        in.close();
    }
}
