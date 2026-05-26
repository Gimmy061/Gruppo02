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
    private JLabel lblNumInsegnamenti;
    private JLabel lblNumAule;
    private JLabel lblNumDocenti;
    private JLabel lblNumLezioni;
    private JLabel lblNumConflitti;
    private JLabel lblNumRichieste;
    private JTable tabellaInsegnamenti;
    private JButton nuovoInsegnamentoButton;
    private JTable tabellaAule;


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
            setupTabellaInsegnamenti();
            cambiaSchermata("CardInsegnamenti");
        });
        if (nuovoInsegnamentoButton != null) {
            nuovoInsegnamentoButton.addActionListener((ActionEvent e) -> {
                apriPopupNuovoInsegnamento();
            });
        }
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
        panoramicaGeneraleButton.addActionListener((ActionEvent e) -> {
            aggiornaPanoramica();
            cambiaSchermata("CardPanoramica");
        });
    }
    private void cambiaSchermata(String nomeCarta) {
        CardLayout cl = (CardLayout) panelContenitore.getLayout();
        cl.show(panelContenitore, nomeCarta);
    }
    void aggiornaPanoramica(){
       if (controller != null && lblNumInsegnamenti != null && lblNumAule != null && lblNumLezioni != null && lblNumConflitti != null && lblNumRichieste != null){
            lblNumInsegnamenti.setText(String.valueOf(controller.getNumeroInsegnamenti()));
            lblNumAule.setText(String.valueOf(controller.getNumeroAule()));
            lblNumLezioni.setText(String.valueOf(controller.getNumeroLezioni()));
            lblNumConflitti.setText(String.valueOf(controller.rilevaConflitti().size()));
            lblNumRichieste.setText(String.valueOf(controller.getNumeroRichiesteInAttesa()));
        }
    }
    private void setupTabellaInsegnamenti(){
        if(tabellaInsegnamenti !=null){
            String[] colonne ={
                    "INìnsegnamento","CFU","Anno","Docente Titolare"
            };
            javax.swing.table.DefaultTableModel model=new javax.swing.table.DefaultTableModel(colonne, 0);
            for(model.Insegnamento ins:controller.getInsegnamenti()){
                String nomeDocente=ins.getDocente().getCognome()+" "+ins.getDocente().getNome();
                model.addRow(new Object[]{
                        ins.getNome(), ins.getCFU(), ins.getAnnoCorso(), "Prof. "+nomeDocente
                });
            }
            tabellaInsegnamenti.setModel(model);
            tabellaInsegnamenti.setRowHeight(30);
        }
    }
    private void apriPopupNuovoInsegnamento() {
        JTextField txtNome = new JTextField();
        JComboBox<Integer> comboCFU = new JComboBox<>(new Integer[]{3, 6, 9, 12});
        JComboBox<Integer> comboAnno = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        JComboBox<String> comboDocenti = new JComboBox<>();
        java.util.ArrayList<model.Docente> listaDocenti = controller.getDocenti();
        for (model.Docente d : listaDocenti) {
            comboDocenti.addItem("Prof. " + d.getCognome() + " " + d.getNome());
        }
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.add(new JLabel("Nome Materia: "));
        panel.add(txtNome);
        panel.add(new JLabel("CFU: "));
        panel.add(comboCFU);
        panel.add(new JLabel("Anno di Corso: "));
        panel.add(comboAnno);
        panel.add(new JLabel("Docente Titolare: "));
        panel.add(comboDocenti);
        int result=JOptionPane.showConfirmDialog(this,panel,"Nuovo Insegnamento", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String nome = txtNome.getText();
            int cfu = (Integer) comboCFU.getSelectedItem();
            int anno = (Integer) comboAnno.getSelectedItem();

            if (nome.trim().isEmpty() || listaDocenti == null || listaDocenti.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Non Hai inserito i dati ", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }
            model.Docente docenteScelto = listaDocenti.get(comboDocenti.getSelectedIndex());
            model.Insegnamento nuovoInsegnamento = new model.Insegnamento(nome, cfu, anno, docenteScelto);
            controller.aggiungiInsegnamento(nuovoInsegnamento);
            docenteScelto.aggiungiInsegnamento(nuovoInsegnamento);
            setupTabellaInsegnamenti();
            JOptionPane.showMessageDialog(this, "Insegnamento aggiunto con successo!", "Completato", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void setupTabellaAule(){
        if(tabellaAule!=null){
            String[] colonne={
                    "Aula"
            };
            javax.swing.table.DefaultTableModel model=new javax.swing.table.DefaultTableModel(colonne,0);
            for (model.Aula a:controller.getAule()){
                model.addRow(new Object[]{
                        a.getNome()
                });
            }
            tabellaAule.setModel(model);
            tabellaAule.setRowHeight(30);
        }
    }
    private void apriPopupNuovaAula() {
        JTextField txtNome = new JTextField();
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.add(new JLabel("Nome Aula"));
        panel.add(txtNome);
        int result = JOptionPane.showConfirmDialog(this, panel, "Nuova Aula", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String nome = txtNome.getText();
            if (nome.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Inserisci un nome valido", "ERRORE", JOptionPane.ERROR_MESSAGE);
            }
            model.Aula nuovaAula = new model.Aula(nome);
            controller.aggiungiAula(nuovaAula);
            setupTabellaAule();
            JOptionPane.showMessageDialog(this,"Aula aggiunta con successo","Completato",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void apriPopupNuovaLezione(){
        java.util.ArrayList<model.Insegnamento> listaInsegnamenti=controller.getInsegnamenti();
        java.util.ArrayList<model.Aula>listaAule=controller.getAule();
        if(listaInsegnamenti==null|| listaInsegnamenti.isEmpty()||listaAule==null|| listaAule.isEmpty()){
            JOptionPane.showMessageDialog(this,"Prima di creare una lezione devi aver almeno un Insegnamento e un Aula","ERRORE",JOptionPane.ERROR_MESSAGE);
        }
        JComboBox<String>comboInsegnamenti=new JComboBox<>();
        for (model.Insegnamento ins:listaInsegnamenti){
            comboInsegnamenti.addItem(ins.getNome()+"(Prof. "+ins.getDocente().getCognome()+")");
        }
        JComboBox<String>comboGiorno=new JComboBox<>(controller.getGiorniSettimana());
        String[]orariSingoli={"08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00", "16:00","17:00","18:00","19:00","20:00"};
        JComboBox<String> comboOraInizio=new JComboBox<>(orariSingoli);
        JComboBox<String> comboOraFine=new JComboBox<>(orariSingoli);
        JComboBox<String> comboAule=new JComboBox<>();
        for(model.Aula a:listaAule){
            comboAule.addItem(a.getNome());
        }
        JPanel panel =new JPanel(new GridLayout(5,2,10,10));
        panel.add(new JLabel("Insegnamento: "));
        panel.add(comboInsegnamenti);
        panel.add(new JLabel("Giorno:"));
        panel.add(comboGiorno);
        panel.add(new JLabel("Ora Inizio: "));
        panel.add(comboOraInizio);
        panel.add(new JLabel("Ora Fine: "));
        panel.add(comboOraFine);
        panel.add(new JLabel("Aula: "));
        panel.add(comboAule);
        int result=JOptionPane.showConfirmDialog(this,panel,"Nuova Lezione", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result==JOptionPane.OK_OPTION){
            if(comboOraInizio.getSelectedIndex()>= comboOraFine.getSelectedIndex()){
                JOptionPane.showMessageDialog(this,"Errore: L'ora di fine essere successiva all'ora di inizio","ERRORE ORARIO",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        model.Insegnamento insegnamentoScelto=listaInsegnamenti.get(comboInsegnamenti.getSelectedIndex());
        String giornoScelto=(String) comboGiorno.getSelectedItem();
        String oraInizio=(String) comboOraInizio.getSelectedItem();
        String oraFine=(String) comboOraFine.getSelectedItem();
        model.Aula aulaScelta=listaAule.get(comboAule.getSelectedIndex());
        model.Lezione nuovaLezione=new model.Lezione(insegnamentoScelto, giornoScelto,oraInizio,oraFine,aulaScelta);
        controller.getTutteLezioni().add(nuovaLezione);
        JOptionPane.showMessageDialog(this,"Lezione creataa con successo","Completato",JOptionPane.INFORMATION_MESSAGE);
    }
}
