package fr.eni.clinique.ihm.Adm;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

public class AdmController {
    private MDIAppAdm fenetreAdm;
    private static AdmController instance;


    private AdmController() throws DALException, BLLException {
        fenetreAdm = new MDIAppAdm();
    }

    public static synchronized AdmController getInstance() throws DALException, BLLException{
        if (instance == null){
            instance = new AdmController();
        }
        return instance;
    }

//    public void startApp(){
//        fenetreAdm.initLog();
//    }

}
