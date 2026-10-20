package com.pprog;

/**
 * Classe que representa um utente de um ginásio, com atributos como nome,
 * género, idade, altura e peso.
 * 
 */
public class Utente {
    /**
     * Atributos de instância.
     * 
     */
    private String nome;
    private String genero;
    private int idade;
    private double altura;
    private double peso;

    /**
     * Constantes para valores por defeito e limites de IMC.
     * 
     */
    private static final String DEF_NOME = "sem nome";
    private static final String DEF_GENERO = "sem genero";
    private static final int DEF_IDADE = 0;
    private static final double DEF_ALTURA = 0;
    private static final double DEF_PESO = 0;

    /**
     * Limites de IMC.
     * 
     */
    private static final double IMC_MIN = 18.0;
    private static final double IMC_MAX = 25.0;

    /**
     * Contador de utentes criados.
     * 
     */
    private static int contadorUtentes = 0;

    /**
     * Construtor padrão.
     * 
     */
    public Utente() {
        this.nome = DEF_NOME;
        this.genero = DEF_GENERO;
        this.idade = DEF_IDADE;
        this.altura = DEF_ALTURA;
        this.peso = DEF_PESO;
        contadorUtentes++;
    }

    /**
     * Construtor com nome e idade, usando valores por defeito para os outros
     * atributos.
     * 
     * @param nome
     * @param idade
     */
    public Utente(String nome, int idade) {
        this.nome = nome;
        this.genero = DEF_GENERO;
        this.idade = idade;
        this.altura = DEF_ALTURA;
        this.peso = DEF_PESO;
        contadorUtentes++;
    }

    /**
     * Construtor completo, que inicializa todos os atributos do utente.
     * 
     * @param nome
     * @param genero
     * @param idade
     * @param altura
     * @param peso
     */
    public Utente(String nome, String genero, int idade, double altura, double peso) {
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        contadorUtentes++;
    }

    /**
     * Devolve o nome do utente.
     * 
     * @return nome do utente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve o género do utente.
     * 
     * @return género do utente
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Devolve a idade do utente.
     * 
     * @return idade do utente
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Devolve a altura do utente.
     * 
     * @return altura do utente
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Devolve o peso do utente.
     * 
     * @return peso do utente
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Devolve o número de utentes criados.
     * 
     * @return número de utentes criados
     */
    public static int getContadorUtentes() {
        return contadorUtentes;
    }

    /**
     * Define o nome do utente.
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define o género do utente.
     * 
     * @param genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Define a idade do utente.
     * 
     * @param idade
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Define a altura do utente.
     * 
     * @param altura
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * Define o peso do utente.
     * 
     * @param peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Devolve uma representação textual do utente.
     * 
     * @return representação textual do utente
     */
    @Override
    public String toString() {
        return String.format("Utente: %s, Genero: %s, Idade: %d, " +
                "Altura: %.2f, Peso: %.2f", nome, genero, idade, altura, peso);
    }

    /**
     * Calcula a diferença de idades entre este utente e outro.
     * 
     * @param outro
     * @return diferença de idades
     */
    public int diferencaIdades(Utente outro) {
        return Math.abs(this.idade - outro.idade);
    }

    /**
     * Calcula o Índice de Massa Corporal (IMC) do utente.
     * 
     * @return IMC do utente
     */
    public double calcularIMC() {
        if (altura <= 0) {
            return 0;
        }
        return peso / (altura * altura);
    }

    /**
     * Devolve o grau de obesidade do utente com base no IMC.
     * 
     * @return grau de obesidade
     */
    public String grauObesidade() {
        double imc = calcularIMC();

        if (imc == 0) {
            return "IMC inválido";
        }

        if (imc < IMC_MIN) {
            return "Magro";
        } else if (imc <= IMC_MAX) {
            return "Saudavel";
        } else {
            return "Obeso";
        }
    }

    /**
     * Verifica se o utente é saudável.
     * 
     * @return true se o utente é saudável, false caso contrário
     */
    public boolean isSaudavel() {
        return grauObesidade().equals("Saudavel");
    }

    /**
     * Verifica se este utente é mais novo que outro.
     * 
     * @param outro
     * @return mensagem indicando quem é mais novo
     */
    public String compararIdades(Utente outro) {
        if (this.idade < outro.idade) {
            return String.format("%s é mais novo que %s", this.nome, outro.nome);
        } else if (this.idade > outro.idade) {
            return String.format("%s é mais novo que %s", outro.nome, this.nome);
        } else {
            return String.format("%s e %s têm a mesma idade", this.nome, outro.nome);
        }
    }
}
