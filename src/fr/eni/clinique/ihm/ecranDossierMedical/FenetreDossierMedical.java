package fr.eni.clinique.ihm.ecranDossierMedical;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.RacesManager;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.DALException;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ListIterator;


public class FenetreDossierMedical extends JFrame {

    private static final long serialVersionUID = 1L;

//    private JPanel panelClient;
//    private JPanel panelGauche;
//    private JPanel panelDroit;
//    private JPanel panelValidation;


    private JLabel labelClient;
    private JLabel Client;

    private JLabel labelAnimal;

    private JLabel labelCode;
//    private JTextField Code;

    private JLabel labelNom;
//    private JTextField fieldNom;
//    private JComboBox<String> cboGenreAnimal;

    private JLabel labelCouleurSexe;
//    private JTextField fieldCouleur;

    private JLabel labelEspeceRace;
//    private JComboBox<String> cboEspece;

//    private JLabel labelRace;
//    private JComboBox<String> cboRace;

    private JLabel labelTatouage;
//    private JTextField fieldTatouage;

    private JLabel labelAntecedents;
    private JTextArea fieldAntecedents;

    private JButton buttonValider;
    private JButton buttonRetour;

    //singleton
//    public static synchronized FenetreDossierMedical getFenetreDossierMedical.this() throws BLLException {
//        if (FenetreDossierMedical.this == null) {
//            FenetreDossierMedical.this = new FenetreDossierMedical();
//        }
//        return FenetreDossierMedical.this;
//    }


