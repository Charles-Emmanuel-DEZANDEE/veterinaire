package fr.eni.clinique.ihm.gestionClient;

import javax.swing.JFrame;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

public class AjoutClientController {
    private FenetreAjoutClient fenetreAjoutClient;
    private static AjoutClientController instance;

    public static synchronized AjoutClientController getInstance() throws DALException, BLLException{
        if (instance == null){
            instance = new AjoutClientController();
        }
        return instance;
    }
    
    public void afficherFenetreAjoutClient(JFrame parent) throws BLLException, DALException{
    	fenetreAjoutClient = new FenetreAjoutClient(parent);
    	fenetreAjoutClient.setVisible(true);
    }
}
