package fr.eni.clinique.ihm.gestionClient;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.DALException;

public class GererClientController {
    private MDIAppClient fenetreGestionClient;
    private static GererClientController instance;


    private GererClientController() throws BLLException {
    }

    public static synchronized GererClientController getInstance() throws BLLException{
        if (instance == null){
            instance = new GererClientController();
        }
        return instance;
    }

	public void startApp() throws BLLException, DALException {
		fenetreGestionClient = new MDIAppClient();
		fenetreGestionClient.init();
		fenetreGestionClient.revalidate();
		fenetreGestionClient.repaint();
	}
	
	public void actualiserFenetre() throws BLLException, DALException{
		fenetreGestionClient.getFieldCodeClient().setText("");
		fenetreGestionClient.getFieldNomClient().setText("");
		fenetreGestionClient.getFieldPrenomClient().setText("");
		fenetreGestionClient.getFieldAdresse1Client().setText("");
		fenetreGestionClient.getFieldAdresse2Client().setText("");
		fenetreGestionClient.getFieldCPClient().setText("");
		fenetreGestionClient.getFieldVilleClient().setText("");
		fenetreGestionClient.getFieldNumTelClient().setText("");
		fenetreGestionClient.getFieldAssuranceClient().setText("");
		fenetreGestionClient.getFieldEmailClient().setText("");
		fenetreGestionClient.getFieldRemarqueClient().setText("");
		fenetreGestionClient.init();
		fenetreGestionClient.revalidate();
		fenetreGestionClient.repaint();
	}

	public void ajouterClient(Clients client) throws BLLException {
			try {
				ClientsManager.getInstance().addClient(client);
			} catch (BLLException e) {
				throw new BLLException("Echec ajout d'un client", e);
			}
	}
	
	public void modifierClient(Clients client) throws BLLException, DALException {
		ClientsManager.getInstance().updateClient(client);
	}
	
	public void supprimerClient(Clients client) throws BLLException, DALException {
		ClientsManager.getInstance().removeClient(client);
	}
}
