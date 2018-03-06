package fr.eni.clinique.ihm.ecranPriseRDV;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import fr.eni.clinique.bll.AnimauxManager;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.Personnels;


public class FenetrePrsieRDV extends JFrame  {

	private static final long serialVersionUID = 1L;
	private JButton buttonAjouterRDV;
	private JButton buttonSupprimerRDV;
	private RDVTable tableRDV;
	private JComboBox<String> listeClients;
	private List<Clients> listClients;
	private JComboBox<String> CBoVeterinaires;
	private List<Personnels> listVeterinaires;
	private JComboBox<String> CBoAnimaux;
	private List<Animaux> listAnimaux;




	public FenetrePrsieRDV() throws BLLException{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(450, 350);
		setResizable(true);
		setTitle("Prise de rendez-vous ");
		initPriseRDV();
		//pack();
	}

	public void initPriseRDV() throws BLLException{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(this.getPourPanel(), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(this.getParPanel(), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		//gbc.anchor = GridBagConstraints.WEST;
		panel.add(this.getQuandPanel(), gbc);

		// Ligne 2
		/*
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(getTableRDV(), gbc);
		*/
		
		//Ligne 3
		gbc.gridx = 2;
		gbc.gridy = 2;
		panel.add(this.getValidSuppPanel(), gbc);
		
		setContentPane(panel);	
	}
	
	
	public JPanel getPourPanel()throws BLLException{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.setBorder(new TitledBorder("Pour"));
		//Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(new JLabel("Client"), gbc);
	
		//Ligne 2
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(this.getCobClients(), gbc);
		
		//Ligne 3
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(this.getCobAnimaux(this.listClients.get(0)), gbc);
		
		
		
						
		return panel;
	}
	
	public JPanel getParPanel()throws BLLException{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.setBorder(new TitledBorder("Par"));
		//Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(new JLabel("Vétérinaire"), gbc);
	
		//Ligne 2
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(this.getCobVetrinaires(), gbc);
		
		//Ligne 3
		gbc.gridx = 0;
		gbc.gridy = 2;
		//panel.add(this.getCobVetrinaires(), gbc);
		return panel;
	}
	
	public JComboBox<String> getCobAnimaux(Clients client) throws BLLException {
        if (this.CBoAnimaux == null) {
        	try {
        		this.listAnimaux =  AnimauxManager.getInstance().getAnimalByClient(client);
        		
        		
				this.CBoAnimaux = new JComboBox(this.nomsAnimaux(listAnimaux).toArray());
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return this.CBoAnimaux;
 }
	
	
	public JComboBox<String> getCobVetrinaires() throws BLLException {
        if (this.CBoVeterinaires == null) {
        	try {
        		this.listVeterinaires =  PersonnelsManager.getInstance().getListeVeterinaire();
        		
        		
				this.CBoVeterinaires = new JComboBox(this.nomsVeterinaires(listVeterinaires).toArray());
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return this.CBoVeterinaires;
 }
	
	
  public JComboBox<String> getCobClients() throws BLLException {
        if (this.listeClients == null) {
        	try {
        		this.listClients =  ClientsManager.getInstance().getListeClients();
        		
        		
				this.listeClients = new JComboBox(this.nomsClients(listClients).toArray());
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return this.listeClients;
 }
	  
	  public List<String> nomsClients(List<Clients> listeClients){
		  List<String> listenomsClients = new ArrayList<>();
		  for (Clients client : listeClients){
			  listenomsClients.add(client.getClient() + " " + client.getPrenomClient());
		  }
		  return listenomsClients;		  
	  }
	  
	  public List<String> nomsVeterinaires(List<Personnels> listeVeterinaires){
		  List<String> listenomsVet = new ArrayList<>();
		  for (Personnels vet : listeVeterinaires){
			  listenomsVet.add(vet.getNom());
		  }
		  return listenomsVet;		  
	  }
	  
	  public List<String> nomsAnimaux(List<Animaux> listeVeterinaires){
		  List<String> listenomsAnimaux = new ArrayList<>();
		  for (Animaux animal : listeVeterinaires){
			  listenomsAnimaux.add(animal.getNomAnimal());
		  }
		  return listenomsAnimaux;		  
	  }
	  
	public JPanel getQuandPanel()throws BLLException{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.setBorder(new TitledBorder("Quand"));
		
		//Ligne 1
		gbc.gridwidth = 0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(new JLabel("Quand"), gbc);
						
		return panel;
	}
	
	public JPanel getValidSuppPanel()throws BLLException{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(this.getButtonAjouterPersonnel(), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(this.getButtonSupprimerPersonnel(), gbc);
						
		return panel;
	}
	
	public RDVTable getTableRDV() throws BLLException{
		if (this.tableRDV == null) {
			try {
				this.tableRDV = new RDVTable(PersonnelsManager.getInstance().getListeVeterinaire().get(0).getCodePers(), new java.util.Date());
			} catch (Exception e) {
				e.printStackTrace();
			}
			//this.tablePersonnels.setFillsViewportHeight(true);
			this.tableRDV.setPreferredSize(new Dimension(400, 300));
			this.tableRDV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return this.tableRDV;
	}
	
	public JButton getButtonAjouterPersonnel() {
		if (this.buttonAjouterRDV == null) {
			this.buttonAjouterRDV = new JButton("ajout");
			
			
			this.buttonAjouterRDV.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						//GererPersonnelController.getInstance().nouveauPersonnels();
						AjoutPersonnelController.getInstance().afficherFenetreAjout(FenetrePrsieRDV.this, FenetrePrsieRDV.this.getTableRDV());
						
						//mettre à jour la table
						getTableRDV().getPersonnelsModel().fireTableDataChanged();
					} catch (BLLException e1) {
						e1.printStackTrace();
					}
				}
			});
			
		}
		return this.buttonAjouterRDV;
	}
	
	
	public JButton getButtonSupprimerPersonnel() {
		if (this.buttonSupprimerRDV == null) {
			this.buttonSupprimerRDV = new JButton("supp");
			
			this.buttonSupprimerRDV.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int[] ligneTableau = getTableRDV().getSelectedRows();
						Personnels personnelsASupp = null;
						
						if (ligneTableau.length == 1){
							//personnelsASupp = getTableRDV().getPersonnelsModel().getListePersonnel().get(ligneTableau[0]);
							
							//mise à jour en base
							PriseRDVController.getInstance().removePersonnel(personnelsASupp);
							
							//mise à jour de la liste du personnels dans la JTable
							getTableRDV().getPersonnelsModel().getListePersonnel().remove(ligneTableau[0]);
							
							//mettre à jour la table
							getTableRDV().getPersonnelsModel().fireTableDataChanged();
						}
						
					} catch (BLLException e1) {
						e1.printStackTrace();
					}
				}
			});
			
		}
		return this.buttonSupprimerRDV;
	}

	

}
