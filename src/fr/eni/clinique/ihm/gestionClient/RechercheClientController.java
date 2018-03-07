package fr.eni.clinique.ihm.gestionClient;

import javax.swing.JFrame;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.dal.DALException;

public class RechercheClientController {
    private FenetreRechercheClient fenetreRechercheClient;
    private static RechercheClientController instance;

    public static synchronized RechercheClientController getInstance() throws DALException, BLLException{
        if (instance == null){
            instance = new RechercheClientController();
        }
        return instance;
    }
    
    public void afficherFenetreRechercheClient(JFrame parent) throws BLLException, DALException{
    	fenetreRechercheClient = new FenetreRechercheClient(parent);
    	fenetreRechercheClient.setVisible(true);
    }
    
	public void rechercherClient(String NomClient) throws BLLException, DALException {
		ClientsManager.getInstance().getClientByNom(NomClient);
		
		//fenetreRechercheClient.initRechercheClient();
		//fenetreRechercheClient.revalidate();
		//fenetreRechercheClient.repaint();
	}
}
