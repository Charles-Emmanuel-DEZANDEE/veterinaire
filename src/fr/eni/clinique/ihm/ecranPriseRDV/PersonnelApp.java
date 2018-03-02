package fr.eni.clinique.ihm.ecranPriseRDV;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

import javax.swing.SwingUtilities;

public class PersonnelApp {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			
			@Override
			public void run(){
				try {
					GererPersonnelController.getInstance().startApp();
				} catch (BLLException e) {
					e.printStackTrace();
				} 
			}
		});
	}
}
