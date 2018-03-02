package fr.eni.clinique.ihm.gestionClient;

import javax.swing.JFrame;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.DALException;

public class AjoutClientController {
    private FenetreAjoutClient fenetreAjoutClient;
    private static AjoutClientController instance;


    private AjoutClientController(JFrame parent, ClientsTable tableClients) throws DALException, BLLException {
    	fenetreAjoutClient = new FenetreAjoutClient(parent, tableClients);
    }

    public static synchronized AjoutClientController getInstance(JFrame parent, ClientsTable tableClients) throws DALException, BLLException{
        if (instance == null){
            instance = new AjoutClientController(parent, tableClients);
        }else{
        	instance.fenetreAjoutClient.revalidate();
            instance.fenetreAjoutClient.repaint();
            instance.fenetreAjoutClient.setVisible(true);
        }
        return instance;
    }

    public void startApp() throws BLLException, DALException {
    	fenetreAjoutClient.setVisible(true);
	}
}
