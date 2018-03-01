package fr.eni.clinique.ihm.ecranPersonnel;

import java.util.List;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;

public class GererPersonnelController {
    private MDIAppGestionPersonnel fenetreAdm;
    private static GererPersonnelController instance;


    private GererPersonnelController() throws  BLLException {
        try {
			fenetreAdm = new MDIAppGestionPersonnel();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static synchronized GererPersonnelController getInstance() throws  BLLException{
        if (instance == null){
            instance = new GererPersonnelController();
        }
        return instance;
    }

    public void startApp() throws BLLException, DALException {
    	fenetreAdm.setVisible(true);
    	fenetreAdm.revalidate();
    	fenetreAdm.repaint();
	}
    
    public void reinitMotPasse(Personnels personnelAModif) throws BLLException, DALException{
    	PersonnelsManager.getInstance().updatePersonnels(personnelAModif);
    	//fenetreAjoutPersonnel.exit();
    }

    
    public void removePersonnel(Personnels personnelsASupp) throws BLLException, DALException {
    		PersonnelsManager.getInstance().archivePersonnel(personnelsASupp);
	}
    
    public void ajouterPersonnel(Personnels newPersonnel) throws BLLException{
    	PersonnelsManager.getInstance().addPersonnel(newPersonnel);
    	//fenetreAjoutPersonnel.exit();
    }

    
}
