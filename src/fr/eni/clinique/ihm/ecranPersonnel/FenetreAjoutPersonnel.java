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
import javax.swing.JTable;
import javax.swing.JTextField;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;

public class FenetreAjoutPersonnel extends JDialog {

	private JPanel panelAjout;
	private JLabel labelNom;
	private JLabel labelRole;
	private JLabel labelMotPasse;
	private JTextField fieldNom;
	private JTextField fieldRole;
	private JTextField fieldMotPasse;
	private JButton buttonValider;	
	private PersonnelsTable tablePersonnels;
	private static FenetreAjoutPersonnel instance;

	public FenetreAjoutPersonnel(JFrame parent, PersonnelsTable tablePersonnels) throws BLLException, DALException {
		super(parent, "Ajouter Personnel", true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(450, 300);
		setResizable(false);
		this.tablePersonnels = tablePersonnels;
		initAjoutPersonnel();
		setVisible(true);
	}
	
	public static synchronized FenetreAjoutPersonnel getInstance(JFrame parent, PersonnelsTable tablePersonnels) throws DALException, BLLException{
        if (instance == null){
            instance = new FenetreAjoutPersonnel( parent, tablePersonnels);
        }
        return instance;
    }
	
	public void initAjoutPersonnel() throws BLLException, DALException {
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
		panel.add(this.getFieldRole(), gbc);
		
		// Ligne 3
		//gbc.gridwidth = 0;
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(this.getLabelMotPasse(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(this.getFieldMotPasse(), gbc);

		// Ligne 3
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 3;	
		panel.add(this.getButtonValider(), gbc);
		setContentPane(panel);
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
					try {
						Personnels newPersonnels = new Personnels(fieldNom.getText(), 
								fieldMotPasse.getText(),
								fieldRole.getText(),
								false);
						
						GererPersonnelController.getInstance().ajouterPersonnel(newPersonnels);
						
						// mise a jour de la liste du personnels dans le tablePersonnels
						FenetreAjoutPersonnel.this.tablePersonnels.getPersonnelsModel().getListePersonnel().add(newPersonnels);
						FenetreAjoutPersonnel.this.setVisible(false);
						
						//vider les champs
						fieldNom.setText("");
						fieldMotPasse.setText("");
						fieldRole.setText("");
					} catch (BLLException e1) {
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
