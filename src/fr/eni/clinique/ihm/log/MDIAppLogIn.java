package fr.eni.clinique.ihm.log;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MDIAppLogIn extends JFrame {

	private static final long serialVersionUID = 1L;
    private static MDIAppLogIn instance;

    private InternalLogIn frmLog;

	private JLabel labelLogNom;
	private JLabel labelLogPassword;
    private JLabel labelErrorUser;
    private JLabel labelErrorPass;
    private JTextField fieldLogNom;
    private JTextField fieldLogPassword;
    private JButton buttonLogValider;
    private JButton buttonRetour;

	//singleton
    public static synchronized MDIAppLogIn getInstance() throws DALException, BLLException{
        if (instance == null){
            instance = new MDIAppLogIn();
        }
        return instance;
    }



    private MDIAppLogIn() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 300);
        setResizable(false);
        setTitle("Connexion");
        setVisible(true);

	}
	public void initLog() throws BLLException, DALException {

        createLogPanel();
        instance.revalidate();
        instance.repaint();
    }

    public void showError (int cas){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Ligne 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        switch (cas) {
            case 1:
                panel.add(this.getLabelErrorUser(), gbc);

                break;
            case 2:
                panel.add(this.getLabelErrorPass(), gbc);
                break;

            default:
                System.out.println("Probleme erreur");
        }

        //ligne 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(this.getButtonRetourn(), gbc);

        setContentPane(panel);
        instance.revalidate();
        instance.repaint();

    }

	public void createLogPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Ligne 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(this.getLabelLogNom(), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(this.getFieldLogNom(), gbc);

        // Ligne 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(this.getLabelLogPassword(), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(this.getfieldLogPassword(), gbc);

        //ligne 3
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(this.getButtonLogValider(), gbc);

        setContentPane(panel);
    }


	public void exit(){
        System.exit(0);
    }

	public JLabel getLabelLogNom() {
		if (this.labelLogNom == null) {
			this.labelLogNom = new JLabel("Nom : ");
			this.labelLogNom.setFont(new Font("Serif", Font.PLAIN, 20));
		}
		return this.labelLogNom;
	}

	public JLabel getLabelLogPassword() {
		if (this.labelLogPassword == null) {
			this.labelLogPassword = new JLabel("Mot de passe : ");
			this.labelLogPassword.setFont(new Font("Serif", Font.PLAIN, 20));
		}
		return this.labelLogPassword;
	}

	public JLabel getLabelErrorUser() {
		if (this.labelErrorUser == null) {
			this.labelErrorUser = new JLabel("L'utilisateur est inconnu ");
			this.labelErrorUser.setFont(new Font("Serif", Font.PLAIN, 20));
		}
		return this.labelErrorUser;
	}

	public JLabel getLabelErrorPass() {
		if (this.labelErrorPass == null) {
			this.labelErrorPass = new JLabel("Le mot de passe est faux ");
			this.labelErrorPass.setFont(new Font("Serif", Font.PLAIN, 20));
		}
		return this.labelErrorPass;
	}

	public JTextField getFieldLogNom() {
		if (this.fieldLogNom == null) {
			this.fieldLogNom = new JTextField(20);
		}
		return this.fieldLogNom;
	}

	public JTextField getfieldLogPassword() {
		if (this.fieldLogPassword == null) {
			this.fieldLogPassword = new JTextField(20);
		}
		return this.fieldLogPassword;
	}

	public JButton getButtonLogValider() {
		if (this.buttonLogValider == null) {
			this.buttonLogValider = new JButton("Valider");
//			this.buttonLogValider.setActionCommand("validerLogIn");
            this.buttonLogValider.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        System.out.println("valider");
                        //on envoi les saisies
                        LogInController.getInstance().validLogIn(getFieldLogNom().getText(),getfieldLogPassword().getText());
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
		return this.buttonLogValider;
	}

	public JButton getButtonRetourn() {
		if (this.buttonRetour == null) {
			this.buttonRetour = new JButton("Retour");
//			this.buttonRetour.setActionCommand("validerLogIn");
            this.buttonRetour.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        System.out.println("retour");
                        //on remet la saisie
                        initLog();
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
		return this.buttonRetour;
	}


}
