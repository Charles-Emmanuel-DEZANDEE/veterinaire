package fr.eni.clinique.ihm.gestionClient;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.animal.FenetreAnimal;
import fr.eni.clinique.ihm.ecranPriseRDV.FenetrePrsieRDV;

public class FenetreAjoutClient extends JFrame {

	private static FenetreAjoutClient instance;
	private JPanel panel2;
	private JPanel panel3;
	private JButton buttonValiderAjoutClient;
	private JButton buttonAnnulerAjoutClient;
	private JTextField fieldCodeClient;
	private JTextField fieldNomClient;
	private JTextField fieldPrenomClient;
	private JTextField fieldAdresse1Client;
	private JTextField fieldAdresse2Client;
	private JTextField fieldCPClient;
	private JTextField fieldVilleClient;
	private JTextField fieldNumTelClient;
	private JTextField fieldAssuranceClient;
	private JTextField fieldEmailClient;
	private JTextField fieldRemarqueClient;
	private MDIAppClient parent;
	private FenetrePrsieRDV fenetrePriseRDV;

	public FenetreAjoutClient(MDIAppClient fenetreGestionClients, FenetrePrsieRDV fenetrePriseRDV) throws BLLException{
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400, 450);
		setResizable(false);
		setTitle("Ajout Client ");
		initAjoutClient(fenetreGestionClients,fenetrePriseRDV );
	}
	
	public static synchronized FenetreAjoutClient getInstance(MDIAppClient fenetreGestionClients, FenetrePrsieRDV fenetrePriseRDV) throws DALException, BLLException{
        if (instance == null){
            instance = new FenetreAjoutClient(fenetreGestionClients, fenetrePriseRDV);
        }
        return instance;
    }
	
	public void initAjoutClient(MDIAppClient fenetreGestionClients, FenetrePrsieRDV fenetrePriseRDV) throws BLLException{
		this.parent = fenetreGestionClients;
		this.fenetrePriseRDV = fenetrePriseRDV;
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		panel.add(this.getPanel2(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(this.getPanel3(), gbc);
		
		setContentPane(panel);
	}
	
	public JPanel getPanel2(){
		if (this.panel2 == null) {
			this.panel2 = new JPanel();
			panel2.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			
			gbc.gridx = 0;
			gbc.gridy = 0;
			panel2.add(this.getButtonValiderAjoutClient(), gbc);
//			gbc.gridx = 0;
//			gbc.gridy = 1;
//			panel2.add(new JLabel("Valider"), gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			panel2.add(this.getButtonAnnulerAjoutClient(), gbc);
//			gbc.gridx = 1;
//			gbc.gridy = 1;
//			panel2.add(new JLabel("Annuler"), gbc);
//			
		}
		return this.panel2;
		
	}
	
	public JPanel getPanel3(){
		if (this.panel3 == null) {
			this.panel3 = new JPanel();
			panel3.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(new JLabel("Code"), gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(this.getFieldCodeClient(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(new JLabel("Nom"), gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(this.getFieldNomClient(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(new JLabel("Prenom"), gbc);
			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(this.getFieldPrenomClient(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(new JLabel("Adresse"), gbc);
			gbc.gridx = 1;
			gbc.gridy = 3;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(this.getFieldAdresse1Client(), gbc);
			gbc.gridx = 1;
			gbc.gridy = 4;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(this.getFieldAdresse2Client(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 5;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(new JLabel("Code Postal"), gbc);
			gbc.gridx = 1;
			gbc.gridy = 5;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(this.getFieldCPClient(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 6;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(new JLabel("Ville"), gbc);
			gbc.gridx = 1;
			gbc.gridy = 6;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(this.getFieldVilleClient(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 7;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(new JLabel("Numero de telephone"), gbc);
			gbc.gridx = 1;
			gbc.gridy = 7;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(this.getFieldNumTelClient(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 8;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(new JLabel("Assurance"), gbc);
			gbc.gridx = 1;
			gbc.gridy = 8;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(this.getFieldAssuranceClient(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 9;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(new JLabel("Email"), gbc);
			gbc.gridx = 1;
			gbc.gridy = 9;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(this.getFieldEmailClient(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 10;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(new JLabel("Remarque"), gbc);
			gbc.gridx = 1;
			gbc.gridy = 10;
			gbc.anchor = GridBagConstraints.WEST;
			this.panel3.add(this.getFieldRemarqueClient(), gbc);
		}
		return this.panel3;
		
	}
	
	public JButton getButtonValiderAjoutClient(){
		if (this.buttonValiderAjoutClient == null) {
			this.buttonValiderAjoutClient = new JButton("Valider");
			this.buttonValiderAjoutClient.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Clients client = new Clients(fieldNomClient.getText(), fieldPrenomClient.getText(),
							fieldAdresse1Client.getText(), fieldAdresse2Client.getText(),
							fieldCPClient.getText(), fieldVilleClient.getText(),
							fieldNumTelClient.getText(), fieldAssuranceClient.getText(),
							fieldEmailClient.getText(), fieldRemarqueClient.getText(), false);
					try {
						GererClientController.getInstance().ajouterClient(client);
						//mettre a jout la CBoClients de fentre prise de RDV
						if(fenetrePriseRDV != null){
							fenetrePriseRDV.rafraichirCBoClients(client);
						}
						//mettre a jout la CBoClients de gestion de clients
						if(parent != null){
							parent.rafraichirChampsClient(client);
						}
						parent.rafraichirTableAnimaux(client);
						FenetreAjoutClient.this.dispose();
						
					} catch (BLLException e1) {
                        JOptionPane.showMessageDialog(FenetreAjoutClient.this, "Veuillez remplir tous les champs");

					}
				}
			});
		}
		return this.buttonValiderAjoutClient;
	}
	
	public JButton getButtonAnnulerAjoutClient(){
		if (this.buttonAnnulerAjoutClient == null) {
			this.buttonAnnulerAjoutClient = new JButton("Annuler");
			this.buttonAnnulerAjoutClient.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					FenetreAjoutClient.this.dispose();
				}
			});
		}
		return this.buttonAnnulerAjoutClient;
	}
	
	//TextField
		public JTextField getFieldCodeClient() {
			if (this.fieldCodeClient == null) {
				this.fieldCodeClient = new JTextField(15);
				this.fieldCodeClient.setEditable(false);
			}
			return this.fieldCodeClient;
		}
		
		public JTextField getFieldNomClient() {
			if (this.fieldNomClient == null) {
				this.fieldNomClient = new JTextField(15);
			}
			return this.fieldNomClient;
		}
		
		public JTextField getFieldPrenomClient() {
			if (this.fieldPrenomClient == null) {
				this.fieldPrenomClient = new JTextField(15);
			}
			return this.fieldPrenomClient;
		}
		
		public JTextField getFieldAdresse1Client() {
			if (this.fieldAdresse1Client == null) {
				this.fieldAdresse1Client = new JTextField(15);
			}
			return this.fieldAdresse1Client;
		}
		
		public JTextField getFieldAdresse2Client() {
			if (this.fieldAdresse2Client == null) {
				this.fieldAdresse2Client = new JTextField(15);
			}
			return this.fieldAdresse2Client;
		}
		
		public JTextField getFieldCPClient() {
			if (this.fieldCPClient == null) {
				this.fieldCPClient = new JTextField(15);
			}
			return this.fieldCPClient;
		}
		
		public JTextField getFieldVilleClient() {
			if (this.fieldVilleClient == null) {
				this.fieldVilleClient = new JTextField(15);
			}
			return this.fieldVilleClient;
		}
		
		public JTextField getFieldNumTelClient() {
			if (this.fieldNumTelClient == null) {
				this.fieldNumTelClient = new JTextField(15);
			}
			return this.fieldNumTelClient;
		}
		
		public JTextField getFieldAssuranceClient() {
			if (this.fieldAssuranceClient == null) {
				this.fieldAssuranceClient = new JTextField(15);
			}
			return this.fieldAssuranceClient;
		}
		
		public JTextField getFieldEmailClient() {
			if (this.fieldEmailClient == null) {
				this.fieldEmailClient = new JTextField(15);
			}
			return this.fieldEmailClient;
		}
		
		
		public JTextField getFieldRemarqueClient() {
			if (this.fieldRemarqueClient == null) {
				this.fieldRemarqueClient = new JTextField(15);
			}
			return this.fieldRemarqueClient;
		}
}
