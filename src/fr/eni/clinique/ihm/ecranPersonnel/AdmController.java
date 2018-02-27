package fr.eni.clinique.ihm.ecranPersonnel;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

public class AdmController {
    private MDIAppAdm fenetreAdm;
    private static AdmController instance;


    private AdmController() throws DALException, BLLException {
        fenetreAdm = new MDIAppAdm();
    }

    public static synchronized AdmController getInstance() throws DALException, BLLException{
        if (instance == null){
            instance = new AdmController();
        }
        return instance;
    }

    public void startApp() throws BLLException, DALException {
    	fenetreAdm.initGestionPersonnel();
		fenetreAdm.revalidate();
		fenetreAdm.repaint();
	}

}
