package com.aprog.weeks;

import java.util.*;

public class Ex26 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String tipo = ler.nextLine();
        while (!tipo.equals("end")) {
            switch (tipo) {
                case "sphere":
                    calcularVolEsfera(ler);
                    break;
                case "cylinder":
                    calcularVolCilindro(ler);
                    break;
                case "cone":
                    calcularVolCone(ler);
                    break;
                default:
                    break;
            }
            tipo = ler.nextLine();
        }
        ler.close();
    }

    public static void calcularVolEsfera(Scanner ler) {
        double raio = ler.nextDouble();
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(raio, 3);
        System.out.printf("%.2f\n", volume);
    }

    public static void calcularVolCilindro(Scanner ler) {
        double raio = ler.nextDouble();
        double altura = ler.nextDouble();
        double volume = Math.PI * Math.pow(raio, 2) * altura;
        System.out.printf("%.2f\n", volume);
    }

    public static void calcularVolCone(Scanner ler) {
        double raio = ler.nextDouble();
        double altura = ler.nextDouble();
        double volume = (1.0 / 3.0) * Math.PI * Math.pow(raio, 2) * altura;
        System.out.printf("%.2f\n", volume);
    }
}