package fr.eni.clinique.ihm.gestionClient;

import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.ecranPersonnel.PersonnelsTable;

public class MDIAppClient extends JFrame {
	
	private JLabel labelRechercherClients;
	private JLabel labelAjouterClients;
	private JLabel labelSupprimerClients;
	private JLabel labelValiderClients;
	private JLabel labelAnnulerClients;
	private JLabel labelCodeClient;
	private JLabel labelNomClient;
	private JLabel labelPrenomClient;
	private JLabel labelAdresseClient;
	private JLabel labelCPClient;
	private JLabel labelVilleClient;
	private JLabel labelNumTelClient;
	private JLabel labelAssuranceClient;
	private JLabel labelEmailClient;
	private JLabel labelRemarqueClient;
	private JTextField fieldCodeClient;
	private JTextField fieldNomClient;
	private JTextField fieldPrenomClient;
	private JTextField fieldAdresse1Client;
	private JTextField fieldAdresse2Client;
	private JTextField fieldCPClient;
	private JTextField fieldVilleClient;
	private JTextField fieldNumTelClient;
	private JTextField fieldAssuranceClient;
	private JTextField fieldEmailClient;
	private JTextField fieldRemarqueClient;
	private JButton buttonRechercherClients;
	private JButton buttonAjouterClients;
	private JButton buttonSupprimerClients;
	private JButton buttonValiderClients;
	private JButton buttonAnnulerClients;
			
