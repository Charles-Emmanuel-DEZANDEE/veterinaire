package fr.eni.clinique.ihm.ecranPriseRDV;

import javax.swing.JFrame;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;

public class AjoutPersonnelController {
    private FenetreAjoutPersonnel fenetreAjoutPersonnel;
    private static AjoutPersonnelController instance;


    public static synchronized AjoutPersonnelController getInstance() throws BLLException{
        if (instance == null){
            instance = new AjoutPersonnelController();
        }
        return instance;
    }
    
    public void afficherFenetreAjout(JFrame parent, PersonnelsTable tablePersonnels) throws BLLException{
    	fenetreAjoutPersonnel = new FenetreAjoutPersonnel(parent, tablePersonnels);
    	fenetreAjoutPersonnel.setVisible(true);
    }


}
