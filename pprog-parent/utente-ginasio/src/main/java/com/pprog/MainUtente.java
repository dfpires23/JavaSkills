package com.pprog;

public class MainUtente {
    public static void main(String[] args) {
        Utente u1 = new Utente();
        Utente u2 = new Utente("Maria", 30);
        Utente u3 = new Utente("Pedro", 25);
        Utente u4 = new Utente("Ana", "Feminino", 28, 1.65, 60.0);
        Utente u5 = new Utente("Carlos", "Masculino", 35, 1.80, 80.0);

        Object[] utentes = new Object[10];
        utentes[0] = u1;
        utentes[1] = u2;
        utentes[2] = u3;
        utentes[3] = u4;
        utentes[4] = u5;

        System.out.println("\n### Listagem de Utentes Armazenados no Contentor ###");
        for (int i = 0; i < utentes.length; i++) {
            if (utentes[i] instanceof Utente) {
                Utente u = (Utente) utentes[i];
                System.out.println(u);
            }
        }

        System.out.println("\n### Listagem de Utentes com Nome, IMC e Grau de Obesidade ###");
        for (int i = 0; i < utentes.length; i++) {
            if (utentes[i] instanceof Utente) {
                Utente u = (Utente) utentes[i];
                System.out.println("Nome: " + u.getNome() + ", IMC: " + String.format("%.2f", u.calcularIMC())
                        + ", Grau de Obesidade: " + u.grauObesidade());
            }
        }

        System.out.println("\n### Listagem de Utentes Saudáveis ###");
        for (int i = 0; i < utentes.length; i++) {
            if (utentes[i] instanceof Utente) {
                Utente u = (Utente) utentes[i];
                if (u.isSaudavel()) {
                    System.out.println("Nome: " + u.getNome() + ", Grau de Obesidade: " + u.grauObesidade());
                }
            }
        }

        System.out.println("Utente mais novo: " + u4.compararIdades(u5));
    }
}