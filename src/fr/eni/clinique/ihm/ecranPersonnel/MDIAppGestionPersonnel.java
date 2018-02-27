package fr.eni.clinique.ihm.ecranPersonnel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;


public class MDIAppGestionPersonnel extends JFrame  {

	private static final long serialVersionUID = 1L;
	private JButton buttonAjouterPersonnel;
	private JButton buttonSupprimerPersonnel;
	private JButton buttonReinitialiserPersonnel;
	private JPanel panelPersonnel;

<<<<<<< HEAD:src/fr/eni/clinique/ihm/ecranPersonnel/MDIAppGestionPersonnel.java


	public MDIAppGestionPersonnel() throws BLLException, DALException {
=======
	public MDIAppAdm() throws BLLException, DALException {
>>>>>>> adb866ba1a08188b8dd7e257627c563e72ade7fa:src/fr/eni/clinique/ihm/ecranPersonnel/MDIAppAdm.java

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
		panel.add(this.getButtonReinitialiserPersonnel(), gbc);

		// Ligne 2
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		PersonnelsTable tablePersonnels = new PersonnelsTable();
		tablePersonnels.setFillsViewportHeight(true);
		tablePersonnels.setPreferredScrollableViewportSize(new Dimension(800, 500));
		panel.add(tablePersonnels, gbc);
		
		JScrollPane scroll = new JScrollPane(panel);
		setContentPane(scroll);	
	}
	
	
	public JButton getButtonAjouterPersonnel() {
		if (this.buttonAjouterPersonnel == null) {
			this.buttonAjouterPersonnel = new JButton("ajout");
			
			
			this.buttonAjouterPersonnel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						GererPersonnelController.getInstance().nouveauPersonnels();
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
			
			/*
			this.buttonSupprimerPersonnel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						AdmController.getInstance().rechercherArtiste();
					} catch (DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			*/
		}
		return this.buttonSupprimerPersonnel;
	}

	public JButton getButtonReinitialiserPersonnel() {
		if (this.buttonReinitialiserPersonnel == null) {
			this.buttonReinitialiserPersonnel = new JButton("réinit");
			/*
			this.buttonReinitialiserPersonnel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						AdmController.getInstance().rechercherArtiste();
					} catch (DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			*/
		}
		return this.buttonReinitialiserPersonnel;
	}
	

}
