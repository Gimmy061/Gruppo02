package model;

public class Studente extends Utente{

    private String matricola;
    private int annoCorso;
    public Studente(String nome, String cognome, String email, String password, String matricola){
        super(nome, cognome, email, password);
        this.matricola=matricola;
        this.annoCorso=1;
    }

    public Studente(String matricola, int annoCorso){
        super(nome, cognome, email, password);
        this.matricola=matricola;
        this.annoCorso=annoCorso;
    }

    public String getMatricola(){
        return matricola;
    }


}
