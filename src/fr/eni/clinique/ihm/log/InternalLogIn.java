package fr.eni.clinique.ihm.log;

import javax.swing.*;
import java.awt.*;

public class InternalLogIn extends JInternalFrame {

	public InternalLogIn() {
		//Ecran avec un titre, redimensionable, fermable, agrandissable, iconifiable
		super("Connexion", true, true, true,true);
		
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100,400, 200);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.add(new JLabel("Les informations rentrées sont erronées"));

		this.setContentPane(panel);

	}

}
