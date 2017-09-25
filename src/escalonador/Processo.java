package escalonador;

public class Processo implements Comparable<Processo> {

    private int id;
    private int tempoChegada;
    private int duracao;
    private int duracaoRestante;
    public Processo(int id, int tempoChegada, int duracao) {
        this.id = id;
        this.tempoChegada = tempoChegada;
        this.duracao = duracao;
        this.duracaoRestante = duracao;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getTempoChegada() {
        return tempoChegada;
    }
    public void setTempoChegada(int tempoChegada) {
        this.tempoChegada = tempoChegada;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public int getDuracaoRestante() {
        return duracaoRestante;
    }
    public void setDuracaoRestante(int duracaoRestante) {
        this.duracaoRestante = duracaoRestante;
    }
    
    //Ordena a lista de acordo com a duracao e tempo de chegada

    public int compareTo(Processo p) {

        if ((this.tempoChegada < p.getTempoChegada() || this.tempoChegada == p.getTempoChegada())
                && (this.getDuracao() < p.getDuracao())) {
            return -1;
        } 
        else if ((this.tempoChegada > p.getTempoChegada() || (this.tempoChegada == p.getTempoChegada())
                && this.getDuracao() > p.getDuracao())) {
            return 1;
        } 
        else {
            return 0;
        }
    }
    
    @Override
    public String toString() {
        return "P" + getId() + "(" + getTempoChegada() + " " + getDuracao() + ")";
    }
}

