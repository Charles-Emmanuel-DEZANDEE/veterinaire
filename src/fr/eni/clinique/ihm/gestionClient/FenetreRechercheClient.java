package fr.eni.clinique.ihm.gestionClient;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.security.ntlm.Client;

import fr.eni.clinique.bll.AnimauxManager;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.ecranPersonnel.FenetreAjoutPersonnel;
import fr.eni.clinique.ihm.ecranPersonnel.GererPersonnelController;
import fr.eni.clinique.ihm.ecranPersonnel.PersonnelsTable;

public class FenetreRechercheClient extends JDialog {
	
	private static FenetreRechercheClient instance;
	private JPanel panel2;
	private JPanel panel3;
	private JTextField fieldRechercheClient;
	private JButton buttonRechercheClient;
	private JButton buttonValiderRechercheClient;
	private ClientsTable tableClients;
	private MDIAppClient parent;

	public FenetreRechercheClient(JFrame parent) throws BLLException {
		super(parent, "Recherche Client", true);
		this.parent = (MDIAppClient)parent;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

	public void initRechercheClient() throws BLLException {
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
			gbc.gridy = 0;
			panel2.add(this.getFieldRechercheClient(), gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			panel2.add(this.getButtonRechercheClient(), gbc);
//			gbc.gridx = 1;
//			gbc.gridy = 2;
//			panel2.add(new JLabel("Rechercher"), gbc);	
			gbc.gridx = 2;
			gbc.gridy = 0;
			panel2.add(this.getButtonValiderRechercheClient(), gbc);
//			gbc.gridx = 2;
//			gbc.gridy = 2;
//			panel2.add(new JLabel("Valider"), gbc);	
		}
		return this.panel2;
	}
	
	public JPanel getPanel3(){
		if (this.panel3 == null) {
			this.panel3 = new JPanel();
			panel3.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			
			gbc.gridwidth = 0;
			gbc.gridx = 0;
			gbc.gridy = 0;
			panel3.add(getTableClients(), gbc);
			
			JScrollPane scroll = new JScrollPane(panel3);
			scroll.setViewportView(panel3);

		}
		return this.panel3;
	}
	
	public ClientsTable getTableClients(){
		if (this.tableClients == null) {
			try {
				this.tableClients = new ClientsTable();
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.tableClients.setPreferredSize(new Dimension(400, 300));
			this.tableClients.setBorder(new TitledBorder(""));
			this.tableClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return this.tableClients;
		
	}
	
	public JButton getButtonRechercheClient(){
		if (this.buttonRechercheClient == null){
			this.buttonRechercheClient = new JButton("Rechercher");
			
			this.buttonRechercheClient.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//TODO
					List<Clients> clients = new ArrayList<>();
					String NomClient = getFieldRechercheClient().getText();
					
					try {
						clients = ClientsManager.getInstance().getClientByNom(NomClient);
						getTableClients().getClientsModel().getListeClient().clear();
						getTableClients().getClientsModel().fireTableDataChanged();
						for (Clients client : clients){
							getTableClients().getClientsModel().getListeClient().add(client);
						}
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return this.buttonRechercheClient;
	}
	
	public JButton getButtonValiderRechercheClient() {
		if (this.buttonValiderRechercheClient == null) {
			this.buttonValiderRechercheClient = new JButton("Valider");
			
			this.buttonValiderRechercheClient.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int[] ligneTableau = getTableClients().getSelectedRows();
					Clients client = null;
					List<Animaux> animaux = new ArrayList<>();
					
					
					if (ligneTableau.length == 1){
						client = getTableClients().getClientsModel().getListeClient().get(ligneTableau[0]);
						parent.setClient(client);
						try {
							parent.rafraichirTableAnimaux(client);
						} catch (BLLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						parent.getFieldCodeClient().setText(String.valueOf(client.getCodeClient()));
						parent.getFieldNomClient().setText(client.getClient());
						parent.getFieldPrenomClient().setText(client.getPrenomClient());
						parent.getFieldAdresse1Client().setText(client.getAdresse1());
						parent.getFieldAdresse2Client().setText(client.getAdresse2());
						parent.getFieldCPClient().setText(client.getCodePostal());
						parent.getFieldVilleClient().setText(client.getVille());
						parent.getFieldNumTelClient().setText(client.getNumTel());
						parent.getFieldAssuranceClient().setText(client.getAssurance());
						parent.getFieldEmailClient().setText(client.getEmail());
						parent.getFieldRemarqueClient().setText(client.getRemarque());
						FenetreRechercheClient.this.dispose();

					}
				}
			});
			
		}
		return this.buttonValiderRechercheClient;
	}
	
	public JTextField getFieldRechercheClient() {
		if (this.fieldRechercheClient == null) {
			this.fieldRechercheClient = new JTextField(15);
		}
		return this.fieldRechercheClient;
	}
}
