package fr.eni.clinique.ihm.ecranPriseRDV;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Personnels;

public class PriseRDVController {
    private FenetrePrsieRDV fenetreAdm;
    private static PriseRDVController instance;


    private PriseRDVController() throws  BLLException {
        try {
			fenetreAdm = new FenetrePrsieRDV();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static synchronized PriseRDVController getInstance() throws  BLLException{
        if (instance == null){
            instance = new PriseRDVController();
        }
        return instance;
    }

    public void startApp() throws BLLException{
    	fenetreAdm.setVisible(true);
    	fenetreAdm.revalidate();
    	fenetreAdm.repaint();
	}
    
    public void reinitMotPasse(Personnels personnelAModif) throws BLLException{
    	PersonnelsManager.getInstance().updatePersonnels(personnelAModif);
    }

    
    public void removePersonnel(Personnels personnelsASupp) throws BLLException{
    		PersonnelsManager.getInstance().archivePersonnel(personnelsASupp);
	}
    
    public void ajouterPersonnel(Personnels newPersonnel) throws BLLException{
    	PersonnelsManager.getInstance().addPersonnel(newPersonnel);
    }
    
    
    public String roleAEnregistrer(String roleSelectionne){
    	String roleAenregistrer = "";
    	if (roleSelectionne.equals("Veterinaire")){
    		roleAenregistrer= "vet";
    	}
    	if (roleSelectionne.equals("Secrétaire")){
    		roleAenregistrer= "sec";
    	}
    	if (roleSelectionne.equals("Admin")){
    		roleAenregistrer= "adm";
    	}
    	return roleAenregistrer;
    }
    

    
}
