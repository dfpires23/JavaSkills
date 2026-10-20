package com.pprog;

public class MainTempo {
    public static void main(String[] args) {
        Tempo t1 = new Tempo(5, 30, 12);
        System.out.println(t1.toString12h());
        t1.adicionar1Segundo();
        System.out.println(t1.toString12h());

        Tempo t2 = new Tempo(18, 5, 20);
        System.out.println(t2.toString12h());

        System.out.println(t1.eTempoMaior(t2));
        System.out.println(t1.eTempoMaior(23, 7, 4));

        System.out.println(t1.diferencaEmSegundos(t2));
        System.out.println(t1.diferencaEmTempo(t2));
    }
}