package fr.eni.clinique.ihm.ecranPersonnel;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Personnels;

public class GererPersonnelController {
    private FenetreGestionPersonnel fenetreAdm;
    private static GererPersonnelController instance;


    private GererPersonnelController() throws  BLLException {
        try {
			fenetreAdm = new FenetreGestionPersonnel();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static synchronized GererPersonnelController getInstance() throws  BLLException{
        if (instance == null){
            instance = new GererPersonnelController();
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
