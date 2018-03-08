package fr.eni.clinique.ihm.animal;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.RacesManager;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.acceuil.MDIAppAcceuil;
import fr.eni.clinique.ihm.ecranPersonnel.FenetreAjoutPersonnel;
import fr.eni.clinique.ihm.ecranPriseRDV.FenetrePrsieRDV;
import fr.eni.clinique.ihm.gestionClient.MDIAppClient;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ListIterator;


public class FenetreAnimal extends JFrame {

    private static final long serialVersionUID = 1L;

    private JLabel labelClient;
    private JLabel Client;

    private JLabel labelCode;
    private JTextField Code;

    private JLabel labelNom;
    private JTextField fieldNom;
    private JComboBox<String> cboGenreAnimal;

    private JLabel labelCouleur;
    private JTextField fieldCouleur;

    private JLabel labelEspece;
    private JComboBox<String> cboEspece;

    private JLabel labelRace;
    private JComboBox<String> cboRace;

    private JLabel labelTatouage;
    private JTextField fieldTatouage;

    private JButton buttonValider;
    private JButton buttonRetour;

    private FenetrePrsieRDV instancePriseRdv;
    private MDIAppClient instanceGestionClient;
    private Clients clientActuel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    
    public FenetreAnimal() throws BLLException {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 380);
        setResizable(false);
        setTitle("Animaux");
        setVisible(true);

    }

    public void init(Clients client, Boolean nouveau, FenetrePrsieRDV instancePriseRdv, MDIAppClient instanceGestionClient) throws BLLException {
    	this.clientActuel = client;
        this.instancePriseRdv = instancePriseRdv;
        this.instanceGestionClient = instanceGestionClient;
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(this.getPanel1(client, nouveau), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(this.getPanel2(client), gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(this.getPanel3(), gbc);
        
        setContentPane(panel);
        FenetreAnimal.this.revalidate();
        FenetreAnimal.this.repaint();
    }

	public JPanel getPanel1(Clients client, Boolean nouveau) throws BLLException{
		if (this.panel1 == null) {
			
			this.panel1 = new JPanel();
			this.panel1.setLayout(new GridBagLayout());
			this.panel1.setBorder(new TitledBorder(""));
			this.panel1.setPreferredSize(new Dimension(480,50));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			
	        gbc.gridwidth = 1;
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        this.panel1.add(this.getButtonLogValider(client, nouveau), gbc);
	        gbc.gridx = 1;
	        gbc.gridy = 0;
	        this.panel1.add(this.getButtonAnnuler());
		}
		return this.panel1;
	}
	
	public JPanel getPanel2(Clients client) throws BLLException{
		if (this.panel2 == null) {
			
			this.panel2 = new JPanel();
			this.panel2.setLayout(new GridBagLayout());
			this.panel2.setBorder(new TitledBorder("Client : "));
			this.panel2.setPreferredSize(new Dimension(480,50));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			
	        gbc.gridwidth = 1;
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        this.panel2.add(this.getClient(client));
		}
		return this.panel2;
	}
	
	public JPanel getPanel3() throws BLLException{
		if (this.panel3 == null) {
			
			this.panel3 = new JPanel();
			this.panel3.setLayout(new GridBagLayout());
//			this.panel3.setPreferredSize(new Dimension(480,50));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			
	        gbc.gridwidth = 1;
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        this.panel3.add(new JLabel("Code"), gbc);
	        gbc.gridx = 1;
	        gbc.gridy = 0;
	        this.panel3.add(this.getCode(), gbc);
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        this.panel3.add(new JLabel("Nom"), gbc);
	        gbc.gridx = 1;
	        gbc.gridy = 1;
	        this.panel3.add(this.getFieldNom(), gbc);
	        gbc.gridx = 2;
	        gbc.gridy = 1;
	        this.panel3.add(this.getCboGenreAnimal(), gbc);
	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        this.panel3.add(new JLabel("Couleur"), gbc);
	        gbc.gridx = 1;
	        gbc.gridy = 2;
	        this.panel3.add(this.getFieldCouleur(), gbc);
	        gbc.gridx = 0;
	        gbc.gridy = 3;
	        this.panel3.add(new JLabel("Espece"), gbc);
	        gbc.gridx = 1;
	        gbc.gridy = 3;
	        gbc.anchor = GridBagConstraints.WEST;
	        this.panel3.add(this.getCboEspece(), gbc);
	        gbc.gridx = 1;
	        gbc.gridy = 3;
	        gbc.anchor = GridBagConstraints.EAST;
	        this.panel3.add(new JLabel("Race"), gbc);
	        gbc.gridx = 2;
	        gbc.gridy = 3;
	        gbc.anchor = GridBagConstraints.WEST;
	        this.panel3.add(this.getCboRace(), gbc);
	        gbc.gridx = 0;
	        gbc.gridy = 4;
	        this.panel3.add(new JLabel("Tatouage"), gbc);
	        gbc.gridx = 1;
	        gbc.gridy = 4;
	        this.panel3.add(this.getFieldTatouage(), gbc);
		}
		return this.panel3;
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
        }

        return Client;
    }

    public JLabel getLabelCode() {
        if (this.labelCode == null) {
            this.labelCode = new JLabel("Code : ");
            this.labelCode.setFont(new Font("Serif", Font.PLAIN, 20));
        }

        return labelCode;
    }

    public JTextField getCode() {
        if (this.Code == null) {
            this.Code = new JTextField("");
            this.Code.setEditable(false);
        }

        return Code;
    }

    public JLabel getLabelNom() {
        if (this.labelNom == null) {
            this.labelNom = new JLabel("Nom : ");
            this.labelNom.setFont(new Font("Serif", Font.PLAIN, 20));
        }

        return labelNom;
    }

    public JTextField getFieldNom() {
        if (this.fieldNom == null) {
            this.fieldNom = new JTextField(20);
        }

        return fieldNom;
    }


    public JLabel getLabelCouleur() {
        if (this.labelCouleur == null) {
            this.labelCouleur = new JLabel("Couleur : ");
            this.labelCouleur.setFont(new Font("Serif", Font.PLAIN, 20));
        }

        return labelCouleur;
    }

    public JTextField getFieldCouleur() {
        if (this.fieldCouleur == null) {
            this.fieldCouleur = new JTextField(20);
        }
        return fieldCouleur;
    }

    public JLabel getLabelEspece() {
        if (this.labelEspece == null) {
            this.labelEspece = new JLabel("Espece : ");
            this.labelEspece.setFont(new Font("Serif", Font.PLAIN, 20));
        }

        return labelEspece;
    }

    public JLabel getLabelRace() {
        if (this.labelRace == null) {
            this.labelRace = new JLabel("Race : ");
            this.labelRace.setFont(new Font("Serif", Font.PLAIN, 20));
        }

        return labelRace;
    }

    public JLabel getLabelTatouage() {
        if (this.labelTatouage == null) {
            this.labelTatouage = new JLabel("Tatouage : ");
            this.labelTatouage.setFont(new Font("Serif", Font.PLAIN, 20));
        }

        return labelTatouage;
    }

    public JTextField getFieldTatouage() {
        if (this.fieldTatouage == null) {
            this.fieldTatouage = new JTextField(20);
        }
        return fieldTatouage;
    }


    public JButton getButtonLogValider(Clients client, Boolean nouveau) {
        if (this.buttonValider == null) {
            this.buttonValider = new JButton("Valider");
            this.buttonValider.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        System.out.println("valider");
                        AnimalController.getInstance().enregistrer(client, nouveau);
                        // on rafraichi
                        rafraichir();
                    } catch (DALException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (BLLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("erreur champ");
                        JOptionPane.showMessageDialog(FenetreAnimal.this, e1);//"Vous devez saisir tous les champs pour éffecuter un ajout");

                    }

                }
            });

        }
        return this.buttonValider;
    }

    public JButton getButtonAnnuler() {
        if (this.buttonRetour == null) {
            this.buttonRetour = new JButton("Annuler");
//			this.buttonRetour.setActionCommand("validerLogIn");
            this.buttonRetour.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("annuler");
                    FenetreAnimal.this.dispose();
// on rafraichi
                    try {
                        rafraichir();
                    } catch (BLLException e1) {
                        e1.printStackTrace();
                    }
                }
            });

        }
        return this.buttonRetour;
    }

    public void rafraichir() throws BLLException {
        //on rafraichi la table aprés la validation.
        if (instancePriseRdv != null) {
                instancePriseRdv.rafraichirCboAnimal();
        }
        if (instanceGestionClient != null) {
            instanceGestionClient.rafraichirTableAnimaux(clientActuel);

        }

    }

    public JComboBox<String> getCboGenreAnimal() {
        if (this.cboGenreAnimal == null) {
            String[] places = {"Femelle", "Male", "Hermaphrodite"};
            this.cboGenreAnimal = new JComboBox<String>(places);
        }
        return this.cboGenreAnimal;
    }

    public JComboBox<String> getCboRace() throws BLLException {
        if (this.cboRace == null) {
//            String[] places = { "Labrador", "Siamois", "étalon", "jerry","holly" };
            try {
                this.cboRace = new JComboBox(RacesManager.getInstance().getListeRaces(cboEspece.getSelectedItem().toString()).toArray());
            } catch (DALException e) {
                e.printStackTrace();
            }
//            this.cboRace = new JComboBox<String>(places);
        }
        return this.cboRace;
    }

    public JComboBox<String> getCboEspece() throws BLLException {
        if (this.cboEspece == null) {
            String[] places = {"Chat", "Chiens", "sourris", "cheval", "vache"};
//            cboEspece = new JComboBox<String>(places);

            try {
                this.cboEspece = new JComboBox(RacesManager.getInstance().getListeEspece().toArray());
            } catch (DALException e) {
                e.printStackTrace();
            }
            this.cboEspece.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("selection espece");
                    JComboBox cb = (JComboBox) e.getSource();
                    String espece = (String) cb.getSelectedItem();
                    System.out.println(espece);

                    //on vide les items
                    cboRace.removeAllItems();
                    //on remplace les items
                    List<String> newList = null;
                    try {
                        newList = RacesManager.getInstance().getListeRaces((String) cb.getSelectedItem());
                    } catch (BLLException e1) {
                        e1.printStackTrace();
                    } catch (DALException e1) {
                        e1.printStackTrace();
                    }

                    ListIterator<String> it = newList.listIterator();
                    while (it.hasNext()) {
                        String str = it.next();
                        cboRace.addItem(str);
                    }
                    //on rafraichi la fenetre
                    FenetreAnimal.this.revalidate();
                    FenetreAnimal.this.repaint();

                }
            });
        }
        return this.cboEspece;
    }


}
