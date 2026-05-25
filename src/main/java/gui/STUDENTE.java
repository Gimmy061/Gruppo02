package gui;

import javax.swing.*;
import controller.Controller;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class STUDENTE extends JFrame{
    private Controller controller;
    private JTable tabellaOrario;
    private JScrollPane scrollPane1;
    public STUDENTE(Controller controller) {
        this.controller = controller;
        setContentPane(scrollPane1);
        setTitle("Orario Studente");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        String[] colonne = {"Orario", "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì"};
        DefaultTableModel model = new DefaultTableModel(colonne, 0);
        tabellaOrario.setModel(model);
        tabellaOrario.setRowHeight(40);
    }

    private void createUIComponents() {
        // Creiamo la tabella a mano per accontentarlo
        tabellaOrario = new JTable();
        scrollPane1 = new JScrollPane();
        // Se si lamenta anche dello scrollPane, de-commenta la riga sotto:
        // scrollPane1 = new JScrollPane();
    }

    public static void main(String[] args) {
        // 1. Creiamo un controller fittizio, altrimenti il costruttore va in errore
        controller.Controller fintoController = new controller.Controller();


        STUDENTE finestraTest = new STUDENTE(fintoController);


        finestraTest.setVisible(true);
    }
}



