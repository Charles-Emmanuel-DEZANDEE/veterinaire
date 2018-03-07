package fr.eni.clinique.ihm.vet;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.ihm.ecranPersonnel.GererPersonnelController;

import javax.swing.*;

public class AgendaVetoApp {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			
			@Override
			public void run(){
				try {
					Personnels veto = PersonnelsManager.getInstance().getPersonnelById(6L);
					VetController.getInstance().startApp(veto);
				} catch (BLLException e) {
					e.printStackTrace();
				} 
			}
		});
	}
}
