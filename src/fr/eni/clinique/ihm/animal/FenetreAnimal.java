package fr.eni.clinique.ihm.animal;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.RacesManager;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.ecranPersonnel.FenetreAjoutPersonnel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ListIterator;


public class FenetreAnimal extends JFrame {

    private static final long serialVersionUID = 1L;
    private static FenetreAnimal instance;

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

    //singleton
    public static synchronized FenetreAnimal getInstance() throws BLLException {
        if (instance == null) {
            instance = new FenetreAnimal();
        }
        return instance;
    }


    private FenetreAnimal() throws BLLException {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 600);
        setResizable(false);
        setTitle("ecran animal");
        setVisible(true);

    }

    public void init(Clients client, Boolean nouveau) throws BLLException {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Ligne 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(this.getLabelClient(), gbc);
        gbc.gridwidth = 3;
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(this.getClient(client), gbc);

        // Ligne 2
        if (!nouveau) {
            gbc.gridwidth = 1;
            gbc.gridx = 0;
            gbc.gridy = 1;
            panel.add(this.getLabelCode(), gbc);
            gbc.gridx = 1;
            gbc.gridy = 1;
            panel.add(this.getCode(), gbc);
        }

        //ligne 3
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(this.getLabelNom(), gbc);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(this.getFieldNom(), gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(this.getCboGenreAnimal(), gbc);

        //ligne 4
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(this.getLabelCouleur(), gbc);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(this.getFieldCouleur(), gbc);

        //ligne 5
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(this.getLabelEspece(), gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(this.getCboEspece(), gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(this.getLabelRace(), gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 3;
        gbc.gridy = 4;
        panel.add(this.getCboRace(), gbc);

        //ligne 6
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(this.getLabelTatouage(), gbc);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(this.getFieldTatouage(), gbc);

        //ligne 7
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("-----------------------------"), gbc);

        //ligne 8
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        gbc.gridy = 7;
        panel.add(this.getButtonAnnuler(), gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 3;
        gbc.gridy = 7;
        panel.add(this.getButtonLogValider(client, nouveau), gbc);


        setContentPane(panel);
        instance.revalidate();
        instance.repaint();
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
            this.Client = new JLabel(client.getClient()+ " - " + client.getPrenomClient());
            this.Client.setFont(new Font("Serif", Font.PLAIN, 30));
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
            this.Code.setFont(new Font("Serif", Font.PLAIN, 10));
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
                    } catch (DALException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (BLLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("erreur champ");
                        JOptionPane.showMessageDialog(instance, e1);//"Vous devez saisir tous les champs pour éffecuter un ajout");

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
//                    try {
//                        System.out.println("annuler");
//                    } catch (DALException e1) {
//                        // TODO Auto-generated catch block
//                        e1.printStackTrace();
//                    } catch (BLLException e1) {
//                        // TODO Auto-generated catch block
//                        e1.printStackTrace();
//                    }
                }
            });

        }
        return this.buttonRetour;
    }

    public JComboBox<String> getCboGenreAnimal() {
        if (this.cboGenreAnimal == null) {
            String[] places = { "Femelle", "Male","hermaphrodite" };
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
            String[] places = { "Chat", "Chiens", "sourris", "cheval", "vache" };
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
                    JComboBox cb = (JComboBox)e.getSource();
                    String espece = (String)cb.getSelectedItem();
                    System.out.println(espece);

                        //on vide les items
                        cboRace.removeAllItems();
                        //on remplace les items
                    List<String> newList = null;
                    try {
                        newList = RacesManager.getInstance().getListeRaces((String)cb.getSelectedItem());
                    } catch (BLLException e1) {
                        e1.printStackTrace();
                    } catch (DALException e1) {
                        e1.printStackTrace();
                    }

                    ListIterator<String> it = newList.listIterator();
                        while(it.hasNext()) {
                            String str = it.next();
                            cboRace.addItem(str);
                        }
                        //on rafraichi la fenetre
                        instance.revalidate();
                        instance.repaint();

                }
            });
        }
        return this.cboEspece;
    }


}