	public MDIAppClient() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(1000, 600);
		setResizable(false);
		setTitle("Clients");
		setVisible(true);
	}
	
	public void init() throws BLLException, DALException{
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel2.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(panel2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel2.add(this.getButtonRechercherClients(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel2.add(this.getLabelRechercherClients(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel2.add(this.getButtonAjouterClients(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel2.add(this.getLabelAjouterClients(), gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		panel2.add(this.getButtonSupprimerClients(), gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		panel2.add(this.getLabelSupprimerClients(), gbc);
		gbc.gridx = 3;
		gbc.gridy = 0;
		panel2.add(this.getButtonValiderClients(), gbc);
		gbc.gridx = 3;
		gbc.gridy = 1;
		panel2.add(this.getLabelValiderClients(), gbc);
		gbc.gridx = 4;
		gbc.gridy = 0;
		panel2.add(this.getButtonAnnulerClients(), gbc);
		gbc.gridx = 4;
		gbc.gridy = 1;
		panel2.add(this.getLabelAnnulerClients(), gbc);
		
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(this.getLabelCodeClient(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(this.getFieldCodeClient(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(this.getLabelNomClient(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(this.getFieldNomClient(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(this.getLabelPrenomClient(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		panel.add(this.getFieldPrenomClient(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(this.getLabelAdresseClient(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		panel.add(this.getFieldAdresse1Client(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 5;
		panel.add(this.getFieldAdresse2Client(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(this.getLabelCPClient(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 6;
		panel.add(this.getFieldCPClient(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		panel.add(this.getLabelVilleClient(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 7;
		panel.add(this.getFieldVilleClient(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 8;
		panel.add(this.getLabelNumTelClient(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 8;
		panel.add(this.getFieldNumTelClient(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 9;
		panel.add(this.getLabelAssuranceClient(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 9;
		panel.add(this.getFieldAssuranceClient(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 10;
		panel.add(this.getLabelEmailClient(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 10;
		panel.add(this.getFieldEmailClient(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 11;
		panel.add(this.getLabelRemarqueClient(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 11;
		panel.add(this.getFieldRemarqueClient(), gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		ClientsTable tableClients = new ClientsTable();
		tableClients.setFillsViewportHeight(true);
		tableClients.setPreferredScrollableViewportSize(new Dimension(300, 300));
		panel.add(tableClients, gbc);
		
		JScrollPane scroll = new JScrollPane(panel);
		setContentPane(scroll);
	}
	
	//Button
	public JButton getButtonRechercherClients() {
		if (this.buttonRechercherClients == null) {
			this.buttonRechercherClients = new JButton("Rechercher");
			this.buttonRechercherClients.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						ClientController.getInstance().startApp();
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return this.buttonRechercherClients;
	}
	
	public JButton getButtonAjouterClients() {
		if (this.buttonAjouterClients == null) {
			this.buttonAjouterClients = new JButton("Ajouter");
			this.buttonAjouterClients.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						ClientController.getInstance().startApp();
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return this.buttonAjouterClients;
	}
	
	public JButton getButtonSupprimerClients() {
		if (this.buttonSupprimerClients == null) {
			this.buttonSupprimerClients = new JButton("Supprimer");
			this.buttonSupprimerClients.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						ClientController.getInstance().startApp();
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return this.buttonSupprimerClients;
	}
	
	public JButton getButtonValiderClients() {
		if (this.buttonValiderClients == null) {
			this.buttonValiderClients = new JButton("Valider");
			this.buttonValiderClients.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						ClientController.getInstance().startApp();
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return this.buttonValiderClients;
	}
	
	public JButton getButtonAnnulerClients() {
		if (this.buttonAnnulerClients == null) {
			this.buttonAnnulerClients = new JButton("Annuler");
			this.buttonAnnulerClients.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						ClientController.getInstance().startApp();
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return this.buttonAnnulerClients;
	}

	//TextField
	public JTextField getFieldCodeClient() {
		if (this.fieldCodeClient == null) {
			this.fieldCodeClient = new JTextField(15);
		}
		return this.fieldCodeClient;
	}
	
	public JTextField getFieldNomClient() {
		if (this.fieldNomClient == null) {
			this.fieldNomClient = new JTextField(15);
		}
		return this.fieldNomClient;
	}
	
	public JTextField getFieldPrenomClient() {
		if (this.fieldPrenomClient == null) {
			this.fieldPrenomClient = new JTextField(15);
		}
		return this.fieldPrenomClient;
	}
	
	public JTextField getFieldAdresse1Client() {
		if (this.fieldAdresse1Client == null) {
			this.fieldAdresse1Client = new JTextField(15);
		}
		return this.fieldAdresse1Client;
	}
	
	public JTextField getFieldAdresse2Client() {
		if (this.fieldAdresse2Client == null) {
			this.fieldAdresse2Client = new JTextField(15);
		}
		return this.fieldAdresse2Client;
	}
	
	public JTextField getFieldCPClient() {
		if (this.fieldCPClient == null) {
			this.fieldCPClient = new JTextField(15);
		}
		return this.fieldCPClient;
	}
	
	public JTextField getFieldVilleClient() {
		if (this.fieldVilleClient == null) {
			this.fieldVilleClient = new JTextField(15);
		}
		return this.fieldVilleClient;
	}
	
	public JTextField getFieldNumTelClient() {
		if (this.fieldNumTelClient == null) {
			this.fieldNumTelClient = new JTextField(15);
		}
		return this.fieldNumTelClient;
	}
	
	public JTextField getFieldAssuranceClient() {
		if (this.fieldAssuranceClient == null) {
			this.fieldAssuranceClient = new JTextField(15);
		}
		return this.fieldAssuranceClient;
	}
	
	public JTextField getFieldEmailClient() {
		if (this.fieldEmailClient == null) {
			this.fieldEmailClient = new JTextField(15);
		}
		return this.fieldEmailClient;
	}
	
	//Labels
	public JLabel getLabelRechercherClients() {
		if (this.labelRechercherClients == null) {
			this.labelRechercherClients = new JLabel("Rechercher");
			this.labelRechercherClients.setFont(new Font("Serif", Font.PLAIN, 15));
		}
		return this.labelRechercherClients;
	}
	
	public JLabel getLabelAjouterClients() {
		if (this.labelAjouterClients == null) {
			this.labelAjouterClients = new JLabel("Ajouter");
			this.labelAjouterClients.setFont(new Font("Serif", Font.PLAIN, 15));
		}
		return this.labelAjouterClients;
	}
	
	public JLabel getLabelSupprimerClients() {
		if (this.labelSupprimerClients == null) {
			this.labelSupprimerClients = new JLabel("Supprimer");
			this.labelSupprimerClients.setFont(new Font("Serif", Font.PLAIN, 15));
		}
		return this.labelSupprimerClients;
	}
	
	public JLabel getLabelValiderClients() {
		if (this.labelValiderClients == null) {
			this.labelValiderClients = new JLabel("Valider");
			this.labelValiderClients.setFont(new Font("Serif", Font.PLAIN, 15));
		}
		return this.labelValiderClients;
	}
	
	public JLabel getLabelAnnulerClients() {
		if (this.labelAnnulerClients == null) {
			this.labelAnnulerClients = new JLabel("Annuler");
			this.labelAnnulerClients.setFont(new Font("Serif", Font.PLAIN, 15));
		}
		return this.labelAnnulerClients;
	}
	
	public JLabel getLabelCodeClient() {
		if (this.labelCodeClient == null) {
			this.labelCodeClient = new JLabel("Code");
			this.labelCodeClient.setFont(new Font("Serif", Font.PLAIN, 15));
		}
		return this.labelCodeClient;
	}
	
	public JLabel getLabelNomClient() {
		if (this.labelNomClient == null) {
			this.labelNomClient = new JLabel("Nom");
			this.labelNomClient.setFont(new Font("Serif", Font.PLAIN, 15));
		}
		return this.labelNomClient;
	}
	
	public JLabel getLabelPrenomClient() {
		if (this.labelPrenomClient == null) {
			this.labelPrenomClient = new JLabel("Prénom");
			this.labelPrenomClient.setFont(new Font("Serif", Font.PLAIN, 15));
		}
		return this.labelPrenomClient;
	}
	
	public JLabel getLabelAdresseClient() {
		if (this.labelAdresseClient == null) {
			this.labelAdresseClient = new JLabel("Adresse");
			this.labelAdresseClient.setFont(new Font("Serif", Font.PLAIN, 15));
		}
		return this.labelAdresseClient;
	}
	
	public JLabel getLabelCPClient() {
		if (this.labelCPClient == null) {
			this.labelCPClient = new JLabel("Code Postale");
			this.labelCPClient.setFont(new Font("Serif", Font.PLAIN, 15));
		}
		return this.labelCPClient;
	}
	
	public JLabel getLabelVilleClient() {
		if (this.labelVilleClient == null) {
			this.labelVilleClient = new JLabel("Ville");
			this.labelVilleClient.setFont(new Font("Serif", Font.PLAIN, 15));
		}
		return this.labelVilleClient;
	}
	
	public JLabel getLabelNumTelClient() {
		if (this.labelNumTelClient == null) {
			this.labelNumTelClient = new JLabel("Numéro téléphone");
			this.labelNumTelClient.setFont(new Font("Serif", Font.PLAIN, 15));
		}
		return this.labelNumTelClient;
	}
	
	public JLabel getLabelAssuranceClient() {
		if (this.labelAssuranceClient == null) {
			this.labelAssuranceClient = new JLabel("Assurance");
			this.labelAssuranceClient.setFont(new Font("Serif", Font.PLAIN, 15));
		}
		return this.labelAssuranceClient;
	}
	
	public JLabel getLabelEmailClient() {
		if (this.labelEmailClient == null) {
			this.labelEmailClient = new JLabel("Email");
			this.labelEmailClient.setFont(new Font("Serif", Font.PLAIN, 15));
		}
		return this.labelEmailClient;
	}
	
	public JLabel getLabelRemarqueClient() {
		if (this.labelRemarqueClient == null) {
			this.labelRemarqueClient = new JLabel("Remarque");
			this.labelRemarqueClient.setFont(new Font("Serif", Font.PLAIN, 15));
		}
		return this.labelRemarqueClient;
	}

	public JTextField getFieldRemarqueClient() {
		if (this.fieldRemarqueClient == null) {
			this.fieldRemarqueClient = new JTextField(15);
		}
		return this.fieldRemarqueClient;
	}

}