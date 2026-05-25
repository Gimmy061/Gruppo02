package gui;

import javax.swing.*;
import java.awt.*;
import controller.Controller;

public class Home extends JFrame {
    private Controller controller;
    private JPanel panelHome;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JTextArea textArea1;
    private JButton button1;
    private JPanel panelHome0;
    private JButton button2;


    public static void main(String[] args) {
        Home schermataHome = new Home();
        schermataHome.setVisible(true);
    }
}