package fr.eni.clinique.ihm.ecranDossierMedical;

import fr.eni.clinique.bll.AnimauxManager;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.Races;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;


public class DossierMedicalController {
    private FenetreDossierMedical fenetreDossierMedical;
    private static DossierMedicalController instance;


    private DossierMedicalController() throws BLLException {
    }

    public static synchronized DossierMedicalController getInstance() throws  BLLException {
        if (instance == null) {
            instance = new DossierMedicalController();
        }
        return instance;
    }

    public void init(Animaux animal) throws BLLException {
        fenetreDossierMedical =  new FenetreDossierMedical();

        Clients client = ClientsManager.getInstance().getClientById(animal.getCodeClient());
        fenetreDossierMedical.init(animal, client);
        //On remplit le champ antécédents
        fenetreDossierMedical.getFieldAntecedents().setText(animal.getAntecedents());
    }


    public void enregistrer(Animaux animal) throws BLLException {
        //on recupére la saisie
        animal.setAntecedents(fenetreDossierMedical.getFieldAntecedents().getText());

        //on update en base
        AnimauxManager.getInstance().updateAnimal(animal);
    }


}
