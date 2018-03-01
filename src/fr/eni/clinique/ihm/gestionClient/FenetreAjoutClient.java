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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.ecranPersonnel.FenetreAjoutPersonnel;

public class FenetreAjoutClient extends JDialog {

	private ClientsTable tableClients;
	private static FenetreAjoutClient instance;
	private JPanel panel2;
	private JPanel panel3;
	private JButton buttonValiderAjoutClient;

	public FenetreAjoutClient(JFrame parent, ClientsTable tableClients) throws BLLException, DALException {
		super(parent, "Ajouter Client", true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(450, 300);
		setResizable(false);
		this.tableClients = tableClients;
		initAjoutClient();
		setVisible(true);
	}
	
	public static synchronized FenetreAjoutClient getInstance(JFrame parent, ClientsTable tableClients) throws DALException, BLLException{
        if (instance == null){
            instance = new FenetreAjoutClient(parent, tableClients);
        }
        return instance;
    }
	
	public void initAjoutClient() throws BLLException, DALException {
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridwidth = 1;
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
			
			gbc.gridwidth = 1;
			gbc.gridx = 0;
			gbc.gridy = 0;
			panel2.add(this.getButtonValiderAjoutClient(), gbc);
			
		}
		return this.panel2;
		
	}
	
	public JPanel getPanel3(){
		if (this.panel3 == null) {
			this.panel3 = new JPanel();
		}
		return this.panel3;
		
	}
	
	public JButton getButtonValiderAjoutClient(){
		if (this.buttonValiderAjoutClient == null) {
			this.buttonValiderAjoutClient = new JButton("Valider");
		}
		return this.buttonValiderAjoutClient;
	}
	
	public void exit(){
		System.exit(0);
	}
	
	
	
	
}
