package com.aprog.weeks;

import java.util.*;

public class Ex23 {
    public static void main(String[] args) {
        float a, b, c, angulo;
        Scanner ler = new Scanner(System.in);
        a = ler.nextFloat();
        b = ler.nextFloat();
        c = ler.nextFloat();
        if (a + b > c && a + c > b && b + c > a) {
            System.out.printf("a=%.2f\n", a);
            System.out.printf("b=%.2f\n", b);
            System.out.printf("c=%.2f\n", c);
            angulo = calcularAngulo(a, b, c);
            System.out.printf("ang(a,b)=%.2f\n", angulo);
            angulo = calcularAngulo(a, c, b);
            System.out.printf("ang(a,c)=%.2f\n", angulo);
            angulo = calcularAngulo(b, c, a);
            System.out.printf("ang(b,c)=%.2f\n", angulo);
        } else {
            System.out.println("impossible");
        }
        ler.close();
    }

    public static float calcularAngulo(float x, float y, float z) {
        float result = (float) Math.toDegrees(Math.acos((x * x + y * y - z * z) / (2 * x * y)));
        return result;
    }
}