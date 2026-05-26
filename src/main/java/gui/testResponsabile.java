package gui;

import controller.Controller;
import model.Docente;
import model.Responsabile;
import gui.RESPONSABILE;

import javax.swing.*;

public class testResponsabile {

    public static void main(String[] args) {
        // Usiamo SwingUtilities per avviare la grafica in modo sicuro
        SwingUtilities.invokeLater(() -> {

            // 1. Creiamo il "cervello" dell'applicazione
            Controller controller = new Controller();

            // 2. Creiamo un Responsabile finto e diciamo al Controller che ha fatto il login
            Responsabile admin = new Responsabile("Mario", "Rossi", "admin@uni.it", "password123");
            controller.setUtenteLoggato(admin);

            // 3. Creiamo un paio di Docenti finti (fondamentali, altrimenti la tendina del popup insegnamenti è vuota!)
            Docente prof1 = new Docente("Alan", "Turing", "turing@uni.it", "pass");
            Docente prof2 = new Docente("Margherita", "Hack", "hack@uni.it", "pass");

            // Li aggiungiamo al database centrale
            controller.getDocenti().add(prof1);
            controller.getDocenti().add(prof2);

            // 4. (Opzionale) Aggiungiamo un'aula di base per fare i test più velocemente
            model.Aula aulaBase = new model.Aula("Aula Magna");
            controller.aggiungiAula(aulaBase);

            // 5. Creiamo la finestra del Responsabile, le passiamo il controller e la rendiamo visibile!
            RESPONSABILE frameResponsabile = new RESPONSABILE(controller);
            frameResponsabile.setVisible(true);

        });
    }
}
