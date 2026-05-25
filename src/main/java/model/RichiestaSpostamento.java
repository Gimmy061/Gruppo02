package model;

public class RichiestaSpostamento {
    private Lezione lezionedaSpostare;
    private String NuovoGiornoLezione;
    private String NuovaOraInizio;
    private String NuovaOraFine;
    private String stato;

    public RichiestaSpostamento(Lezione lezionedaSpostare, String NuovoGironoLezione, String NuovaOraInizio, String NuovaOraFine){
        this.lezionedaSpostare=lezionedaSpostare;
        this.NuovoGiornoLezione=NuovoGironoLezione;
        this.NuovaOraInizio=NuovaOraInizio;
        this.NuovaOraFine=NuovaOraFine;
        this.stato="In attesa";
    }
    public Lezione getLezionedaSpostare(){
        return lezionedaSpostare;
    }
    public String getNuovoGiornoLezione(){
        return NuovoGiornoLezione;
    }
    public String getNuovaOraInizio(){
        return NuovaOraInizio;
    }
    public String getNuovaOraFine(){
        return NuovaOraFine;
    }
    public String getStato(){
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
}
