package fr.eni.clinique.ihm.ecranPersonnel;

import java.util.List;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;

public class GererPersonnelController {
    private MDIAppGestionPersonnel fenetreAdm;
    private FenetreAjoutPersonnel fenetreAjoutPersonnel;
    private static GererPersonnelController instance;


    private GererPersonnelController() throws DALException, BLLException {
        fenetreAdm = new MDIAppGestionPersonnel();
    }

    public static synchronized GererPersonnelController getInstance() throws DALException, BLLException{
        if (instance == null){
            instance = new GererPersonnelController();
        }
        return instance;
    }

    public void startApp() throws BLLException, DALException {
    	fenetreAdm.setVisible(true);
	}
    
    public void nouveauPersonnels() throws BLLException, DALException {
    	AjoutPersonnelController.getInstance(fenetreAdm);
	}
    
    public void reinitMotPasse(Personnels personnelAModif) throws BLLException, DALException{
    	PersonnelsManager.getInstance().updatePersonnels(personnelAModif);
    	//fenetreAjoutPersonnel.exit();
    }

    
    public void removePersonnel(Personnels personnelsASupp) throws BLLException, DALException {
    		PersonnelsManager.getInstance().archivePersonnel(personnelsASupp);
	}
    
    public void ajouterPersonnel(Personnels newPersonnel) throws BLLException, DALException{
    	PersonnelsManager.getInstance().addPersonnel(newPersonnel);
    	//fenetreAjoutPersonnel.exit();
    }

    
}
