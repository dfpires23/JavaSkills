package com.aprog.weeks;

import java.util.*;

public class Ex32 {
    public static void main(String[] args) {
        String frase;
        Scanner ler = new Scanner(System.in);
        frase = ler.nextLine();
        contarPalavras(frase);
        ler.close();
    }

    public static void contarPalavras(String frase) {
        String[] palavras = frase.trim().split(" ");
        int count = 0;
        for (String p : palavras) {
            if (!p.equals("")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
