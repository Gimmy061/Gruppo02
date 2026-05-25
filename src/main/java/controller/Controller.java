package controller;

import model.*;

import java.util.ArrayList;
public class Controller {

	// Liste che fungono da Database in memoria
	private ArrayList<Studente> studenti = new ArrayList<>();
	private ArrayList<Docente> docenti = new ArrayList<>();
	private ArrayList<Responsabile> responsabili = new ArrayList<>();
	private ArrayList<Insegnamento> insegnamenti = new ArrayList<>();
	private ArrayList<Lezione> lezioni = new ArrayList<>();
	private ArrayList<Aula> aule = new ArrayList<>();
	private ArrayList<RichiestaSpostamento> richieste = new ArrayList<>();
	private Utente utenteLoggato = null;

	public boolean effettuaLogin(String email, String password) {
		for (Responsabile r : responsabili) {
			if (r.login(email, password)) {
				utenteLoggato = r;
				return true;
			}
		}
		for (Docente d : docenti) {
			if (d.login(email, password)) {
				utenteLoggato = d;
				return true;
			}
		}
		for (Studente s : studenti) {
			if (s.login(email, password)) {
				utenteLoggato = s;
				return true;
			}
		}
		throw new IllegalArgumentException("Errore. Email o password errati.");
	}

	public Utente getUtenteLoggato() {
		return utenteLoggato;
	}
}