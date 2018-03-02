package fr.eni.clinique.ihm.ecranPriseRDV;

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
import javax.swing.JPasswordField;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Personnels;

public class FenetreReinitMotPassePersonnel extends JDialog {

	private JLabel labelMotPasse;
	private JPasswordField fieldMotPasse;
	private JButton buttonValider;	
	private JButton buttonAnnuler;	
	private Personnels personnelsAModif;
	

	public FenetreReinitMotPassePersonnel(JFrame parent, Personnels personnelsAModif) throws BLLException{
		super(parent, "Reinitialiser Mot De Passe Personnel", true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(450, 300);
		setResizable(false);
		this.personnelsAModif = personnelsAModif;
		initReinitMotPasse();
	}
	

	public void initReinitMotPasse() throws BLLException{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Ligne 1
		//gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(this.getLabelMotPasse(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(this.getFieldMotPasse(), gbc);
		
		// Ligne 3
		gbc.gridx = 0;
		gbc.gridy = 1;	
		panel.add(this.getButtonAnnuler(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;	
		gbc.anchor = GridBagConstraints.EAST;
		panel.add(this.getButtonValider(), gbc);
		
		setContentPane(panel);
	}

	public JLabel getLabelMotPasse() {
		if (this.labelMotPasse == null) {
			this.labelMotPasse = new JLabel("Mot de Passe");
			//this.labelMotPasse.setFont(new Font("Serif", Font.PLAIN, 35));
		}
		return this.labelMotPasse;
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
					
					FenetreReinitMotPassePersonnel.this.personnelsAModif.setMotPasse(fieldMotPasse.getText());
					try {
						GererPersonnelController.getInstance().reinitMotPasse(FenetreReinitMotPassePersonnel.this.personnelsAModif);
						FenetreReinitMotPassePersonnel.this.dispose();
						
					} catch (BLLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(FenetreReinitMotPassePersonnel.this, "Vous devez saisir un mot de passe");
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
					FenetreReinitMotPassePersonnel.this.dispose();
				}
			});

		}
		return this.buttonAnnuler;
	}
	
	
	public void exit(){
		System.exit(0);
	}
	
	
	
	
}
