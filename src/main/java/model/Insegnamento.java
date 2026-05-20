package model;

public class Insegnamento {
    public String nome;
    public int CFU, annoCorso;
    public Insegnamento(String nome, int CFU, int annoCorso) {
        this.nome = nome;
        this.CFU = CFU;
        this.annoCorso = annoCorso;
    }
    public String getNome() {return nome;}
    public int getCFU(){return CFU;}
    public int getAnnoCorso(){return annoCorso;}
}
