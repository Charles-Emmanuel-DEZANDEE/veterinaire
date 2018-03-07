package fr.eni.clinique.ihm.animal;

import fr.eni.clinique.bll.AnimauxManager;
import fr.eni.clinique.bll.BLLException;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.Races;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;


public class AnimalController {
    private FenetreAnimal fenetreAnimal;
    private static AnimalController instance;


    private AnimalController() throws  BLLException {
        fenetreAnimal = FenetreAnimal.getInstance();
    }

    public static synchronized AnimalController getInstance() throws BLLException {
        if (instance == null) {
            instance = new AnimalController();
        }
        return instance;
    }

    public void nouveau(Clients client) throws BLLException {
        fenetreAnimal.init(client,true);
        //on vide les champs texte de l'animal
        fenetreAnimal.getFieldCouleur().setText("");
        fenetreAnimal.getFieldNom().setText("");
        fenetreAnimal.getFieldTatouage().setText("");

    }

    public void update(Clients client, Animaux animal) throws BLLException, DALException {
        fenetreAnimal.init(client,false);
        int code = animal.getCodeAnimal();
        //on rempli les champs de l'animal
        fenetreAnimal.getCode().setText(String.valueOf(animal.getCodeAnimal()));
        fenetreAnimal.getFieldNom().setText(animal.getNomAnimal());
        fenetreAnimal.getFieldTatouage().setText(animal.getTatouage());
        fenetreAnimal.getFieldCouleur().setText(animal.getCouleur());
        fenetreAnimal.getCboGenreAnimal().setSelectedItem(sexAAfficher(animal.getSexe()));
        fenetreAnimal.getCboEspece().setSelectedItem(animal.getEspece());
        fenetreAnimal.getCboRace().setSelectedItem(animal.getRace());
    }

    public void enregistrer (Clients client, Boolean nouveau) throws BLLException, DALException {
        //on récupére les infos de la race et l'animal
        Races race = DAOFactory.getRacesDAO().selectByPK(fenetreAnimal.getCboEspece().getSelectedItem().toString(),fenetreAnimal.getCboRace().getSelectedItem().toString());

        if (nouveau)
        {
            Integer codeclie = client.getCodeClient();
            Animaux animal = new Animaux(
                    fenetreAnimal.getFieldNom().getText(),
                    sexAEnregistrer(fenetreAnimal.getCboGenreAnimal().getSelectedItem().toString()),
                    fenetreAnimal.getFieldCouleur().getText(),
                    fenetreAnimal.getCboRace().getSelectedItem().toString(),
                    fenetreAnimal.getCboEspece().getSelectedItem().toString(),
                    client.getCodeClient(),
                    fenetreAnimal.getFieldTatouage().getText(),
                    "",
                    false
            );
            Animaux test = animal;
            // on enregistre en base
            AnimauxManager.getInstance().addAnimal(animal);
//            DAOFactory.getAnimauxDAO().insert(animal);
        }
        else {
            Animaux animal = new Animaux(
                    Integer.parseInt(fenetreAnimal.getCode().getText()),
                    fenetreAnimal.getFieldNom().getText(),
                    sexAEnregistrer(fenetreAnimal.getCboGenreAnimal().getSelectedItem().toString()),
                    fenetreAnimal.getFieldCouleur().getText(),
                    fenetreAnimal.getCboRace().getSelectedItem().toString(),
                    fenetreAnimal.getCboEspece().getSelectedItem().toString(),
                    client.getCodeClient(),
                    fenetreAnimal.getFieldTatouage().getText(),
                    "",
                    false
            );
            // on enregistre en base
            AnimauxManager.getInstance().updateAnimal(animal);

//            DAOFactory.getAnimauxDAO().update(animal);
        }

        //on cache la fenetre
        fenetreAnimal.dispose();

    }

    public void annuler (){
        //on cache la fenetre
        fenetreAnimal.dispose();

        //todo on retourne a la page du clients

    }

    public String sexAEnregistrer(String sex){
        String sexAenregistrer = "";
        if (sex.equals("Femelle")){
            sexAenregistrer= "F";
        }
        if (sex.equals("Male")){
            sexAenregistrer= "M";
        }
        if (sex.equals("hermaphrodite")){
            sexAenregistrer= "H";
        }
        return sexAenregistrer;
    }

    public String sexAAfficher(String sex){
        String sexAAfficher = "";
        if (sex.equals("F")){
            sexAAfficher= "Femelle";
        }
        if (sex.equals("M")){
            sexAAfficher= "Male";
        }
        if (sex.equals("H")){
            sexAAfficher= "hermaphrodite";
        }
        return sexAAfficher;
    }


}
