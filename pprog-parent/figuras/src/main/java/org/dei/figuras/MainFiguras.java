package org.dei.figuras;

public class MainFiguras {

    public static void main(String[] args) {

        System.out.println("\n### Figuras Construídas ###");
        Circulo c1 = new Circulo();
        System.out.println(c1);

        Circulo c2 = new Circulo(5, "amarelo");
        System.out.println(c2);

        Retangulo r1 = new Retangulo();
        System.out.println(r1);

        Retangulo r2 = new Retangulo(5, 2, "azul");
        System.out.println(r2);

        System.out.println("\n### Variável do Tipo Object ###");
        Object obj;
        obj = c1;
        System.out.println(obj.toString());

        obj = r1;
        System.out.println(obj.toString());

        // Armazenamento de Objetos num Contentor do Tipo Array
        Object[] figuras = new Object[10];

        figuras[0] = c1;
        figuras[1] = c2;
        figuras[2] = r1;
        figuras[3] = r2;
        figuras[4] = "teste";

        System.out.println("\n### Listagem de Figuras Armazenadas no Contentor ###");
        for (int i = 0; i < figuras.length; i++) {
            if (figuras[i] instanceof Figura) { // Verificação do Tipo do Objeto
                Figura f = (Figura) figuras[i]; // Downcasting de Object para Figura
                System.out.println(figuras[i]);
                System.out.printf("Area: %.2f\n", f.calcArea());
            }
        }

        System.out.println("\n### Listagem de Figuras Armazenadas (Separadas) no Contentor ###");
        System.out.println("\n## Listagem de Retangulos Armazenados ##");
        for (int i = 0; i < figuras.length; i++) {
            if (figuras[i] instanceof Retangulo) {
                Retangulo r = (Retangulo) figuras[i];
                System.out.println(figuras[i]);
                System.out.printf("Area: %.2f\n", r.calcArea());
            }
        }

        System.out.println("\n## Listagem de Círculos Armazenados ##");
        for (int i = 0; i < figuras.length; i++) {
            if (figuras[i] instanceof Circulo) {
                Circulo c = (Circulo) figuras[i];
                System.out.println(figuras[i]);
                System.out.printf("Area: %.2f\n", c.calcArea());
            }
        }
    }

}