    public FenetreDossierMedical() throws BLLException {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 600);
        setResizable(false);
        setTitle("Dossier médical");
        setVisible(true);

    }

    public void init(Animaux animal, Clients client) throws BLLException {



        //panel principal

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        //ligne 1
        gbc.gridwidth = 1;
        gbc.gridx = 3;
        gbc.gridy = 0;
        panel.add(getPanelValidation(animal), gbc);

        //ligne 2
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(getPanelGauche(animal,client), gbc);
        gbc.gridwidth = 3;
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(getPanelDroit(), gbc);


        setContentPane(panel);
        FenetreDossierMedical.this.revalidate();
        FenetreDossierMedical.this.repaint();
    }

    public JPanel getPanelValidation (Animaux animal){
            //panel validation
            JPanel panelValidation = new JPanel();
            panelValidation.setLayout(new GridBagLayout());
            panelValidation.setBorder(new TitledBorder(""));

            GridBagConstraints gbcValider = new GridBagConstraints();
            gbcValider.insets = new Insets(5, 5, 5, 5);
            //ligne 8
            gbcValider.gridwidth = 1;
            gbcValider.gridx = 2;
            gbcValider.gridy = 0;
            panelValidation.add(this.getButtonAnnuler(), gbcValider);
            gbcValider.gridwidth = 1;
            gbcValider.gridx = 3;
            gbcValider.gridy = 0;
            panelValidation.add(this.getButtonLogValider(animal), gbcValider);

        return panelValidation;
    }

    public JPanel getPanelClient (Clients client){
            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            panel.setBorder(new TitledBorder("Client : "));

            gbc.gridx = 0;
            gbc.gridy = 1;
            panel.add(this.getClient(client), gbc);

        return panel;
    }

    public JPanel getPanelGauche (Animaux animal, Clients client){

            JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        //ligne 1
            gbc.gridwidth = 1;
            gbc.gridx = 0;
            gbc.gridy = 0;
            panel.add(this.getPanelClient(client), gbc);


            //ligne 3
            gbc.gridwidth = 1;
            gbc.gridx = 0;
            gbc.gridy = 2;
            panel.add(this.getLabelAnimal(), gbc);
            gbc.gridwidth = 1;
            gbc.gridx = 1;
            gbc.gridy = 2;
            panel.add(this.getLabelCode(animal), gbc);


            //ligne 4
            gbc.gridwidth = 1;
            gbc.gridx = 1;
            gbc.gridy = 3;
            panel.add(this.getLabelNom(animal), gbc);

            //ligne 5
            gbc.gridwidth = 1;
            gbc.gridx = 1;
            gbc.gridy = 4;
            panel.add(this.getLabelCouleurSexe(animal), gbc);

            //ligne 6
            gbc.gridwidth = 1;
            gbc.gridx = 1;
            gbc.gridy = 5;
            panel.add(this.getLabelEspeceRace(animal), gbc);

            //ligne 7
            gbc.gridwidth = 1;
            gbc.gridx = 1;
            gbc.gridy = 6;
            panel.add(this.getLabelTatouage(animal), gbc);

        return panel;

    }

    public JPanel getPanelDroit (){

            JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
            // Ligne 1
            gbc.gridwidth = 1;
            gbc.gridx = 0;
            gbc.gridy = 0;
            panel.add(this.getlabelAntecedents(), gbc);

            // Ligne 2
            gbc.gridwidth = 2;
            gbc.gridx = 0;
            gbc.gridy = 1;
            panel.add(this.getFieldAntecedents(), gbc);

        return panel;

    }


    public void cacher() {
        setVisible(false);
    }

    public void afficher() {
        setVisible(true);
    }

    public JLabel getLabelClient() {
        if (this.labelClient == null) {
            this.labelClient = new JLabel("Client : ");
            this.labelClient.setFont(new Font("Serif", Font.PLAIN, 20));
        }

        return labelClient;
    }

    public JLabel getClient(Clients client) {
        if (this.Client == null) {
            this.Client = new JLabel(client.getClient() + " - " + client.getPrenomClient());
            this.Client.setFont(new Font("Serif", Font.PLAIN, 20));
        }

        return Client;
    }

    public JLabel getLabelAnimal() {
        if (this.labelAnimal == null) {
            this.labelAnimal = new JLabel("Animal : ");
            this.labelAnimal.setFont(new Font("Serif", Font.PLAIN, 20));
        }

        return labelAnimal;
    }

    public JLabel getLabelCode(Animaux animal) {
        if (this.labelCode == null) {
            this.labelCode = new JLabel(String.valueOf(animal.getCodeAnimal()));
            this.labelCode.setFont(new Font("Serif", Font.PLAIN, 20));
        }

        return labelCode;
    }


    public JLabel getLabelNom(Animaux animal) {
        if (this.labelNom == null) {
            this.labelNom = new JLabel(animal.getNomAnimal());
            this.labelNom.setFont(new Font("Serif", Font.PLAIN, 20));
        }

        return labelNom;
    }



    public JLabel getLabelCouleurSexe(Animaux animal) {
        if (this.labelCouleurSexe == null) {
            this.labelCouleurSexe = new JLabel(animal.getCouleur() + "   " + sexAAfficher(animal.getSexe()));
            this.labelCouleurSexe.setFont(new Font("Serif", Font.PLAIN, 20));
        }

        return labelCouleurSexe;
    }


    public JLabel getLabelEspeceRace(Animaux animal) {
        if (this.labelEspeceRace == null) {
            this.labelEspeceRace = new JLabel(animal.getEspece() + " " + animal.getRace());
            this.labelEspeceRace.setFont(new Font("Serif", Font.PLAIN, 20));
        }

        return labelEspeceRace;
    }


    public JLabel getLabelTatouage(Animaux animal) {
        if (this.labelTatouage == null) {
            if (animal.getTatouage().equals("") || animal.getTatouage().equals(null)) {
                this.labelTatouage = new JLabel("Non tatoué");
            } else {
                this.labelTatouage = new JLabel("Toutage : "+animal.getTatouage());
            }
            this.labelTatouage.setFont(new Font("Serif", Font.PLAIN, 20));
        }
        return labelTatouage;
    }

    public JLabel getlabelAntecedents() {
        if (this.labelAntecedents == null) {
            this.labelAntecedents = new JLabel("Antécédents / Consultations");
            this.labelAntecedents.setFont(new Font("Serif", Font.PLAIN, 20));
        }

        return labelAntecedents;
    }

    public JTextArea getFieldAntecedents() {
        if (this.fieldAntecedents == null) {
            this.fieldAntecedents = new JTextArea("test",1,10);
//            this.fieldAntecedents.setBounds(10,30, 200,200);
        }
        return this.fieldAntecedents;
    }


    public JButton getButtonLogValider(Animaux animal) {
        if (this.buttonValider == null) {
            this.buttonValider = new JButton("Valider");
            this.buttonValider.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        System.out.println("valider");
                        DossierMedicalController.getInstance().enregistrer(animal);
                        FenetreDossierMedical.this.dispose();

                    } catch (BLLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("erreur champ");
                        JOptionPane.showMessageDialog(FenetreDossierMedical.this, e1);

                    }
                }
            });

        }
        return this.buttonValider;
    }

    public JButton getButtonAnnuler() {
        if (this.buttonRetour == null) {
            this.buttonRetour = new JButton("Annuler");
            this.buttonRetour.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("retour");
                    FenetreDossierMedical.this.dispose();
                    }
            });

        }
        return this.buttonRetour;
    }

    public String sexAAfficher(String sex) {
        String sexAAfficher = "";
        if (sex.equals("F")) {
            sexAAfficher = "Femelle";
        }
        if (sex.equals("M")) {
            sexAAfficher = "Male";
        }
        if (sex.equals("H")) {
            sexAAfficher = "hermaphrodite";
        }
        return sexAAfficher;
    }


}
