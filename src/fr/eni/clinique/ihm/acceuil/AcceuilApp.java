package fr.eni.clinique.ihm.acceuil;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.log.LogInController;

import javax.swing.*;

public class AcceuilApp {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			
			@Override
			public void run(){
				try {
					AcceuilController.getInstance().start(1);
				} catch (BLLException e) {
					e.printStackTrace();
				} catch (DALException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
