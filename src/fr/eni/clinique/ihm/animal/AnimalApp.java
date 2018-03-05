package fr.eni.clinique.ihm.animal;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;

import javax.swing.*;

public class AnimalApp {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			
			@Override
			public void run(){
				try {
//					Clients client = new Clients("test", "prenom", "adr",
//							"adr2", "12364", "ville", "1234567890",
//							"mutuelle", "mail", "remarque", false);
					Clients client = DAOFactory.getClientsDAO().selectById(1L);
					Animaux animal = DAOFactory.getAnimauxDAO().selectById(22L);
					AnimalController.getInstance().nouveau(client);
//					AnimalController.getInstance().update(client, animal);
				} catch (BLLException e) {
					e.printStackTrace();
				} catch (DALException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
