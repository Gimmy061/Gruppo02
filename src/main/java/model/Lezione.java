package model;

public class Lezione {
    public String GiornoSettimana, Orainizio, Orafine;

    public Aula aula;
    public Responsabile responsabile;
    public Insegnamento insegnamento;
    public OrarioLezioni orarioLezioni;

    public Lezione(String GiornoSettimana, String Orainizio, String Orafine, Aula aula, Responsabile responsabile, OrarioLezioni orarioLezioni){
        this.GiornoSettimana =GiornoSettimana;
        this.Orainizio=Orainizio;
        this.Orafine=Orafine;
        this.aula=aula;
        this.responsabile=responsabile;
        this.insegnamento=insegnamento;
        this.orarioLezioni=orarioLezioni;
    }

    public String setGiornoSettimana(String giornoSettimana) {
        GiornoSettimana = giornoSettimana;
    }
    public String getGiornoSettimana(){
        return GiornoSettimana;
    }
    public String setOrainizio(String orainizio){
        Orainizio=orainizio;
    }
    public String getOrainizio(){
        return Orainizio;
    }
    public String setOrafine(String orafine){
        Orafine=orafine;
    }
    public String getOrafine(){
        return Orafine;
    }
}
