package fr.eni.clinique.ihm.ecranPersonnel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;

public class FenetreReinitMotPassePersonnel extends JDialog {

	private JLabel labelMotPasse;
	private JTextField fieldMotPasse;
	private JButton buttonValider;	
	private Personnels personnelsAModif;
	private static FenetreReinitMotPassePersonnel instance;
	

	public FenetreReinitMotPassePersonnel(JFrame parent, Personnels personnelsAModif) throws BLLException, DALException {
		super(parent, "Reinitialiser Mot De Passe Personnel", true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(450, 300);
		setResizable(false);
		this.personnelsAModif = personnelsAModif;
		initReinitMotPasse();
		setVisible(true);
	}
	
	public static synchronized FenetreReinitMotPassePersonnel getInstance(JFrame parent, Personnels personnelsAModif) throws DALException, BLLException{
        if (instance == null){
            instance = new FenetreReinitMotPassePersonnel( parent,  personnelsAModif);
        }
        instance.setVisible(true);
        return instance;
    }

	public void initReinitMotPasse() throws BLLException, DALException {
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
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 1;	
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
	
	public JTextField getFieldMotPasse() {
		if (this.fieldMotPasse == null) {
			this.fieldMotPasse = new JTextField(20);
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
						FenetreReinitMotPassePersonnel.this.setVisible(false);
					} catch (BLLException e1) {
						e1.printStackTrace();
					} catch (DALException e1) {
						e1.printStackTrace();
					}

				}
			});

		}
		return this.buttonValider;
	}
	
	public void exit(){
		System.exit(0);
	}
	
	
	
	
}
