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
        tabellaOrario = new JTable();
        scrollPane1 = new JScrollPane();
    }

    public static void main(String[] args) {
        controller.Controller fintoController = new controller.Controller();
        STUDENTE finestraTest = new STUDENTE(fintoController);
        finestraTest.setVisible(true);
    }
}



