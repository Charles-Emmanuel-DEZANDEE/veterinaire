package fr.eni.clinique.ihm.vet;

import fr.eni.clinique.bll.*;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dto.RDV;
import fr.eni.clinique.ihm.InternalFrame1;
import fr.eni.clinique.ihm.animal.AnimalController;
import fr.eni.clinique.ihm.ecranDossierMedical.DossierMedicalController;
import fr.eni.clinique.ihm.ecranPersonnel.GererPersonnelController;
import fr.eni.clinique.ihm.ecranPersonnel.PersonnelsTable;
import fr.eni.clinique.ihm.ecranPriseRDV.RDVTable;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ListIterator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;


public class FenetreVet extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel labelVeto;
	private JComboBox<String> cboVeto;
	private List<Personnels> listVeterinaires;
	private JLabel labelDate;
	private JDatePickerImpl datePicker;
	private RDVTable tableRDV;
	private JButton buttonDossierMedical;
	private Personnels veterinaireConnecte;
	private JPanel panel1;
	private JPanel panel2;
	
	public FenetreVet() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(600, 500);
		setResizable(false);
		setTitle("Agenda");
		setVisible(true);
//		pack();
	}

	// Lancement de la fenetre
	public  void init(Personnels vetoConnect) throws BLLException {
		if (this.veterinaireConnecte ==null)
		{this.veterinaireConnecte = vetoConnect;}

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(this.getPanel1(), gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(this.getPanel2(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.EAST;
		panel.add(this.getButtonDossierMedical(), gbc);
		
		setContentPane(panel);
	}
	
	public JPanel getPanel1() throws BLLException{
		if (this.panel1 == null) {
			
			this.panel1 = new JPanel();
			this.panel1.setLayout(new GridBagLayout());
			this.panel1.setBorder(new TitledBorder("De"));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 25, 5, 5);
			
			gbc.gridwidth = 1;
			gbc.gridx = 0;
			gbc.gridy = 0;
			this.panel1.add(new JLabel("Veterinaire "), gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			this.panel1.add(this.getCboVeto(), gbc);
			gbc.gridx = 2;
			gbc.gridy = 0;
			this.panel1.add(new JLabel("Date "), gbc);
			gbc.gridx = 3;
			gbc.gridy = 0;
			this.panel1.add(this.getDatePicker(), gbc);
		}
		return this.panel1;
	}
	
	public JPanel getPanel2() throws BLLException{
		if (this.panel2 == null) {
			
			this.panel2 = new JPanel();
			this.panel2.setLayout(new GridBagLayout());
			this.panel2.setBorder(new TitledBorder(""));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			
			gbc.gridwidth = 1;
			gbc.gridx = 0;
			gbc.gridy = 0;
			this.panel2.add(this.getTableRDV(), gbc);
		}
		return this.panel2;
	}

	public JLabel getLabelVeto() {
		if (this.labelVeto == null) {
			this.labelVeto = new JLabel("Veterinaire ");
			this.labelVeto.setFont(new Font("Serif", Font.PLAIN, 20));
		}

		return labelVeto;
	}

	public RDVTable getTableRDV() throws BLLException{
		if (this.tableRDV == null) {
			try {
				this.tableRDV = new RDVTable(this.veterinaireConnecte.getCodePers(), new java.util.Date());
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.tableRDV.setFillsViewportHeight(true);
			this.tableRDV.setPreferredSize(new Dimension(500,300));
			this.tableRDV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return this.tableRDV;
	}


	public JComboBox<String> getCboVeto() throws BLLException {
		if (this.cboVeto == null) {
			try {
				this.listVeterinaires =  PersonnelsManager.getInstance().getListeVeterinaire();


				this.cboVeto = new JComboBox(listVeterinaires.toArray());

				this.cboVeto.addActionListener(new ActionListener() {

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
						FenetreVet.this.tableRDV.getRDVModel().getListeRDV().clear();

						for(RDV unRDV : listeRDVParVeterinaire){
							FenetreVet.this.tableRDV.getRDVModel().getListeRDV().add(unRDV);
						}
						//mettre à jour la table
						FenetreVet.this.tableRDV.getRDVModel().fireTableDataChanged();

						//on rafraichi la fenetre
						FenetreVet.this.revalidate();
						FenetreVet.this.repaint();

					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.cboVeto;
	}

	public JLabel getLabelDate() {
		if (this.labelDate == null) {
			this.labelDate = new JLabel("Date : ");
			this.labelDate.setFont(new Font("Serif", Font.PLAIN, 20));
		}

		return labelDate;
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
					System.out.println("afficher les rdv d'un vétérinaire");
					Personnels vetoSelected = null;
					try {
						vetoSelected = (Personnels)getCboVeto().getSelectedItem();
					} catch (BLLException e1) {
						e1.printStackTrace();
					}
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
					FenetreVet.this.tableRDV.getRDVModel().getListeRDV().clear();

					for(RDV unRDV : listeRDVParVeterinaire){
						FenetreVet.this.tableRDV.getRDVModel().getListeRDV().add(unRDV);
					}
					//mettre à jour la table
					FenetreVet.this.tableRDV.getRDVModel().fireTableDataChanged();

					//on rafraichi la fenetre
					FenetreVet.this.revalidate();
					FenetreVet.this.repaint();

				}
			});

		}
		return this.datePicker;
	}

	public JButton getButtonDossierMedical() {
		if (this.buttonDossierMedical == null) {
			this.buttonDossierMedical = new JButton("Dossier medical");

			this.buttonDossierMedical.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int[] ligneTableau = getTableRDV().getSelectedRows();
						RDV rdvSelected = null;

						if (ligneTableau.length == 1){
							rdvSelected = getTableRDV().getRDVModel().getListeRDV().get(ligneTableau[0]);

							// on cherche l'animal
							int codeanimal = rdvSelected.getCodeAnimal();
							Animaux animal = AnimauxManager.getInstance().getAnimalById(codeanimal);

							//on ouvre la fenetre animal
                            DossierMedicalController.getInstance().init(animal);
						}

					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

		}

		return this.buttonDossierMedical;
	}
}
