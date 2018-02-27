package fr.eni.clinique.ihm.ecranPersonnel;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;

public class AjoutPersonnelController {
    private FenetreAjoutPersonnel fenetreAjoutPersonnel;
    private static AjoutPersonnelController instance;


    private AjoutPersonnelController() throws DALException, BLLException {
    	fenetreAjoutPersonnel = new FenetreAjoutPersonnel();
    }

    public static synchronized AjoutPersonnelController getInstance() throws DALException, BLLException{
        if (instance == null){
            instance = new AjoutPersonnelController();
        }
        return instance;
    }

    public void startApp() throws BLLException, DALException {
    	fenetreAjoutPersonnel.setVisible(true);
	}
    
    public void retourGererPersonnel() throws BLLException, DALException {
		
	}
    
    public void ajouterPersonnel(Personnels newPersonnel) throws BLLException, DALException{
    	PersonnelsManager.getInstance().addPersonnel(newPersonnel);
    }

}
