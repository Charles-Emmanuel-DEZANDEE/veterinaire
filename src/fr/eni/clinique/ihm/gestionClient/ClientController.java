package fr.eni.clinique.ihm.gestionClient;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.DALException;

public class ClientController {
    private MDIAppClient fenetreSec;
    private static ClientController instance;


    private ClientController() throws DALException, BLLException {
        fenetreSec = new MDIAppClient();
    }

    public static synchronized ClientController getInstance() throws DALException, BLLException{
        if (instance == null){
            instance = new ClientController();
        }
        return instance;
    }

	public void startApp() throws BLLException, DALException {
		fenetreSec.init();
		fenetreSec.revalidate();
		fenetreSec.repaint();
	}
}
