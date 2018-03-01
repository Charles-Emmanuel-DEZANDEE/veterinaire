package fr.eni.clinique.ihm.ecranPersonnel;

import javax.swing.JFrame;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;

public class ReinitMotPasseController {
    private FenetreReinitMotPassePersonnel fenetreReinitMotPasse;
    private static ReinitMotPasseController instance;


    private ReinitMotPasseController(JFrame parent, Personnels personnelsAModif) throws DALException, BLLException {
    	 if (instance == null){
    		 fenetreReinitMotPasse = FenetreReinitMotPassePersonnel.getInstance(parent, personnelsAModif);
    	 }
    }

    public static synchronized ReinitMotPasseController getInstance(JFrame parent, Personnels personnelsAModif) throws DALException, BLLException{
        if (instance == null){
            instance = new ReinitMotPasseController( parent,  personnelsAModif);
        }
        else{
        	instance.fenetreReinitMotPasse.revalidate();
            instance.fenetreReinitMotPasse.repaint();
            instance.fenetreReinitMotPasse.setVisible(true);
        }
        return instance;
    }

    public void startApp() throws BLLException, DALException {
    	fenetreReinitMotPasse.setVisible(true);
	}
    
    public void retourGererPersonnel() throws BLLException, DALException {
		
	}
    
}
