package fr.eni.clinique.ihm.gestionClient;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.DALException;

public class GererClientController {
    private MDIAppClient fenetreSec;
    private static GererClientController instance;


    private GererClientController() throws DALException, BLLException {
        fenetreSec = new MDIAppClient();
    }

    public static synchronized GererClientController getInstance() throws DALException, BLLException{
        if (instance == null){
            instance = new GererClientController();
        }
        return instance;
    }

	public void startApp() throws BLLException, DALException {
		fenetreSec.init();
		fenetreSec.revalidate();
		fenetreSec.repaint();
	}

	public void ajouterClient(Clients client) throws BLLException, DALException {
		ClientsManager.getInstance().addClient(client);
	}
	
}
