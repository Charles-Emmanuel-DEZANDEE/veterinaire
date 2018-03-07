package fr.eni.clinique.ihm.vet;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;

public class VetController {
    private FenetreVet fenetreVet;
    private static VetController instance;


    private VetController() throws BLLException {
        fenetreVet = new FenetreVet();
    }

    public static synchronized VetController getInstance() throws BLLException{
        if (instance == null){
            instance = new VetController();
        }
        return instance;
    }

    public void startApp(Personnels vetoConnect) throws BLLException {
        fenetreVet.init(vetoConnect);
    }


}
