package fr.eni.clinique.ihm.ecranPersonnel;

import javax.swing.JFrame;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;

public class AjoutPersonnelController {
    private FenetreAjoutPersonnel fenetreAjoutPersonnel;
    private static AjoutPersonnelController instance;


    private AjoutPersonnelController(JFrame parent, PersonnelsTable tablePersonnels) throws DALException, BLLException {
    	fenetreAjoutPersonnel = new FenetreAjoutPersonnel(parent, tablePersonnels);
    }

    public static synchronized AjoutPersonnelController getInstance(JFrame parent, PersonnelsTable tablePersonnels) throws DALException, BLLException{
        if (instance == null){
            instance = new AjoutPersonnelController(parent, tablePersonnels);
        }else{
        	instance.fenetreAjoutPersonnel.revalidate();
            instance.fenetreAjoutPersonnel.repaint();
            instance.fenetreAjoutPersonnel.setVisible(true);
        }
        
        return instance;
    }

    public void startApp() throws BLLException, DALException {
    	fenetreAjoutPersonnel.setVisible(true);
	}
    
    public void retourGererPersonnel() throws BLLException, DALException {
		
	}
    

}
