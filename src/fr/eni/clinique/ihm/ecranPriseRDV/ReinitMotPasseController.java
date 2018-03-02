package fr.eni.clinique.ihm.ecranPriseRDV;

import javax.swing.JFrame;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;

public class ReinitMotPasseController {
    private FenetreReinitMotPassePersonnel fenetreReinitMotPasse;
    private static ReinitMotPasseController instance;



    public static synchronized ReinitMotPasseController getInstance() throws  BLLException{
        if (instance == null){
            instance = new ReinitMotPasseController();
        }
        return instance;
    }

    public void afficherFenetreReinit(JFrame parent, Personnels personnelsAModif) throws BLLException{
    	fenetreReinitMotPasse = new FenetreReinitMotPassePersonnel(parent, personnelsAModif);
    	fenetreReinitMotPasse.setVisible(true);
    }
    
    
    public void retourGererPersonnel() throws BLLException, DALException {
		
	}
    
}
