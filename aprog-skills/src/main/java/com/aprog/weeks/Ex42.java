package com.aprog.weeks;

import java.util.Scanner;

public class Ex42 {
    public static void main(String[] args) {
        double[] meses = new double[6];
        Scanner ler = new Scanner(System.in);
        lerTaxas(meses, ler);
        double deposito = ler.nextDouble();
        mostrarMontanteFinal(meses, deposito);
    }

    public static void lerTaxas(double[] meses, Scanner ler) {
        for (int i = 0; i < meses.length; i++) {
            meses[i] = ler.nextDouble();
        }
    }

    public static void mostrarMontanteFinal(double[] meses, double deposito) {
        for (int i = 0; i < meses.length; i++) {
            deposito += deposito * meses[i];
        }
        System.out.printf("final value=%.2f\n", deposito);
    }
}
