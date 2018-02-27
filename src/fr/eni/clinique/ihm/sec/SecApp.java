package fr.eni.clinique.ihm.sec;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.sec.SecController;

import javax.swing.*;

public class SecApp {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			
			@Override
			public void run(){
				try {
					SecController.getInstance().startApp();
				} catch (BLLException e) {
					e.printStackTrace();
				} catch (DALException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
