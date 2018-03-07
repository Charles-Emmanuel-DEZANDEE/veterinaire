package fr.eni.clinique.ihm.gestionClient;

import javax.swing.JFrame;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.ecranPriseRDV.FenetrePrsieRDV;

public class AjoutClientController {
    private FenetreAjoutClient fenetreAjoutClient;
    private static AjoutClientController instance;

    public static synchronized AjoutClientController getInstance() throws BLLException{
        if (instance == null){
            instance = new AjoutClientController();
        }
        return instance;
    }
    
    public void afficherFenetreAjoutClient(JFrame parent,FenetrePrsieRDV fenetrePriseRDV) throws BLLException{
    	fenetreAjoutClient = new FenetreAjoutClient(parent, fenetrePriseRDV);
    	fenetreAjoutClient.setVisible(true);
    }
}
