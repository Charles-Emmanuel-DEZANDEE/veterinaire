package fr.eni.clinique.ihm.vet;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

public class VetController {
    private MDIAppVet fenetreVet;
    private static VetController instance;


    private VetController() throws DALException, BLLException {
        fenetreVet = new MDIAppVet();
    }

    public static synchronized VetController getInstance() throws DALException, BLLException{
        if (instance == null){
            instance = new VetController();
        }
        return instance;
    }

//    public void startApp(){
//        fenetreVet.init();
//    }

}
