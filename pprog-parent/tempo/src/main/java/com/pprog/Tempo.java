package com.pprog;

/**
 * Classe que representa um tempo, com atributos para hora, minuto e segundo.
 * 
 */
public class Tempo {
    /**
     * Atributos de instância.
     * 
     */
    private int hora;
    private int minuto;
    private int segundo;

    /**
     * Valor por defeito para os atributos.
     * 
     */
    private static final int DEF_OMISSAO = 0;

    /**
     * Construtor padrão.
     * 
     */
    public Tempo () {
        this.hora = DEF_OMISSAO;
        this.minuto = DEF_OMISSAO;
        this.segundo = DEF_OMISSAO;
    }

    /**
     * Construtor com hora.
     * 
     * @param hora
     */
    public Tempo (int hora) {
        this.hora = hora;
        this.minuto = DEF_OMISSAO;
        this.segundo = DEF_OMISSAO;
    }

    /**
     * Construtor com hora e minuto.
     * 
     * @param hora
     * @param minuto
     */
    public Tempo (int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = DEF_OMISSAO;
    }

    /**
     * Construtor com hora, minuto e segundo.
     * 
     * @param hora
     * @param minuto
     * @param segundo
     */
    public Tempo (int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    /**
     * Devolve a hora do tempo.
     * 
     * @return hora do tempo
     */
    public int getHora() {
        return hora;
    }

    /**
     * Devolve o minuto do tempo.
     * 
     * @return minuto do tempo
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * Devolve o segundo do tempo.
     * 
     * @return segundo do tempo
     */
    public int getSegundo() {
        return segundo;
    }

    /**
     * Define a hora do tempo.
     * 
     * @param hora
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * Define o minuto do tempo.
     * 
     * @param minuto
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    /**
     * Define o segundo do tempo.
     * 
     * @param segundo
     */
    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    /**
     * Devolve a representação do tempo no formato HH:MM:SS.
     * 
     * @return representação do tempo
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    /**
     * Devolve a representação do tempo no formato HH:MM:SS AM/PM.
     * 
     * @return representação do tempo em formato 12 horas
     */
    public String toString12h() {
        int hora12 = hora % 12;
        if (hora12 == 0) {
            hora12 = 12;
        }
        String amPm = (hora < 12) ? "AM" : "PM";
        return String.format("%02d:%02d:%02d %s", hora12, minuto, segundo, amPm);
    }

    /**
     * Adiciona um segundo ao tempo, ajustando os minutos e horas conforme necessário.
     * 
     */
    public void adicionar1Segundo() {
        segundo++;
        if (segundo >= 60) {
            segundo = 0;
            minuto++;
            if (minuto >= 60) {
                minuto = 0;
                hora++;
                if (hora >= 24) {
                    hora = 0;
                }
            }
        }
    }

    /**
     * Compara este tempo com outro, devolvendo true se este tempo for maior que o outro.
     * 
     * @param outro
     * @return true se este tempo for maior que o outro, false caso contrário
     */
    public boolean eTempoMaior(Tempo outro) {
        if (this.hora > outro.hora) {
            return true;
        } else if (this.hora < outro.hora) {
            return false;
        } else {
            if (this.minuto > outro.minuto) {
                return true;
            } else if (this.minuto < outro.minuto) {
                return false;
            } else {
                return this.segundo > outro.segundo;
            }
        }
    }

    /**
     * Compara este tempo com um tempo dado por hora, minuto e segundo, devolvendo true se este tempo for maior que o outro.
     * 
     * @param hora
     * @param minuto
     * @param segundo
     * @return true se este tempo for maior que o outro, false caso contrário
     */
    public boolean eTempoMaior(int hora, int minuto, int segundo) {
        Tempo outro = new Tempo(hora, minuto, segundo);
        return this.eTempoMaior(outro);
    }

    /**
     * Devolve a diferença em segundos entre este tempo e outro.
     * 
     * @param outro
     * @return diferença em segundos
     */
    public int diferencaEmSegundos(Tempo outro) {
        int thisTotalSegundos = this.hora * 3600 + this.minuto * 60 + this.segundo;
        int outroTotalSegundos = outro.hora * 3600 + outro.minuto * 60 + outro.segundo;
        return Math.abs(thisTotalSegundos - outroTotalSegundos);
    }

    /**
     * Devolve a diferença entre este tempo e outro como um novo objeto Tempo.
     * 
     * @param outro
     * @return diferença como novo objeto Tempo
     */
    public Tempo diferencaEmTempo(Tempo outro) {
        int diferencaSegundos = this.diferencaEmSegundos(outro);
        int horas = diferencaSegundos / 3600;
        int minutos = (diferencaSegundos % 3600) / 60;
        int segundos = diferencaSegundos % 60;
        return new Tempo(horas, minutos, segundos);
    }
}
