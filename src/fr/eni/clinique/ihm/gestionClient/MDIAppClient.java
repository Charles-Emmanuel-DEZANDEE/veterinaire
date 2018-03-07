package fr.eni.clinique.ihm.gestionClient;

import java.awt.Component;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import fr.eni.clinique.bll.AnimauxManager;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.DALException;

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
	private Clients client;
	public void setClient(Clients client) {
		this.client = client;
	}

	public Clients getClient() {
		return client;
	}

	public void setFieldCodeClient(JTextField fieldCodeClient) {
		this.fieldCodeClient = fieldCodeClient;
	}

	public void setFieldNomClient(JTextField fieldNomClient) {
		this.fieldNomClient = fieldNomClient;
	}

	public void setFieldPrenomClient(JTextField fieldPrenomClient) {
		this.fieldPrenomClient = fieldPrenomClient;
	}

	public void setFieldCPClient(JTextField fieldCPClient) {
		this.fieldCPClient = fieldCPClient;
	}

	public void setFieldVilleClient(JTextField fieldVilleClient) {
		this.fieldVilleClient = fieldVilleClient;
	}

	public void setFieldNumTelClient(JTextField fieldNumTelClient) {
		this.fieldNumTelClient = fieldNumTelClient;
	}

	public void setFieldAssuranceClient(JTextField fieldAssuranceClient) {
		this.fieldAssuranceClient = fieldAssuranceClient;
	}

	public void setFieldEmailClient(JTextField fieldEmailClient) {
		this.fieldEmailClient = fieldEmailClient;
	}

	public void setFieldRemarqueClient(JTextField fieldRemarqueClient) {
		this.fieldRemarqueClient = fieldRemarqueClient;
	}

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
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private AnimauxTable tableAnimaux;
	
	public MDIAppClient() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(1000, 500);
		setResizable(false);
		setTitle("Clients");
		setVisible(true);
	}
	
	public void init() throws BLLException, DALException{
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(this.getPanel2(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(this.getPanel3(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(this.getPanel4(), gbc);

		setContentPane(panel);
	}
	
	//Panel
	public JPanel getPanel2(){
		
			if (this.panel2 == null) {
				
				this.panel2 = new JPanel();
				this.panel2.setLayout(new GridBagLayout());
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.insets = new Insets(5, 5, 5, 5);
				
				gbc.gridwidth = 1;
				gbc.gridx = 0;
				gbc.gridy = 0;
				this.panel2.add(this.getButtonRechercherClients(), gbc);
				gbc.gridx = 0;
				gbc.gridy = 1;
				 this.panel2.add(this.getLabelRechercherClients(), gbc);
				gbc.gridx = 1;
				gbc.gridy = 0;
				this.panel2.add(this.getButtonAjouterClients(), gbc);
				gbc.gridx = 1;
				gbc.gridy = 1;
				this.panel2.add(this.getLabelAjouterClients(), gbc);
				gbc.gridx = 2;
				gbc.gridy = 0;
				this.panel2.add(this.getButtonSupprimerClients(), gbc);
				gbc.gridx = 2;
				gbc.gridy = 1;
				this.panel2.add(this.getLabelSupprimerClients(), gbc);
				gbc.gridx = 3;
				gbc.gridy = 0;
				this.panel2.add(this.getButtonValiderClients(), gbc);
				gbc.gridx = 3;
				gbc.gridy = 1;
				this.panel2.add(this.getLabelValiderClients(), gbc);
				gbc.gridx = 4;
				gbc.gridy = 0;
				this.panel2.add(this.getButtonAnnulerClients(), gbc);
				gbc.gridx = 4;
				gbc.gridy = 1;
				this.panel2.add(this.getLabelAnnulerClients(), gbc);
			}
			return this.panel2;
		}
	
	public JPanel getPanel3(){
		if (this.panel3 == null) {
			
			this.panel3 = new JPanel();
			this.panel3.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			
			gbc.gridwidth = 1;
			gbc.gridx = 0;
			gbc.gridy = 0;
			this.panel3.add(this.getLabelCodeClient(), gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			this.panel3.add(this.getFieldCodeClient(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 1;
			this.panel3.add(this.getLabelNomClient(), gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			this.panel3.add(this.getFieldNomClient(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 2;
			this.panel3.add(this.getLabelPrenomClient(), gbc);
			gbc.gridx = 1;
			gbc.gridy = 2;
			this.panel3.add(this.getFieldPrenomClient(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 3;
			this.panel3.add(this.getLabelAdresseClient(), gbc);
			gbc.gridx = 1;
			gbc.gridy = 3;
			this.panel3.add(this.getFieldAdresse1Client(), gbc);
			gbc.gridx = 1;
			gbc.gridy = 4;
			this.panel3.add(this.getFieldAdresse2Client(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 5;
			this.panel3.add(this.getLabelCPClient(), gbc);
			gbc.gridx = 1;
			gbc.gridy = 5;
			this.panel3.add(this.getFieldCPClient(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 6;
			this.panel3.add(this.getLabelVilleClient(), gbc);
			gbc.gridx = 1;
			gbc.gridy = 6;
			this.panel3.add(this.getFieldVilleClient(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 7;
			this.panel3.add(this.getLabelNumTelClient(), gbc);
			gbc.gridx = 1;
			gbc.gridy = 7;
			this.panel3.add(this.getFieldNumTelClient(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 8;
			this.panel3.add(this.getLabelAssuranceClient(), gbc);
			gbc.gridx = 1;
			gbc.gridy = 8;
			this.panel3.add(this.getFieldAssuranceClient(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 9;
			this.panel3.add(this.getLabelEmailClient(), gbc);
			gbc.gridx = 1;
			gbc.gridy = 9;
			this.panel3.add(this.getFieldEmailClient(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 10;
			this.panel3.add(this.getLabelRemarqueClient(), gbc);
			gbc.gridx = 1;
			gbc.gridy = 10;
			this.panel3.add(this.getFieldRemarqueClient(), gbc);
		}
		return this.panel3;
	}
	
	public JPanel getPanel4() throws BLLException, DALException{
		if (this.panel4 == null) {
			
			this.panel4 = new JPanel();
			panel4.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			
			gbc.gridwidth = 0;
			gbc.gridx = 0;
			gbc.gridy = 0;
			panel4.add(getTableAnimaux(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 1;
//			panel4.add(getButtonAjouterAnimal(), gbc);
		}
		return this.panel4;
	}

	public AnimauxTable getTableAnimaux(){
		if (this.tableAnimaux == null) {
			try {
				this.tableAnimaux = new AnimauxTable();
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.tableAnimaux.setPreferredSize(new Dimension(450, 300));
			this.tableAnimaux.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return this.tableAnimaux;
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
						RechercheClientController.getInstance().afficherFenetreRechercheClient(MDIAppClient.this);
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
					try {
						AjoutClientController.getInstance().afficherFenetreAjoutClient(MDIAppClient.this);
					} catch (BLLException e1) {
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
					Clients client = new Clients(Integer.valueOf(fieldCodeClient.getText()),
							fieldNomClient.getText(), fieldPrenomClient.getText(),
							fieldAdresse1Client.getText(), fieldAdresse2Client.getText(),
							fieldCPClient.getText(), fieldVilleClient.getText(),
							fieldNumTelClient.getText(), fieldAssuranceClient.getText(),
							fieldEmailClient.getText(), fieldRemarqueClient.getText(), false);
					try {
						GererClientController.getInstance().supprimerClient(client);
						GererClientController.getInstance().actualiserFenetre();
						
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
		return this.buttonSupprimerClients;
	}
	
	public JButton getButtonValiderClients() {
		if (this.buttonValiderClients == null) {
			this.buttonValiderClients = new JButton("Valider");
			this.buttonValiderClients.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Clients client = new Clients(Integer.valueOf(fieldCodeClient.getText()),
							fieldNomClient.getText(), fieldPrenomClient.getText(),
							fieldAdresse1Client.getText(), fieldAdresse2Client.getText(),
							fieldCPClient.getText(), fieldVilleClient.getText(),
							fieldNumTelClient.getText(), fieldAssuranceClient.getText(),
							fieldEmailClient.getText(), fieldRemarqueClient.getText(), false);
					try {
						GererClientController.getInstance().modifierClient(client);
						GererClientController.getInstance().actualiserFenetre();
						
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
		return this.buttonValiderClients;
	}
	
	public JButton getButtonAnnulerClients() {
		if (this.buttonAnnulerClients == null) {
			this.buttonAnnulerClients = new JButton("Annuler");
			this.buttonAnnulerClients.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					getFieldCodeClient().setText(String.valueOf(client.getCodeClient()));
					getFieldNomClient().setText(client.getClient());
					getFieldPrenomClient().setText(client.getPrenomClient());
					getFieldAdresse1Client().setText(client.getAdresse1());
					getFieldAdresse2Client().setText(client.getAdresse2());
					getFieldCPClient().setText(client.getCodePostal());
					getFieldVilleClient().setText(client.getVille());
					getFieldNumTelClient().setText(client.getNumTel());
					getFieldAssuranceClient().setText(client.getAssurance());
					getFieldEmailClient().setText(client.getEmail());
					getFieldRemarqueClient().setText(client.getRemarque());
				}
			});
		}
		return this.buttonAnnulerClients;
	}

	//TextField
	public JTextField getFieldCodeClient() {
		if (this.fieldCodeClient == null) {
			this.fieldCodeClient = new JTextField(15);
			this.fieldCodeClient.setEditable(false);
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
			this.labelPrenomClient = new JLabel("Prenom");
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
			this.labelNumTelClient = new JLabel("Numero Telephone");
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