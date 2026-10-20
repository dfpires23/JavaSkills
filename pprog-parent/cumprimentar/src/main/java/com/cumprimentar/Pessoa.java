package com.cumprimentar;

/**
 * Classe que representa uma pessoa com nome e idade.
 */
public class Pessoa {
    /**
     * Atributos de instância para armazenar o nome e a idade da pessoa.
     */
    private String nome;
    private int idade;

    private static final String NOME_POR_OMISSAO = "sem nome";
    private static final int IDADE_POR_OMISSAO = 0;

    /**
     * Construtores para criar objetos da classe Pessoa.
     */
    public Pessoa() {
        nome = NOME_POR_OMISSAO;
        idade = IDADE_POR_OMISSAO;
    }

    public Pessoa(String nome) {
        this.nome = nome;
        idade = IDADE_POR_OMISSAO;
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    /**
     * Devolve o nome da pessoa.
     * 
     * @return o nome da pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve a idade da pessoa.
     * 
     * @return a idade da pessoa
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Define o nome da pessoa.
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define a idade da pessoa.
     * 
     * @param idade
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Devolve uma representação em String da pessoa, incluindo seu nome e idade.
     * 
     * @return uma String representando a pessoa
     */
    public String toString() {
        return String.format("%s tem %d anos.", nome, idade);
    }
}
