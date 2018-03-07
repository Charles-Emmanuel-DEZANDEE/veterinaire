package fr.eni.clinique.ihm.ecranPriseRDV;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import fr.eni.clinique.bll.AgendaManager;
import fr.eni.clinique.bll.AnimauxManager;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dto.RDV;
import fr.eni.clinique.ihm.vet.DateLabelFormatter;


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
	private JDatePickerImpl datePicker;
	private JComboBox<String> CBoHeures;
	private JComboBox<String> CBoMinutes;

	public FenetrePrsieRDV() throws BLLException{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400, 300);
		setResizable(true);
		setTitle("Prise de rendez-vous ");
		initPriseRDV();
		pack();
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
		
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(getTableRDV(), gbc);
		
		
		//Ligne 3
		gbc.gridx = 2;
		gbc.gridy = 2;
		panel.add(this.getValidSuppPanel(), gbc);
		
		setContentPane(panel);	
	}
	
	public JDatePickerImpl getDatePicker() {
		if (this.datePicker == null){
			UtilDateModel model = new UtilDateModel();
			Properties p = new Properties();
			p.put("text.today", "Aujourd'hui");
			p.put("text.month", "Mois");
			p.put("text.year", "Année");
			JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
			
			this.datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
			return this.datePicker;
		}
		return datePicker;
	}	
	
	public JPanel getQuandPanel()throws BLLException{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.setBorder(new TitledBorder("Quand"));
		
		//Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(new JLabel("Date"), gbc);
		
		//Ligne 2
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(this.getDatePicker(), gbc);
		
		//Ligne 3
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(this.getCobHeures(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(new JLabel("H"), gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		panel.add(this.getCobMinutes(), gbc);
						
		return panel;
	}
	
	public JComboBox<String> getCobHeures() throws BLLException {
        if (this.CBoHeures == null) {
        	try {
        		String[] listHeures =  {"9", "10", "11", "12",
        				"14", "15", "16", "17"};
				this.CBoHeures = new JComboBox(listHeures);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return this.CBoHeures;
	}
	
	public JComboBox<String> getCobMinutes() throws BLLException {
        if (this.CBoMinutes == null) {
        	try {
        		String[] listMinutes =  {"00", "15", "30", "45"};
				this.CBoMinutes = new JComboBox(listMinutes);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return this.CBoMinutes;
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
		panel.add(new JLabel(""), gbc);
		return panel;
	}
	
	public JComboBox<String> getCobAnimaux(Clients client) throws BLLException {
        if (this.CBoAnimaux == null) {
        	try {
        		this.listAnimaux =  AnimauxManager.getInstance().getAnimalByClient(client);
        		
        		
				this.CBoAnimaux = new JComboBox(listAnimaux.toArray());
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
        		
        		
				this.CBoVeterinaires = new JComboBox(listVeterinaires.toArray());
				
				 this.CBoVeterinaires.addActionListener(new ActionListener() {

		                @Override
		                public void actionPerformed(ActionEvent e) {
		                        System.out.println("afficher les rdv d'un vétérinaire");
		                        JComboBox cb = (JComboBox)e.getSource();
		                        Personnels vetoSelected = (Personnels)cb.getSelectedItem();
		                        String stringDateRDV = "";
		                        
		                        //recuperer la date selectionné
		                        Date date = (Date)getDatePicker().getModel().getValue();
		                        int dateInt = getDatePicker().getModel().getDay();
		                        
		                       
		                        Date dateRDV = null;
		                        if (date == null){
		                        	dateRDV =  new java.util.Date();
		                        }else{
		                        	dateRDV = date;
		                        }
		                        
		                        //recuperer les RDV du veterinaire
		                        List<RDV> listeRDVParVeterinaire = new ArrayList<>();
		                        try {
		                        	listeRDVParVeterinaire = AgendaManager.getInstance().getRDVByVetEtDate(vetoSelected.getCodePers(), dateRDV);
								} catch (BLLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
		                        //mettre à jour le contenu du model de la table
		                        FenetrePrsieRDV.this.tableRDV.getRDVModel().getListeRDV().clear();
		                        
		                        for(RDV unRDV : listeRDVParVeterinaire){
		                        	FenetrePrsieRDV.this.tableRDV.getRDVModel().getListeRDV().add(unRDV);
		                        }
		                    	//mettre à jour la table
		                        FenetrePrsieRDV.this.tableRDV.getRDVModel().fireTableDataChanged();
		                        
		                        //on rafraichi la fenetre
		                        FenetrePrsieRDV.this.revalidate();
		                        FenetrePrsieRDV.this.repaint();

		                }
		            });
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
				this.listeClients = new JComboBox(listClients.toArray());
				
				 this.listeClients.addActionListener(new ActionListener() {

		                @Override
		                public void actionPerformed(ActionEvent e) {
		                        System.out.println("affichier les animaux d'un client");
		                        JComboBox cb = (JComboBox)e.getSource();
		                        Clients clientSelected = (Clients)cb.getSelectedItem();
		                        List<Animaux> animauxDuClient = new ArrayList<>();
		                        try {
									animauxDuClient = AnimauxManager.getInstance().getAnimalByClient(clientSelected);
								} catch (BLLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
		                        
		                    System.out.println(clientSelected);

		                    //on vide les items
		                    CBoAnimaux.removeAllItems();
		                    //on remplace les items
		                    //List<String> newListAnimaux = FenetrePrsieRDV.this.nomsAnimaux(animauxDuClient);

		                    ListIterator<Animaux> it = animauxDuClient.listIterator();
		                        while(it.hasNext()) {
		                            Animaux str = it.next();
		                            CBoAnimaux.addItem(str.toString());
		                        }
		                        //on rafraichi la fenetre
		                        FenetrePrsieRDV.this.revalidate();
		                        FenetrePrsieRDV.this.repaint();

		                }
		            });
				
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
			this.tableRDV.setFillsViewportHeight(true);
			this.tableRDV.setPreferredSize(new Dimension(600,300));
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
						getTableRDV().getRDVModel().fireTableDataChanged();
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
							getTableRDV().getRDVModel().getListeRDV().remove(ligneTableau[0]);
							
							//mettre à jour la table
							getTableRDV().getRDVModel().fireTableDataChanged();
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
