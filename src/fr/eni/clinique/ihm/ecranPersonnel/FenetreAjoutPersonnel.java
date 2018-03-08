package fr.eni.clinique.ihm.ecranPersonnel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Personnels;

public class FenetreAjoutPersonnel extends JDialog {

	private JLabel labelNom;
	private JLabel labelRole;
	private JLabel labelMotPasse;
	private JTextField fieldNom;
	private JTextField fieldRole;
	private JPasswordField fieldMotPasse;
	private JButton buttonValider;	
	private JButton buttonAnnuler;	
	private JComboBox<String> cboRoles;
	private PersonnelsTable tablePersonnels;

	public FenetreAjoutPersonnel(JFrame parent, PersonnelsTable tablePersonnels) throws BLLException {
		super(parent, "Ajouter Personnel", true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(450, 300);
		setResizable(false);
		this.tablePersonnels = tablePersonnels;
		initAjoutPersonnel();
	}
	
	
	public void initAjoutPersonnel() throws BLLException{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Ligne 1
		//gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(this.getLabelNom(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(this.getFieldNom(), gbc);
		
		// Ligne 2
		//gbc.gridwidth = 0;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(this.getLabelRole(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(this.getCboRoles(), gbc);
		
		// Ligne 3
		//gbc.gridwidth = 0;
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(this.getLabelMotPasse(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(this.getFieldMotPasse(), gbc);

		// Ligne 3
		gbc.gridx = 0;
		gbc.gridy = 3;	
		panel.add(this.getButtonAnnuler(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;	
		gbc.anchor = GridBagConstraints.EAST;
		panel.add(this.getButtonValider(), gbc);
		setContentPane(panel);
	}

	public JComboBox<String> getCboRoles() {
		if (cboRoles == null) {
			String[] roles = { "Veterinaire", "Secrétaire", "Admin"};
			cboRoles = new JComboBox<String>(roles);
		}
		return cboRoles;
	}
	
	public JLabel getLabelNom() {
		if (this.labelNom == null) {
			this.labelNom = new JLabel("Nom");
			//this.labelNom.setFont(new Font("Serif", Font.PLAIN, 35));
		}
		return this.labelNom;
	}
	
	public JLabel getLabelRole() {
		if (this.labelRole == null) {
			this.labelRole = new JLabel("Role");
			//this.labelRole.setFont(new Font("Serif", Font.PLAIN, 35));
		}
		return this.labelRole;
	}
	
	public JLabel getLabelMotPasse() {
		if (this.labelMotPasse == null) {
			this.labelMotPasse = new JLabel("Mot de Passe");
			//this.labelMotPasse.setFont(new Font("Serif", Font.PLAIN, 35));
		}
		return this.labelMotPasse;
	}
	

	public JTextField getFieldNom() {
		if (this.fieldNom == null) {
			this.fieldNom = new JTextField(20);
		}
		return this.fieldNom;
	}

	public JTextField getFieldRole() {
		if (this.fieldRole == null) {
			this.fieldRole = new JTextField(20);
		}
		return this.fieldRole;
	}

	public JPasswordField getFieldMotPasse() {
		if (this.fieldMotPasse == null) {
			this.fieldMotPasse = new JPasswordField(20);
		}
		return this.fieldMotPasse;
	}

	
	public JButton getButtonValider(){
		if (this.buttonValider == null) {
			this.buttonValider = new JButton("Valider");
			
			this.buttonValider.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						String roleSelectionne = GererPersonnelController.getInstance().roleAEnregistrer(cboRoles.getSelectedItem().toString());
						
						Personnels newPersonnels = new Personnels(fieldNom.getText(), 
								fieldMotPasse.getText(),
								roleSelectionne,
								false);
						
						GererPersonnelController.getInstance().ajouterPersonnel(newPersonnels);
						
						// mise a jour de la liste du personnels dans le tablePersonnels
						FenetreAjoutPersonnel.this.tablePersonnels.getPersonnelsModel().getListePersonnel().add(newPersonnels);
						FenetreAjoutPersonnel.this.dispose();
					} catch (BLLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(FenetreAjoutPersonnel.this, "Vous devez saisir tous les champs pour éffecuter un ajout");					
					}


				}
			});

		}
		return this.buttonValider;
	}
	
	public JButton getButtonAnnuler(){
		if (this.buttonAnnuler == null) {
			this.buttonAnnuler = new JButton("Annuler");
			
			this.buttonAnnuler.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					FenetreAjoutPersonnel.this.dispose();
				}
			});

		}
		return this.buttonAnnuler;
	}
	
	public void exit(){
		System.exit(0);
	}
	
	
	
	
}
