package com.automovel;

/**
 * Classe que representa um automóvel, com matrícula, marca e cilindrada.
 */
public class Automovel {
    /**
     * Atributos de instância: cada automóvel tem a sua matrícula, marca e
     * cilindrada.
     * Atributo de classe: o total de automóveis criados.
     */
    private String matricula;
    private String marca;
    private int cilindrada;

    private static final String MATRICULA_POR_OMISSAO = "sem matrícula";
    private static final String MARCA_POR_OMISSAO = "sem marca";
    private static final int CILINDRADA_POR_OMISSAO = 0;

    private static int totalAutomoveis = 0;

    /**
     * Construtores para inicializar os atributos de um automóvel.
     * 
     * @param matricula
     * @param marca
     * @param cilindrada
     */
    public Automovel(String matricula, String marca, int cilindrada) {
        this.matricula = matricula;
        this.marca = marca;
        this.cilindrada = cilindrada;
        totalAutomoveis++;
    }

    public Automovel(String matricula, String marca) {
        this.matricula = matricula;
        this.marca = marca;
        cilindrada = CILINDRADA_POR_OMISSAO;
        totalAutomoveis++;
    }

    public Automovel(String marca, int cilindrada) {
        matricula = MATRICULA_POR_OMISSAO;
        this.marca = marca;
        this.cilindrada = cilindrada;
        totalAutomoveis++;
    }

    public Automovel() {
        matricula = MATRICULA_POR_OMISSAO;
        marca = MARCA_POR_OMISSAO;
        cilindrada = CILINDRADA_POR_OMISSAO;
        totalAutomoveis++;
    }

    /**
     * Devolve a matrícula do automóvel.
     * 
     * @return a matrícula do automóvel
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Devolve a marca do automóvel.
     * 
     * @return a marca do automóvel
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Devolve a cilindrada do automóvel.
     * 
     * @return a cilindrada do automóvel
     */
    public int getCilindrada() {
        return cilindrada;
    }

    /**
     * Define a matrícula do automóvel.
     * 
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Define a marca do automóvel.
     * 
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Define a cilindrada do automóvel.
     * 
     * @param cilindrada
     */
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    /**
     * Devolve uma descrição textual do automóvel, com a matrícula, marca e
     * cilindrada.
     * 
     * @return descrição textual do automóvel
     */
    public String toString() {
        return String.format("Automóvel com matrícula %s é um %s e " +
                "tem cilindrada de %d cc", matricula, marca, cilindrada);

        // Alternativa menos eficiente:
        // return "Automóvel com matrícula " + matricula + " é um " + marca +
        // " e tem cilindrada de " + cilindrada + " cc";

    }

    /**
     * Devolve a diferença entre a cilindrada deste automóvel e a de outro
     * automóvel.
     * 
     * @param outroAutomovel
     * @return a diferença entre a cilindrada deste automóvel e a de outro automóvel
     */
    public int calcularDiferencaCilindrada(Automovel outroAutomovel) {
        return cilindrada - outroAutomovel.cilindrada;
        // Alternativa:
        // return cilindrada - outroAutomovel.getCilindrada();
    }

    /**
     * Devolve true se a cilindrada deste automóvel for maior do que a de outro
     * automóvel.
     * 
     * @param outroAutomovel
     * @return true se a cilindrada deste automóvel for maior do que a de outro automóvel
     */
    public boolean isCilindradaMaior(Automovel outroAutomovel) {
        return cilindrada > outroAutomovel.cilindrada;
        // Alternativa:
        // return cilindrada - outroAutomovel.getCilindrada();
    }

    /**
     * Devolve true se a cilindrada deste automóvel for maior do que um valor dado.
     * 
     * @param cilindrada
     * @return true se a cilindrada deste automóvel for maior do que um valor dado
     */
    public boolean isCilindradaMaior(int cilindrada) {
        return this.cilindrada > cilindrada;
    }

    /**
     * Devolve o total de automóveis criados.
     * 
     * @return o total de automóveis criados
     */
    public static int getTotalAutomoveis() {
        return totalAutomoveis;
    }
}
