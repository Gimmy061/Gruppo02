package gui;

import javax.swing.*;
import controller.Controller;
import model.Docente;
import model.Responsabile;
import model.Studente;
import model.Utente;

public class Home extends JFrame {
    private Controller controller;
    private JPanel panelHome;
    private JTextField textField2; // Immagino sia per l'email
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JPanel panelHome0;
    private JTextField accediConLeTueTextField;

    public Home() {
        this.controller = new Controller();
        this.setContentPane(panelHome);
        this.setTitle("ACCESSO");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 300);

        loginButton.addActionListener(e -> {

            String email = this.textField2.getText(); // Sostituisci con textArea1 se serve
            String password = String.valueOf(this.passwordField1.getPassword());


            if (controller.effettuaLogin(email, password)) {


                Utente utenteLoggato = controller.getUtenteLoggato();

                if (utenteLoggato instanceof Studente) {


                    STUDENTE schermataStudente = new STUDENTE(controller, (model.Studente) utenteLoggato);
                    schermataStudente.setVisible(true);

                    this.dispose();

                } else if(utenteLoggato instanceof Responsabile){
                    RESPONSABILE schermataRESPONSABILE= new RESPONSABILE(controller);
                    schermataRESPONSABILE.setVisible(true);

                    this.dispose();
                } else if (utenteLoggato instanceof Docente) {
                    DOCENTE schermataDOCENTE = new DOCENTE(controller);
                    schermataDOCENTE.setVisible(true);

                    this.dispose();
                }

            } else {
                // 5. Se il controller restituisce false, le credenziali sono errate
                JOptionPane.showMessageDialog(this, "Email o password errati!", "Errore Login", JOptionPane.ERROR_MESSAGE);
            }
        });
    }


    public static void main(String[] args) {
        Controller c= new Controller();
        Home schermataHome = new Home();
        schermataHome.setVisible(true);
    }
}
