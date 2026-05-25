package gui;

import javax.swing.*;
import controller.Controller;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class STUDENTE extends JFrame{
    private Controller controller;


    public STUDENTE(Controller controller) {
        this.controller = controller;

        tabella.Orario.setModel(model1);
    }
}
