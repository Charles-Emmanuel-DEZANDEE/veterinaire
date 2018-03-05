package fr.eni.clinique.ihm.vet;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.RacesManager;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.InternalFrame1;
import fr.eni.clinique.ihm.ecranPersonnel.GererPersonnelController;
import fr.eni.clinique.ihm.ecranPersonnel.PersonnelsTable;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
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
	private JComboBox<Personnels> cboVeto;

	private JLabel labelDate;
	private JDatePickerImpl datePicker;

	private JTable tableau;

	private JButton buttonDossierMedical;



	public FenetreVet() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(600, 600);
		setResizable(true);
		setTitle("gestion du personnel");


	}

	// Lancement de la fenetre
	public  void init() throws BLLException {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(this.getLabelVeto(), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(this.getCboVeto(), gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(this.getLabelDate(), gbc);

		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(this.getDatePicker(), gbc);

		// Ligne 2
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 1;

//		panel.add(get.table(), gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 3;
		gbc.gridy = 2;
		panel.add(this.getButtonDossierMedical(), gbc);



		//ligne 3


		JScrollPane scroll = new JScrollPane(panel);
		setContentPane(scroll);

	}

	public JLabel getLabelVeto() {
		if (this.labelVeto == null) {
			this.labelVeto = new JLabel("Vétérinaire : ");
			this.labelVeto.setFont(new Font("Serif", Font.PLAIN, 20));
		}

		return labelVeto;
	}

	public JComboBox<Personnels> getCboVeto() throws BLLException {
		if (this.cboVeto == null) {
			String[] places = { "Chat", "Chiens", "sourris", "cheval", "vache" };
//            cboEspece = new JComboBox<String>(places);

			try {
				this.cboVeto = new JComboBox(RacesManager.getInstance().getListeEspece().toArray());
			} catch (DALException e) {
				e.printStackTrace();
			}
//			this.cboVeto.addActionListener(new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					System.out.println("selection espece");
//					JComboBox cb = (JComboBox)e.getSource();
//					String espece = (String)cb.getSelectedItem();
//					System.out.println(espece);
//
//					//on vide les items
//					cboRace.removeAllItems();
//					//on remplace les items
//					List<String> newList = null;
//					try {
//						newList = RacesManager.getInstance().getListeRaces((String)cb.getSelectedItem());
//					} catch (BLLException e1) {
//						e1.printStackTrace();
//					} catch (DALException e1) {
//						e1.printStackTrace();
//					}
//
//					ListIterator<String> it = newList.listIterator();
//					while(it.hasNext()) {
//						String str = it.next();
//						cboRace.addItem(str);
//					}
//					//on rafraichi la fenetre
//					instance.revalidate();
//					instance.repaint();
//
//				}
//			});
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
//      https://stackoverflow.com/questions/26794698/how-do-i-implement-jdatepicker
	public JDatePickerImpl getDatePicker() {
		UtilDateModel model = new UtilDateModel();
//model.setDate(20,04,2014);
// Need this...
		Properties p = new Properties();
		p.put("text.today", "Aujourd'hui");
		p.put("text.month", "Mois");
		p.put("text.year", "Année");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
// Don't know about the formatter, but there it is...
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		return datePicker;
	}

	public JButton getButtonDossierMedical() {
		if (this.buttonDossierMedical == null) {
			this.buttonDossierMedical = new JButton("supp");

			this.buttonDossierMedical.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
//					try {
//						int[] ligneTableau = getTableRDV().getSelectedRows();
//						Personnels personnelsASupp = null;
//
//						if (ligneTableau.length == 1){
//							personnelsASupp = getTableRDV().getPersonnelsModel().getListePersonnel().get(ligneTableau[0]);
//
//							//mise à jour en base
//							GererPersonnelController.getInstance().removePersonnel(personnelsASupp);
//
//							//mise à jour de la liste du personnels dans la JTable
//							getTableRDV().getPersonnelsModel().getListePersonnel().remove(ligneTableau[0]);
//
//							//mettre à jour la table
//							getTableRDV().getPersonnelsModel().fireTableDataChanged();
//						}
//
//					} catch (BLLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
				}
			});

		}

		return this.buttonDossierMedical;
	}
}
