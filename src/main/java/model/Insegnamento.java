package model;

public class Insegnamento {
    public String nome;
    public int CFU, annoCorso;
    public Insegnamento(String nome, int CFU, int annoCorso) {
        this.nome = nome;
        this.CFU = CFU;
        this.annoCorso = annoCorso;
    }
}
