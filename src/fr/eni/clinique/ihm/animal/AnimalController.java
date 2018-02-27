package fr.eni.clinique.ihm.animal;

import fr.eni.clinique.bll.BLLException;

import fr.eni.clinique.dal.DALException;


public class AnimalController {
    private MDIAppAnimal fenetreLogIn;
    private static AnimalController instance;


    private AnimalController() throws DALException, BLLException {
        fenetreLogIn = MDIAppAnimal.getInstance();
    }

    public static synchronized AnimalController getInstance() throws DALException, BLLException {
        if (instance == null) {
            instance = new AnimalController();
        }
        return instance;
    }

    public void start() throws BLLException, DALException {
        fenetreLogIn.init();
    }

}
