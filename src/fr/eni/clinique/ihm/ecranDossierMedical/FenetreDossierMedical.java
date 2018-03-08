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
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel2a;
    private JPanel panel2b;
    private JPanel panel2c;
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
        setSize(600, 500);
        setResizable(false);
        setTitle("Dossier medical");
        setVisible(true);
    }

    public void init(Animaux animal, Clients client) throws BLLException {
    	
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(this.getPanel1(animal), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(this.getPanel2(client, animal), gbc);
        
        setContentPane(panel);
        FenetreDossierMedical.this.revalidate();
        FenetreDossierMedical.this.repaint();
    }	
    
    public JPanel getPanel1(Animaux animal){
		if (this.panel1 == null) {
			
			this.panel1 = new JPanel();
			this.panel1.setLayout(new GridBagLayout());
			this.panel1.setBorder(new TitledBorder(""));
			this.panel1.setPreferredSize(new Dimension(550, 45));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			
			gbc.gridwidth = 1;
			gbc.gridx = 0;
			gbc.gridy = 0;
			this.panel1.add(this.getButtonLogValider(animal), gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			this.panel1.add(this.getButtonAnnuler(), gbc);
			
		}
		return this.panel1;
    }
    
    public JPanel getPanel2(Clients client, Animaux animal){
		if (this.panel2 == null) {
			
			this.panel2 = new JPanel();
			this.panel2.setLayout(new GridBagLayout());
			this.panel2.setBorder(new TitledBorder(""));
			this.panel2.setPreferredSize(new Dimension(550, 400));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.gridx = 0;
			gbc.gridy = 0;
			this.panel2.add(this.getPanel2a(client), gbc);
			gbc.gridx = 0;
			gbc.gridy = 1;
			this.panel2.add(this.getPanel2b(animal), gbc);
			gbc.gridheight = 0;
			gbc.gridx = 1;
			gbc.gridy = 0;
			this.panel2.add(this.getPanel2c(client), gbc);
		}
		return this.panel2;
    }
    
    public JPanel getPanel2a(Clients client){
		if (this.panel2a == null) {
			
			this.panel2a = new JPanel();
			this.panel2a.setLayout(new GridBagLayout());
			this.panel2a.setBorder(new TitledBorder("Client : "));
			this.panel2a.setPreferredSize(new Dimension(170, 80));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			
			gbc.gridwidth = 1;
			gbc.gridx = 0;
			gbc.gridy = 0;
			this.panel2.add(this.getClient(client), gbc);

		}
		return this.panel2a;
    }
    
    public JPanel getPanel2b(Animaux animal){
		if (this.panel2b == null) {
			
			this.panel2b = new JPanel();
			this.panel2b.setLayout(new GridBagLayout());
			this.panel2b.setBorder(new TitledBorder(""));
			this.panel2b.setPreferredSize(new Dimension(170, 290));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			
			gbc.gridwidth = 1;
			gbc.anchor = GridBagConstraints.NORTH;
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        this.panel2b.add(new JLabel("Animal : "), gbc);
	        gbc.gridx = 1;
	        gbc.gridy = 0;
	        this.panel2b.add(this.getLabelCode(animal), gbc);
	        gbc.gridx = 1;
	        gbc.gridy = 1;
	        this.panel2b.add(this.getLabelNom(animal), gbc);
	        gbc.gridx = 1;
	        gbc.gridy = 2;
	        this.panel2b.add(this.getLabelCouleurSexe(animal), gbc);
	        gbc.gridx = 1;
	        gbc.gridy = 3;
	        this.panel2b.add(this.getLabelEspeceRace(animal), gbc);
	        gbc.gridx = 1;
	        gbc.gridy = 4;
	        this.panel2b.add(this.getLabelTatouage(animal), gbc);
		}
		return this.panel2b;
    }
    
    public JPanel getPanel2c(Clients client){
		if (this.panel2c == null) {
			
			this.panel2c = new JPanel();
			this.panel2c.setLayout(new GridBagLayout());
			this.panel2c.setBorder(new TitledBorder(""));
			this.panel2c.setPreferredSize(new Dimension(320, 370));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        this.panel2c.add(new JLabel("Antecedents/consultations"), gbc);
            gbc.gridx = 0;
            gbc.gridy = 1;
            this.panel2c.add(this.getFieldAntecedents(), gbc);
		}
		return this.panel2c;
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
        }

        return labelClient;
    }

    public JLabel getClient(Clients client) {
        if (this.Client == null) {
            this.Client = new JLabel(client.getClient() + " " + client.getPrenomClient());
        }
        return Client;
    }

    public JLabel getLabelCode(Animaux animal) {
        if (this.labelCode == null) {
            this.labelCode = new JLabel(String.valueOf(animal.getCodeAnimal()));
        }

        return labelCode;
    }

    public JLabel getLabelNom(Animaux animal) {
        if (this.labelNom == null) {
            this.labelNom = new JLabel(animal.getNomAnimal());
        }

        return labelNom;
    }
    
    public JLabel getLabelCouleurSexe(Animaux animal) {
        if (this.labelCouleurSexe == null) {
            this.labelCouleurSexe = new JLabel(animal.getCouleur() + "   " + sexAAfficher(animal.getSexe()));
        }

        return labelCouleurSexe;
    }


    public JLabel getLabelEspeceRace(Animaux animal) {
        if (this.labelEspeceRace == null) {
            this.labelEspeceRace = new JLabel(animal.getEspece() + " " + animal.getRace());
        }

        return labelEspeceRace;
    }


    public JLabel getLabelTatouage(Animaux animal) {
        if (this.labelTatouage == null) {
            if (animal.getTatouage().equals("") || animal.getTatouage().equals(null)) {
                this.labelTatouage = new JLabel("Non tatoué");
            } else {
                this.labelTatouage = new JLabel("Toutage : " + animal.getTatouage());
            }
        }
        return labelTatouage;
    }

    public JTextArea getFieldAntecedents() {
        if (this.fieldAntecedents == null) {
            this.fieldAntecedents = new JTextArea("Test",18,27);
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
