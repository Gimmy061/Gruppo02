package model;

import java.util.ArrayList;

public class Docente extends Utente{
    private ArrayList<Insegnamento> insegnamenti;

    public Docente(String nome, String cognome, String email, String password) {
        super(nome, cognome, email, password);
        insegnamenti=new ArrayList<>();
    }

    public boolean aggiungiInsegnamento(Insegnamento insegnamento) {
        if (insegnamenti.contains(insegnamento)) {
            return false;
        } else {
            insegnamenti.add(insegnamento);
            return true;
        }
    }
        public void rimuoviInsegnamento(Insegnamento insegnamento){
            insegnamenti.remove(insegnamento);
        }


    }





