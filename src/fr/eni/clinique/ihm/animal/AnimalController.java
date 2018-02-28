package fr.eni.clinique.ihm.animal;

import fr.eni.clinique.bll.BLLException;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
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

    public void nouveau(Clients client) throws BLLException, DALException {
        fenetreLogIn.init(client,true);
        //on vide les champs texte de l'animal
        fenetreLogIn.getFieldCouleur().setText("");
        fenetreLogIn.getFieldNom().setText("");
        fenetreLogIn.getFieldTatouage().setText("");

    }

    public void update(Clients client, Animaux animal) throws BLLException, DALException {
        fenetreLogIn.init(client,false);
        //on rempli les champs de l'animal
        fenetreLogIn.getCode().setText(String.valueOf(animal.getCodeAnimal()));
        fenetreLogIn.getFieldNom().setText(animal.getNomAnimal());
        fenetreLogIn.getFieldTatouage().setText(animal.getTatouage());
        fenetreLogIn.getFieldCouleur().setText(animal.getCouleur());
        fenetreLogIn.getCboGenreAnimal().setSelectedItem(animal.getSexe());
        fenetreLogIn.getCboEspece().setSelectedItem(animal.getEspece());
        fenetreLogIn.getCboRace().setSelectedItem(animal.getRace());
    }

    public void enregistrer (Animaux animal, Clients client){
        // on enregistre en base

        //on cache la fenetre
        fenetreLogIn.cacher();

    }

    public void annuler (){
        //on cache la fenetre
        fenetreLogIn.cacher();

        //todo on affiche la page  de liste de clients

    }

}
