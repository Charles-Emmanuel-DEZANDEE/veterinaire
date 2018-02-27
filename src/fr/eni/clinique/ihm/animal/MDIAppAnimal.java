package fr.eni.clinique.ihm.animal;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MDIAppAnimal extends JFrame {

    private static final long serialVersionUID = 1L;
    private static MDIAppAnimal instance;

    private JLabel labelLogNom;
    private JLabel labelLogPassword;
    private JLabel labelErrorUser;
    private JLabel labelErrorPass;
    private JTextField fieldLogNom;
    private JTextField fieldLogPassword;
    private JButton buttonLogValider;
    private JButton buttonRetour;

    //singleton
    public static synchronized MDIAppAnimal getInstance() throws DALException, BLLException {
        if (instance == null) {
            instance = new MDIAppAnimal();
        }
        return instance;
    }


    private MDIAppAnimal() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 600);
        setResizable(false);
        setTitle("Connexion");
        setVisible(true);

    }

    public void init() throws BLLException, DALException {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Ligne 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(this.getLabelLogNom(), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(this.getFieldLogNom(), gbc);

        // Ligne 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(this.getLabelLogPassword(), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(this.getfieldLogPassword(), gbc);

        //ligne 3
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(this.getButtonLogValider(), gbc);

        setContentPane(panel);
        instance.revalidate();
        instance.repaint();
    }


    public void exit() {
        setVisible(false);
    }
    
    public void afficher() {
        setVisible(true);
    }


    public JLabel getLabelLogNom() {
        if (this.labelLogNom == null) {
            this.labelLogNom = new JLabel("Nom : ");
            this.labelLogNom.setFont(new Font("Serif", Font.PLAIN, 20));
        }
        return this.labelLogNom;
    }

    public JLabel getLabelLogPassword() {
        if (this.labelLogPassword == null) {
            this.labelLogPassword = new JLabel("Mot de passe : ");
            this.labelLogPassword.setFont(new Font("Serif", Font.PLAIN, 20));
        }
        return this.labelLogPassword;
    }

    public JLabel getLabelErrorUser() {
        if (this.labelErrorUser == null) {
            this.labelErrorUser = new JLabel("L'utilisateur est inconnu ");
            this.labelErrorUser.setFont(new Font("Serif", Font.PLAIN, 20));
        }
        return this.labelErrorUser;
    }

    public JLabel getLabelErrorPass() {
        if (this.labelErrorPass == null) {
            this.labelErrorPass = new JLabel("Le mot de passe est faux ");
            this.labelErrorPass.setFont(new Font("Serif", Font.PLAIN, 20));
        }
        return this.labelErrorPass;
    }

    public JTextField getFieldLogNom() {
        if (this.fieldLogNom == null) {
            this.fieldLogNom = new JTextField(20);
        }
        return this.fieldLogNom;
    }

    public JTextField getfieldLogPassword() {
        if (this.fieldLogPassword == null) {
            this.fieldLogPassword = new JTextField(20);
        }
        return this.fieldLogPassword;
    }

    public JButton getButtonLogValider() {
        if (this.buttonLogValider == null) {
            this.buttonLogValider = new JButton("Valider");
            this.buttonLogValider.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        System.out.println("valider");
                    } catch (DALException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (BLLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            });

        }
        return this.buttonLogValider;
    }

    public JButton getButtonAnnuler() {
        if (this.buttonRetour == null) {
            this.buttonRetour = new JButton("Annuler");
//			this.buttonRetour.setActionCommand("validerLogIn");
            this.buttonRetour.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        System.out.println("annuler");
                    } catch (DALException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (BLLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            });

        }
        return this.buttonRetour;
    }

}
