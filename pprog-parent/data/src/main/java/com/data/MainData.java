package com.data;

public class MainData {
    public static void main(String[] args) {
        Data data1 = new Data(2026, 3, 3);
        System.out.println(data1.toString());

        Data data2 = new Data(1974, 4, 25);
        System.out.println(data2.toAnoMesDiaString());

        boolean eMaior = data1.isMaior(data2);
        System.out.println(eMaior);

        int num1 = data1.calcularDiferenca(data2);
        System.out.println(num1);

        int num2 = data1.calcularDiferenca(2026, 12, 25);
        System.out.println(num2);

        String dia = data2.determinarDiaDaSemana();
        System.out.println(dia);

        int ano1 = data2.getAno();
        boolean eBissexto1 = data2.isAnoBissexto(ano1);
        System.out.println(eBissexto1);

        int ano2 = data2.getAno();
        boolean eBissexto2 = Data.isAnoBissexto(ano2);
        System.out.println(eBissexto2);
    }
}