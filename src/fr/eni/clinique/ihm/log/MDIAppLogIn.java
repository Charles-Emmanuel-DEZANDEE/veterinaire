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


    private JDesktopPane desktopPane;
	private JMenuBar menuBarre;
	private JMenu menuAgenda;

    private InternalLogIn frmLog;

	private JLabel labelLogNom;
	private JLabel labelLogPassword;
	private JTextField fieldLogNom;
	private JTextField fieldLogPassword;
	private JButton buttonLogValider;

	//singleton
    public static synchronized MDIAppLogIn getInstance() throws DALException, BLLException{
        if (instance == null){
            instance = new MDIAppLogIn();
        }
        return instance;
    }



    private MDIAppLogIn() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);

		// initialiser l'ecran MDI
		desktopPane = new JDesktopPane();

		// Associer le JDesktopPane à la JFrame
		setContentPane(desktopPane);

        //insertion du texte
        createLogPanel();

		// Barre de menus
		//setJMenuBar(getMenuBarre());
		
		//Frame interne erreur de connexion
		desktopPane.add(getFrmlog());

	}
	public void initLog(){
        MDIAppLogIn ecran = new MDIAppLogIn();
        ecran.setVisible(true);
    }

    public void showError (){
        getFrmlog().setVisible(true);
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


    public InternalLogIn getFrmlog() {
        if(frmLog== null){
            frmLog = new InternalLogIn();
        }
        return frmLog;
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


}
