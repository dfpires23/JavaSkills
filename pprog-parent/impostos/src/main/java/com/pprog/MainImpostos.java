package com.pprog;

public class MainImpostos {
    public static void main(String[] args) {
        Reformado r1 = new Reformado("João Silva", "Rua A, 123", 1000);
        Reformado r2 = new Reformado("Maria Santos", "Rua B, 456", 2000);

        ContaOutrem c1 = new ContaOutrem("João Silva", "Av. Principal, 789", "Tech Corp", 5000);
        ContaOutrem c2 = new ContaOutrem("Maria Santos", "Av. Secundária, 101", "B Corp", 7500);

        ContaPropria cp1 = new ContaPropria("Carlos Mendes", "Rua C, 202", "Programador", 30000);
        ContaPropria cp2 = new ContaPropria("Roberto Alves", "Rua D, 303", "Consultoria", 60000);

        Desempregado d1 = new Desempregado("Pedro Costa", "Rua E, 404", 6, 500);
        Desempregado d2 = new Desempregado("Ana Oliveira", "Rua F, 505", 12, 1000);

        Object arr[] = new Object[10];
        arr[0] = r1;
        arr[1] = r2;
        arr[2] = c1;
        arr[3] = c2;
        arr[4] = cp1;
        arr[5] = cp2;
        arr[6] = d1;
        arr[7] = d2;

        System.out.println("Impostos de todos os contribuintes:");
        imprimirImpostos(arr);

        System.out.println("\nImpostos dos desempregados:");
        imprimirImpostosDesempregados(arr);
    }

    public static void imprimirImpostos(Object[] arr) {
        for (Object obj : arr) {
            if (obj instanceof Contribuinte) {
                Contribuinte c = (Contribuinte) obj;
                System.out.printf("%s, imposto: %.2f%n", c.toString(), c.calcularImposto());
            }
        }
    }

    public static void imprimirImpostosDesempregados(Object[] arr) {
        for (Object obj : arr) {
            if (obj instanceof Desempregado) {
                Desempregado d = (Desempregado) obj;
                System.out.printf("%s, imposto: %.2f%n", d.toString(), d.calcularImposto());
            }
        }
    }
}