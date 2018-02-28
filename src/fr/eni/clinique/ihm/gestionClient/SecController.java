package fr.eni.clinique.ihm.gestionClient;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

public class SecController {
    private MDIAppSecretaire fenetreSec;
    private static SecController instance;


    private SecController() throws DALException, BLLException {
        fenetreSec = new MDIAppSecretaire();
    }

    public static synchronized SecController getInstance() throws DALException, BLLException{
        if (instance == null){
            instance = new SecController();
        }
        return instance;
    }

	public void startApp() throws BLLException, DALException {
		fenetreSec.init();
		fenetreSec.revalidate();
		fenetreSec.repaint();
	}
}
