package fr.eni.clinique.ihm.gestionClient;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

public class FenetreRechercheClient extends JDialog {
	
	private static FenetreRechercheClient instance;
	private JPanel panel2;
	private JPanel panel3;
	private JTextField fieldRechercheClient;
	private JButton buttonRechercheClient;

	public FenetreRechercheClient(JFrame parent) throws BLLException, DALException {
		super(parent, "Recherche Client", true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500, 500);
		setResizable(false);
		initRechercheClient();
	}
	
	public static synchronized FenetreRechercheClient getInstance(JFrame parent) throws DALException, BLLException{
		if (instance == null){
            instance = new FenetreRechercheClient(parent);
        }
        return instance;
    }

	public void initRechercheClient() throws BLLException, DALException {
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
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
			gbc.gridy = 1;
			gbc.gridheight = 2;
			panel2.add(this.getFieldRechercheClient(), gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			panel2.add(this.getButtonRechercheClient(), gbc);
			gbc.gridx = 1;
			gbc.gridy = 2;
			panel2.add(new JLabel("Rechercher"), gbc);
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

		}
		return this.panel3;
	}
	
	public JButton getButtonRechercheClient(){
		if (this.buttonRechercheClient == null){
			this.buttonRechercheClient = new JButton("Rechercher");
		}
		return this.buttonRechercheClient;
	}
	
	public JTextField getFieldRechercheClient() {
		if (this.fieldRechercheClient == null) {
			this.fieldRechercheClient = new JTextField(15);
		}
		return this.fieldRechercheClient;
	}
}
