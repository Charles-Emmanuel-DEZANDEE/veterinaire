package fr.eni.clinique.bll;

import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.*;

import java.util.List;

public class ClientsManager {
	private static DaoClients daoClients;
	private static ClientsManager instance;

	public ClientsManager() throws DALException, BLLException {
		daoClients = DAOFactory.getClientsDAO();
	}
	
	public static ClientsManager getInstance() throws BLLException, DALException{
		if (ClientsManager.instance == null){
			ClientsManager.instance = new ClientsManager();
		}
		return ClientsManager.instance;
	}
	
	public Clients getClientById(int CodeClient) throws BLLException{
		Clients client = null;
		try {
			client = daoClients.selectById(CodeClient);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur r�cup�ration de l'client par Id", e);
		}
		return client;
	}
	

	public List<Clients> getListeClients() throws BLLException{
		List<Clients> animaux = null;
		try {
			animaux = daoClients.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur r�cup�ration de la liste des animaux", e);
		}	
		return animaux;
	}
	
	public void addAnimal(Clients client) throws BLLException {
		try {
			this.validerAnimal(client);
			daoClients.insert(client);
		} catch (DALException e) {
			throw new BLLException("Echec ajout d'un client", e);
		}
	}
	
	public void updateAnimal(Clients client) throws BLLException{
		try {
			this.validerAnimal(client);
			daoClients.update(client);
		} catch (DALException e) {
			throw new BLLException("Echec modification de l'client" + client, e);
		}
	}
	
	public void removeAnimal(int CodeClient) throws BLLException{
		try {
			((ClientsDAOJdbcImpl)daoClients).delete(CodeClient);
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression de l'client", e);
		}
	}
	
	public void archiverAnimal(int CodeClient) throws BLLException{
		Clients client = null;
		try {
			client = this.getClientById(CodeClient);
			client.setArchive(true);
			daoClients.update(client);
		} catch (DALException e) {
			throw new BLLException("Echec de l'archive de l'client", e);
		}
	}

	public void validerAnimal(Clients client) throws BLLException
	{
		boolean valider = true;
		StringBuffer sb = new StringBuffer();

		if(client == null){
			throw new BLLException("client null");
		}
		if(client.getCodeClient() == 0){
			sb.append("Le code client est obligatoire \n");
			valider = false;
		}
		if(client.getClient() == null){
			sb.append("Le nom est obligatoire \n");
			valider = false;
		}
		if(client.getAdresse1() == null){
			sb.append("L'adresse est obligatoire \n");
			valider = false;
		}
		if(client.getCodePostal() == null){
			sb.append("Le code postal est obligatoire \n");
			valider = false;
		}
		if(client.getVille() == null){
			sb.append("La ville est obligatoire \n");
			valider = false;
		}
		if(client.getEmail() == null){
			sb.append("L'email est obligatoire \n");
			valider = false;
		}
		if(!valider){
			throw new BLLException(sb.toString());
		}
	}
}
