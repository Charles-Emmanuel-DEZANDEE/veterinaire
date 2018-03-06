package fr.eni.clinique.ihm.vet;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.ihm.ecranPersonnel.GererPersonnelController;

import javax.swing.*;

public class AgendaVetoApp {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			
			@Override
			public void run(){
				try {
					VetController.getInstance().startApp();
				} catch (BLLException e) {
					e.printStackTrace();
				} 
			}
		});
	}
}
