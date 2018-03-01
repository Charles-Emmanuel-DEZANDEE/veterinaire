package fr.eni.clinique.ihm.ecranPersonnel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;


public class MDIAppGestionPersonnel extends JFrame  {

	private static final long serialVersionUID = 1L;
	private JButton buttonAjouterPersonnel;
	private JButton buttonSupprimerPersonnel;
	private JButton buttonReinitialiserPersonnel;
	private PersonnelsTable tablePersonnels;




	public MDIAppGestionPersonnel() throws BLLException, DALException {

	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(450, 350);
		setResizable(true);
		setTitle("gestion du personnel");
		initGestionPersonnel();
		//pack();
	}

	public void initGestionPersonnel() throws BLLException, DALException {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(this.getButtonAjouterPersonnel(), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(this.getButtonSupprimerPersonnel(), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(this.getButtonReinitialiserPersonnel(), gbc);

		// Ligne 2
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		panel.add(getTablePersonnels(), gbc);
		
		JScrollPane scroll = new JScrollPane(panel);
		setContentPane(scroll);	
	}
	
	public PersonnelsTable getTablePersonnels() throws BLLException, DALException {
		if (this.tablePersonnels == null) {
			this.tablePersonnels = new PersonnelsTable();
			//this.tablePersonnels.setFillsViewportHeight(true);
			this.tablePersonnels.setPreferredSize(new Dimension(400, 300));
			this.tablePersonnels.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return this.tablePersonnels;
	}
	
	public JButton getButtonAjouterPersonnel() {
		if (this.buttonAjouterPersonnel == null) {
			this.buttonAjouterPersonnel = new JButton("ajout");
			
			
			this.buttonAjouterPersonnel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						//GererPersonnelController.getInstance().nouveauPersonnels();
						AjoutPersonnelController.getInstance().afficherFenetreAjout(MDIAppGestionPersonnel.this, MDIAppGestionPersonnel.this.getTablePersonnels());
						
						//mettre à jour la table
						getTablePersonnels().getPersonnelsModel().fireTableDataChanged();
					} catch (DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
		}
		return this.buttonAjouterPersonnel;
	}
	
	
	public JButton getButtonSupprimerPersonnel() {
		if (this.buttonSupprimerPersonnel == null) {
			this.buttonSupprimerPersonnel = new JButton("supp");
			
			this.buttonSupprimerPersonnel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int[] ligneTableau = getTablePersonnels().getSelectedRows();
						Personnels personnelsASupp = null;
						
						if (ligneTableau.length == 1){
							personnelsASupp = getTablePersonnels().getPersonnelsModel().getListePersonnel().get(ligneTableau[0]);
							
							//mise à jour en base
							GererPersonnelController.getInstance().removePersonnel(personnelsASupp);
							
							//mise à jour de la liste du personnels dans la JTable
							getTablePersonnels().getPersonnelsModel().getListePersonnel().remove(ligneTableau[0]);
							
							//mettre à jour la table
							getTablePersonnels().getPersonnelsModel().fireTableDataChanged();
						}
						
					} catch (DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
		}
		return this.buttonSupprimerPersonnel;
	}

	public JButton getButtonReinitialiserPersonnel() {
		if (this.buttonReinitialiserPersonnel == null) {
			this.buttonReinitialiserPersonnel = new JButton("réinit");
			
			this.buttonReinitialiserPersonnel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int[] ligneTableau = getTablePersonnels().getSelectedRows();
						Personnels personnelsAModif = null;
						
						if (ligneTableau.length == 1){
							personnelsAModif = getTablePersonnels().getPersonnelsModel().getListePersonnel().get(ligneTableau[0]);
							ReinitMotPasseController.getInstance().afficherFenetreReinit(MDIAppGestionPersonnel.this, personnelsAModif);
							
							//mettre à jour la table
							getTablePersonnels().getPersonnelsModel().fireTableDataChanged();
						}
					} catch (DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
		}
		return this.buttonReinitialiserPersonnel;
	}
	

}
