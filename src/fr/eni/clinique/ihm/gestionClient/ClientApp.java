package fr.eni.clinique.ihm.gestionClient;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.gestionClient.GererClientController;

import javax.swing.*;

public class ClientApp {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run(){
				try {
					GererClientController.getInstance().startApp();
				} catch (BLLException e) {
					e.printStackTrace();
				} catch (DALException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
