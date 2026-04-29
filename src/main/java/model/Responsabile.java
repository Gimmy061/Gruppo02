package model;

import java.util.ArrayList;

public class Responsabile extends Docente{
    private ArrayList<Lezione>LezioniImpostate;
    public Responsabile(String nome, String cognome, String email, String password){
        super(nome, cognome, email, password);
    }
    public void addLezione(Lezione lezione) {
        this.lezioniImpostate.add(lezione);
    }
    public List<Lezione> getLezioni() {
        return lezioni;
    }
    public void setLezioni(List<Lezione> lezioni) {
        this.lezioni = lezioni;
    }
}
