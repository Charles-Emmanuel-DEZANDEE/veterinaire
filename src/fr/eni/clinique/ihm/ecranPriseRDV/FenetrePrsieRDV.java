package fr.eni.clinique.ihm.ecranPriseRDV;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import fr.eni.clinique.bll.AgendaManager;
import fr.eni.clinique.bll.AnimauxManager;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Agendas;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dto.RDV;
import fr.eni.clinique.ihm.animal.AnimalController;
import fr.eni.clinique.ihm.ecranPersonnel.FenetreAjoutPersonnel;
import fr.eni.clinique.ihm.gestionClient.AjoutClientController;
import fr.eni.clinique.ihm.vet.DateLabelFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


public class FenetrePrsieRDV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton buttonAjouterRDV;
	private JButton buttonSupprimerRDV;
	private RDVTable tableRDV;
	private JComboBox<String> CBoClients;
	private List<Clients> listClients;
	private JComboBox<String> CBoVeterinaires;
	private List<Personnels> listVeterinaires;
	private JComboBox<String> CBoAnimaux;
	private List<Animaux> listAnimaux;
	private JDatePickerImpl datePicker;
	private JComboBox<String> CBoHeures;
	private JComboBox<String> CBoMinutes;
	private JButton buttonAjouterClient;
	private JButton buttonAjouterAnimal;
	private Clients clientAjoute;


	public FenetrePrsieRDV() throws BLLException{
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400, 300);
		setResizable(false);
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
		gbc.anchor = GridBagConstraints.EAST;
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
			this.datePicker.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                        System.out.println("afficher les rdv d'un vétérinaire de la date selectionnée");
                        //JComboBox cb = (JComboBox)e.getSource();
                        Personnels vetoSelected = (Personnels)CBoVeterinaires.getSelectedItem();
                        
                        //recuperer la date selectionné
                        Date date = (Date)getDatePicker().getModel().getValue();
                        
                       
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
			
		}
		return datePicker;
	}	
	
	public JPanel getQuandPanel()throws BLLException{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.setBorder(new TitledBorder("Quand"));
		panel.setPreferredSize(new Dimension(230, 120));
		panel.setMinimumSize(new Dimension(230, 120));
		
		//Ligne 1
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(new JLabel("Date"), gbc);
		
		//Ligne 3
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		//gbc.anchor = GridBagConstraints.WEST;
		//panel.add(this.getHeuresEtMinutes(), gbc);
		panel.add(this.getCobHeures(), gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(new JLabel("H"), gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(this.getCobMinutes(),gbc);
		
		
		//Ligne 2
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(this.getDatePicker(), gbc);
		
		
		
		return panel;
	}
	
	public JPanel getPourPanel()throws BLLException{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.setBorder(new TitledBorder("Pour"));
		panel.setPreferredSize(new Dimension(230, 120));
		panel.setMinimumSize(new Dimension(230, 120));
		//Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(new JLabel("Client"), gbc);
	
		//Ligne 2
		gbc.gridx = 0;
		gbc.gridy = 1;
		//gbc.anchor = GridBagConstraints.WEST;
		panel.add(this.getCobClients(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		//gbc.anchor = GridBagConstraints.WEST;
		panel.add(this.getButtonAjouterClient(), gbc);
		
		//Ligne 3
		gbc.gridx = 0;
		gbc.gridy = 2;
		//gbc.anchor = GridBagConstraints.WEST;
		panel.add(this.getCobAnimaux(this.listClients.get(0)), gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		//gbc.anchor = GridBagConstraints.WEST;
		panel.add(this.getButtonAjouterAnimal(), gbc);
		
		return panel;
	}
	public JButton getButtonAjouterClient() {
		if (this.buttonAjouterClient == null) {
			this.buttonAjouterClient = new JButton("+");
			
			
			this.buttonAjouterClient.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						//GererPersonnelController.getInstance().nouveauPersonnels();
						AjoutClientController.getInstance().afficherFenetreAjoutClient(null,FenetrePrsieRDV.this);
						
						//mettre à jour la table
						//getTablePersonnels().getPersonnelsModel().fireTableDataChanged();
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
			});
			
		}
		return this.buttonAjouterClient;
	}
	
	public JButton getButtonAjouterAnimal() {
		if (this.buttonAjouterAnimal == null) {
			this.buttonAjouterAnimal = new JButton("+");
			
			
			this.buttonAjouterAnimal.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						//recuperer le client selectionné
						Clients clientSelected = (Clients)CBoClients.getSelectedItem();						
						AnimalController.getInstance().nouveau(clientSelected,FenetrePrsieRDV.this,null);
						
						//mettre à jour la table
						//getTablePersonnels().getPersonnelsModel().fireTableDataChanged();
					} catch (BLLException e1) {
						e1.printStackTrace();
					} 
				}
			});
			
		}
		return this.buttonAjouterAnimal;
	}
	
	
	
	public JPanel getParPanel()throws BLLException{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.setBorder(new TitledBorder("Par"));
		panel.setPreferredSize(new Dimension(230, 120));
		panel.setMinimumSize(new Dimension(230, 120));
		//Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(new JLabel("Vétérinaire"), gbc);
	
		//Ligne 2
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(this.getCobVetrinaires(), gbc);
		
		//Ligne 3
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(new JLabel("  "), gbc);
		return panel;
	}
	
	
	public JPanel getHeuresEtMinutes()throws BLLException{
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 120));
		panel.setMinimumSize(new Dimension(300, 40));
		panel.add(this.getCobHeures());
		panel.add(new JLabel("H"));
		panel.add(this.getCobMinutes());
		
		return panel;

	}
	public JPanel getValidSuppPanel()throws BLLException{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(this.getButtonSupprimerRDV(), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(this.getButtonAjouterRDV(), gbc);
						
		return panel;
	}
	
	public JComboBox<String> getCobAnimaux(Clients client) throws BLLException {
        if (this.CBoAnimaux == null) {
        	try {
        		this.listAnimaux =  AnimauxManager.getInstance().getAnimalByClient(client);
        		
        		
				this.CBoAnimaux = new JComboBox();
                this.CBoAnimaux.setPreferredSize(new Dimension(170, 27));
                this.CBoAnimaux.setModel(new DefaultComboBoxModel(listAnimaux.toArray()));
                this.CBoAnimaux.setSelectedIndex(0);

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
        		
        		
//				this.CBoVeterinaires = new JComboBox(listVeterinaires.toArray());
                this.CBoVeterinaires = new JComboBox();
                this.CBoVeterinaires.setPreferredSize(new Dimension(170, 27));
                this.CBoVeterinaires.setModel(new DefaultComboBoxModel(listVeterinaires.toArray()));
                this.CBoVeterinaires.setSelectedIndex(0);

				
				 this.CBoVeterinaires.addActionListener(new ActionListener() {

		                @Override
		                public void actionPerformed(ActionEvent e) {
		                        System.out.println("afficher les rdv d'un vétérinaire");
                            try {
                                rafraichirTable();
                            } catch (BLLException e1) {
                                e1.printStackTrace();
                            }


                        }
		            });
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return this.CBoVeterinaires;
 }
 public void rafraichirTable() throws BLLException {
     Personnels vetoSelected = (Personnels)getCobVetrinaires().getSelectedItem();

     //recuperer la date selectionné
     Date date = (Date)getDatePicker().getModel().getValue();


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
	
	public void rafraichirCBoClients(Clients client) throws BLLException{
		this.listClients =  ClientsManager.getInstance().getListeClients();  
		//recuperer le cilent ajouté
		this.clientAjoute = client;
		//on met à jour la combobox
        getCobClients().setModel(new DefaultComboBoxModel(this.listClients.toArray()));
//        getCobClients().addItem(client.toString());


        //on rafraichi la fenetre
        FenetrePrsieRDV.this.revalidate();
        FenetrePrsieRDV.this.repaint();
		
	}
  public JComboBox<String> getCobClients() throws BLLException {
        if (this.CBoClients == null) {
        	try {
        		this.listClients =  ClientsManager.getInstance().getListeClients();      		
				this.CBoClients = new JComboBox(listClients.toArray());
				
				 this.CBoClients.addActionListener(new ActionListener() {

		                @Override
		                public void actionPerformed(ActionEvent e) {

		                        System.out.println("afficher les animaux d'un client");
						//on met à jour la liste d'animaux
							try {
								rafraichirCboAnimal();
							} catch (BLLException e1) {
								e1.printStackTrace();
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
        return this.CBoClients;
 }
 public void rafraichirCboAnimal() throws BLLException {
     Clients clientSelected = (Clients)getCobClients().getSelectedItem();
     List<Animaux> animauxDuClient = new ArrayList<>();
     try {
         animauxDuClient = AnimauxManager.getInstance().getAnimalByClient(clientSelected);
     } catch (BLLException e2) {
         // TODO Auto-generated catch block
         e2.printStackTrace();
     }

     System.out.println(clientSelected);

     //on met à) jour la combobox

     CBoAnimaux.setModel(new DefaultComboBoxModel(animauxDuClient.toArray()));

     //on rafraichi la fenetre
     FenetrePrsieRDV.this.revalidate();
     FenetrePrsieRDV.this.repaint();

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
	  
	
	
	public RDVTable getTableRDV() throws BLLException{
		if (this.tableRDV == null) {
			try {
				this.tableRDV = new RDVTable(PersonnelsManager.getInstance().getListeVeterinaire().get(0).getCodePers(), new java.util.Date());
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.tableRDV.setFillsViewportHeight(true);
			this.tableRDV.setPreferredSize(new Dimension(690,400));
			this.tableRDV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return this.tableRDV;
	}
	
	public JButton getButtonAjouterRDV() {
		if (this.buttonAjouterRDV == null) {
			this.buttonAjouterRDV = new JButton("Ajouter RDV");
			
			
			this.buttonAjouterRDV.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						//le véto
						Personnels veto = (Personnels)getCobVetrinaires().getSelectedItem();
						//l'animal
						Animaux animal = (Animaux)CBoAnimaux.getSelectedItem();

						//la date

						String heure = getCobHeures().getSelectedItem().toString();
						String minutes = getCobMinutes().getSelectedItem().toString();

						Calendar c =  Calendar.getInstance();
						c.set(datePicker.getModel().getYear(), datePicker.getModel().getMonth(), datePicker.getModel().getDay(), Integer.valueOf(heure), Integer.valueOf(minutes), 00);
						Date dateRdv = c.getTime();

						//l'agenda
						Agendas agenda = new Agendas(veto.getCodePers(), dateRdv, animal.getCodeAnimal());
						//recuperer la liste des rdv du jour choisi du veterinaire selectionné
						List<RDV> listeRDV = FenetrePrsieRDV.this.tableRDV.getRDVModel().getListeRDV();
						
						//tester si un rdv existe déja
						boolean existe = false;
						Date date = null;
						for(RDV rdv : listeRDV){
							date = rdv.getDateRdv();
							if(date.getHours()== dateRdv.getHours() && date.getMinutes()== dateRdv.getMinutes()){
								JOptionPane.showMessageDialog(FenetrePrsieRDV.this, "Désolé, ce RDV est déjà pris ! ");	
								existe = true;
							}
						}
						// si aucun rdv n'existe, nous le créons
						if(existe == false){
							PriseRDVController.getInstance().ajouterRdv(agenda);
						}
						//mettre à jour la table
						rafraichirTable();

					} catch (BLLException e1) {
						e1.printStackTrace();
					}
				}
			});
			
		}
		return this.buttonAjouterRDV;
	}
	
	
	public JButton getButtonSupprimerRDV() {
		if (this.buttonSupprimerRDV == null) {
			this.buttonSupprimerRDV = new JButton("Supprimer");
			
			this.buttonSupprimerRDV.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int[] ligneTableau = getTableRDV().getSelectedRows();
						RDV rdvASupp = null;
						
						if (ligneTableau.length == 1){
							rdvASupp = getTableRDV().getRDVModel().getListeRDV().get(ligneTableau[0]);
							Agendas agendaASupp = new Agendas(rdvASupp.getCodeVeto(), rdvASupp.getDateRdv(), rdvASupp.getCodeAnimal());
							
							//mise à jour en base
							PriseRDVController.getInstance().removeRDV(agendaASupp);
							
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

}
