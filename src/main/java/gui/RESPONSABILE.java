package gui;

import javax.swing.*;
import controller.Controller;
import model.Responsabile;
import java.awt.*;
import java.awt.event.ActionEvent;


public class RESPONSABILE extends JFrame{

    private Controller controller;
    private Responsabile responsabile;
    private JPanel panelResponsabile;
    private JButton insegnamentoButton;
    private JButton auleButton;
    private JButton RIchiesteDiSpostamentoButton;
    private JButton conflittiButton;
    private JButton orarioLezioniButton;
    private JButton panoramicaGeneraleButton;
    private JPanel panelContenitore;
    private JPanel panelPanoramica;
    private JPanel panelInsegnamenti;
    private JPanel panelAule;
    private JPanel panelOrario;
    private JPanel panelConflitti;
    private JPanel panelRichieste;


    public RESPONSABILE(Controller controller) {
        this.controller = controller;
        if(controller.getUtenteLoggato()instanceof Responsabile){
            this.responsabile=(Responsabile) controller.getUtenteLoggato();
        }
        setContentPane(panelResponsabile);
        setTitle("Pannello di Controllo - Responsabile Orari");
        setSize(1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        panoramicaGeneraleButton.addActionListener((ActionEvent e)->{
            cambiaSchermata("CardPanoramica");
        });
        insegnamentoButton.addActionListener((ActionEvent e)->{
            cambiaSchermata("CardInsegnamenti");
        });
        auleButton.addActionListener((ActionEvent e)->{
            cambiaSchermata("CardAule");
        });
        orarioLezioniButton.addActionListener((ActionEvent e)->{
            cambiaSchermata("CardOrario");
        });
        conflittiButton.addActionListener((ActionEvent e) ->{
            cambiaSchermata("CardConflitti");
        });
        RIchiesteDiSpostamentoButton.addActionListener((ActionEvent e)->{
            cambiaSchermata("CardRichieste");
        });

    }
    private void cambiaSchermata(String nomeCarta) {
        CardLayout cl = (CardLayout) panelContenitore.getLayout();
        cl.show(panelContenitore, nomeCarta);
    }
}
