package fr.eni.clinique.ihm.log;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.acceuil.AcceuilController;

public class LogInController {
    private FenetreLogIn fenetreLogIn;
    private static LogInController instance;


    private LogInController() throws DALException, BLLException {
        fenetreLogIn = FenetreLogIn.getInstance();
    }

    public static synchronized LogInController getInstance() throws DALException, BLLException {
        if (instance == null) {
            instance = new LogInController();
        }
        return instance;
    }

    public void startApp() throws BLLException, DALException {
        fenetreLogIn.initLog();
    }

    public void validLogIn(String nom, String password) throws BLLException, DALException {


        //on fait find by nom
        Personnels user = PersonnelsManager.getInstance().getPersonnelByNom(nom);
        Personnels test = user;

        if (user != null) {

            //on récupére le mdp
            String passwordBase = user.getMotPasse();

            //on compare le mot de passe enregistrer avec la saisie

            if (password.equals(passwordBase)) {
                System.out.println("mot de pass bon");
                //on lance une nouvelle fenetre suivant le role de l'user
                String role = user.getRole();
                switch (role) {
                    case "adm":
                        System.out.println("admin");
                        AcceuilController.getInstance().start(3);
                        break;
                    case "sec":
                        System.out.println("secretaire");
                        AcceuilController.getInstance().start(1);
                        break;
                    case "vet":
                        System.out.println("veterinaire");
                        AcceuilController.getInstance().start(2);
                        break;
                    default:
                        System.out.println("Pas de role existant");
                }
                //on ferme la fenetre de connexion
                fenetreLogIn.exit();

            }
            //sinon on affiche l'erreur de pass

            else {
                fenetreLogIn.showError(2);
                System.out.println("Probleme de pass");
            }
        }
        //sinon on affiche l'erreur de user
        else {
            fenetreLogIn.showError(1);
            System.out.println("Probleme de user");
        }

    }

    public FenetreLogIn getFenetreLogIn() {
        return fenetreLogIn;
    }
}
