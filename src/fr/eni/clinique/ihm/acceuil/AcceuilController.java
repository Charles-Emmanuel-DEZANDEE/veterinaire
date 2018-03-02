package fr.eni.clinique.ihm.acceuil;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

public class AcceuilController {
    private MDIAppAcceuil fenetreAcceuil;
    private static AcceuilController instance;


    private AcceuilController() throws DALException, BLLException {
//        fenetreAcceuil = MDIAppAcceuil.getInstance(cas);
    }

    public static synchronized AcceuilController getInstance() throws DALException, BLLException {
        if (instance == null) {
            instance = new AcceuilController();
        }
        return instance;
    }

    public void start(int cas) throws BLLException, DALException {
        fenetreAcceuil = MDIAppAcceuil.getInstance(cas);

        fenetreAcceuil.init(cas);
    }


}
