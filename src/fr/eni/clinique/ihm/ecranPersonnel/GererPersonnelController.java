package fr.eni.clinique.ihm.ecranPersonnel;

import fr.eni.clinique.bll.BLLException;
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
    	fenetreAjoutPersonnel = new FenetreAjoutPersonnel();
    	fenetreAjoutPersonnel.setVisible(true);
		
	}

}
