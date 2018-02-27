package fr.eni.clinique.ihm.log;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;

public class LogInController {
    private MDIAppLogIn fenetreLogIn;
    private static LogInController instance;


    private LogInController() throws DALException, BLLException {
        fenetreLogIn = MDIAppLogIn.getInstance();
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

        if (user != null) {

            //on récupére le mdp
            String passwordBase = user.getMotPasse();

            //on compare le mot de passe enregistrer avec la saisie

            if (password.equals(passwordBase)) {
                System.out.println("mot de pass bon");
                //on ferme la fenetre de connexion
                //fenetreLogIn.exit();
                //on lance une nouvelle fenetre suivant le role de l'user
                String role = user.getRole();
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
                        System.out.println("Pas de role existant");
                }

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
}
