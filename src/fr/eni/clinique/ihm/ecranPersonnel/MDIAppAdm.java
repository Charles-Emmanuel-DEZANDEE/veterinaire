package fr.eni.clinique.ihm.ecranPersonnel;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;


public class MDIAppAdm extends JFrame  {

	private static final long serialVersionUID = 1L;
	private JButton buttonAjouterPersonnel;
	private JButton buttonSupprimerPersonnel;
	private JButton buttonReinitialiserPersonnel;
	private JPanel panelPersonnel;

	public MDIAppAdm() throws BLLException, DALException {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(600, 600);
		setResizable(false);
		setTitle("gestion du personnel");
		setVisible(true);
	}

	public void initGestionPersonnel() throws BLLException, DALException {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Ligne 1
		//gbc.gridwidth = 0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(this.getButtonAjouterPersonnel(), gbc);
		
		// Ligne 2
		//gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(this.getButtonSupprimerPersonnel(), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		panel.add(this.getButtonReinitialiserPersonnel(), gbc);

		// boucle qui ajoute des panels
		int index = 1;
		for(Map.Entry<Personnels, JPanel> entry : getListPanelPersonnels().entrySet()) {
			Personnels cle = entry.getKey();
			JPanel valeur = entry.getValue();
			// traitements
			gbc.gridwidth = 3;
			gbc.gridx = 0;
			gbc.gridy = index;

			panel.add(valeur,gbc);
			index ++;
		}
		
		setContentPane(panel);
		//scoll barre
		Container c = getContentPane();
		JScrollPane scroll = new JScrollPane(c);
		setContentPane(scroll);	
	}
	
	public Map<Personnels, JPanel> getListPanelPersonnels() throws BLLException, DALException {
		Map<Personnels, JPanel> listeJLabelPersonnels = new HashMap<>();
		//On r�cup�re la liste :
		List<Personnels> listePersonnel = PersonnelsManager.getInstance().getListePersonnel();
		for (Personnels personnel : listePersonnel) {
			listeJLabelPersonnels.put(personnel, getPanelPersonnel(personnel));
		}
		return listeJLabelPersonnels;
	}
	
	public JPanel getPanelPersonnel(Personnels personnel) throws BLLException, DALException {
		JButton btn = null;
		// pour l'instant
		panelPersonnel = new JPanel();
		panelPersonnel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelPersonnel.add(new JLabel(personnel.getNom()), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		panelPersonnel.add(new JLabel(personnel.getRole()), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		panelPersonnel.add(new JLabel(personnel.getMotPasse()), gbc);
		
		/*
		btn = new JButton("R�servations");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//renvoi vers la reservation
				try {
					Controller.getInstance().nouvelleReservation(personnel);
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
		panelPersonnel.add(btn, gbc);
		
		return panelPersonnel;
	}
	
	
	
	public JButton getButtonAjouterPersonnel() {
		if (this.buttonAjouterPersonnel == null) {
			this.buttonAjouterPersonnel = new JButton("ajout");
			
			/*
			this.buttonAjouterPersonnel.addActionListener(new ActionListener() {
				
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
