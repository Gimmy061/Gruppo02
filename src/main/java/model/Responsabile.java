package model;

import java.util.ArrayList;

public class Responsabile extends Docente{
    private ArrayList<Lezione>LezioniImpostate;
    public Responsabile(String nome, String cognome, String email, String password){
        super(nome, cognome, email, password);
        LezioniImpostate= new ArrayList<>();
    }
    public void addLezione(Lezione lezione) {
        this.LezioniImpostate.add(lezione);
    }
    public ArrayList<Lezione> getLezione() {
        return LezioniImpostate;
    }
}
