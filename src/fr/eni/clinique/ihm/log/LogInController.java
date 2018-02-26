package fr.eni.clinique.ihm.log;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

public class LogInController {
    private MDIAppLogIn fenetreLogIn;
    private static LogInController instance;


    private LogInController() throws DALException, BLLException {
        fenetreLogIn = new MDIAppLogIn();
    }

    public static synchronized LogInController getInstance() throws DALException, BLLException{
        if (instance == null){
            instance = new LogInController();
        }
        return instance;
    }

    public void startApp(){
        fenetreLogIn.initLog();
    }

    public void validLogIn (){
        String nom = fenetreLogIn.getFieldLogNom().getText();
        String password = fenetreLogIn.getfieldLogPassword().getText();

        //on fait find by nom
        //Personnel user = ;

        //on récupére le mdp
        String passwordBase = "";//user.getPassword();

        //on compare le mot de passe enregistrer avec la saisie

        if (password == passwordBase){
            //on ferme la fenetre de connexion
            fenetreLogIn.exit();
            //on lance une nouvelle fenetre suivant le role de l'user
            String role = ""; // user.getRole();
            switch (role) {
                case "adm":
                    System.out.println("admin");
                    //todo controleur + mdia
                    break;
                case "sec":
                    System.out.println("secretaire");
                    //todo controleur + mdia

                    break;
                case "vet":
                    System.out.println("veterinaire");
                    //todo controleur + mdia

                    break;

                default:
                    System.out.println("Probleme");
            }

        }
        //sinon on affiche la modal

        else{
            fenetreLogIn.showError();
        }

    }
}
