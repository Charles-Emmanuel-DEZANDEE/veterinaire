package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.DaoClients;

public class ClientsManager {
	private static DaoClients daoClients;
	private static ClientsManager instance;

	public ClientsManager() throws BLLException {
		daoClients = DAOFactory.getClientsDAO();
	}
	
	public static ClientsManager getInstance() throws BLLException{
		if (ClientsManager.instance == null){
			ClientsManager.instance = new ClientsManager();
		}
		return ClientsManager.instance;
	}
	
	public Clients getClientById(Long CodeClient) throws BLLException{
		Clients client = null;
		try {
			client = daoClients.selectById(CodeClient);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur r�cup�ration de l'client par Id", e);
		}
		return client;
	}
	
	public List<Clients> getClientByNom(String NomClient) throws BLLException{
		List<Clients> clients = null;
		try {
			clients = daoClients.selectByNom(NomClient);
		}catch (DALException e){
			e.printStackTrace();
			throw new BLLException("Erreur r�cup�ration de la liste des clients par nom", e);
		}
		return clients;
	}

	public List<Clients> getListeClients() throws BLLException{
		List<Clients> clients = null;
		try {
			clients = daoClients.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur r�cup�ration de la liste des clients", e);
		}	
		return clients;
	}

	public void updateClient(Clients client) throws BLLException{
		try {
			this.validerClient(client);
			daoClients.update(client);
		} catch (DALException e) {
			throw new BLLException("Echec modification de l'client" + client, e);
		}
	}
	
	public void removeClient(Clients client) throws BLLException{
		try {
			client.setArchive(true);
			daoClients.update(client);
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression de l'client", e);
		}
	}
	
	public void archiverClient(Long CodeClient) throws BLLException{
		Clients client = null;
		try {
			client = this.getClientById(CodeClient);
			client.setArchive(true);
			daoClients.update(client);
		} catch (DALException e) {
			throw new BLLException("Echec de l'archivage du client", e);
		}
	}
	
	public void addClient(Clients client) throws BLLException {
		try {
			this.validerClient(client);
			daoClients.insert(client);
		} catch (DALException e) {
			throw new BLLException("Echec ajout d'un client", e);
		}
	}

	public void validerClient(Clients client) throws BLLException
	{
		boolean valider = true;
		StringBuffer sb = new StringBuffer();

		if(client == null){
			throw new BLLException("client null");
		}
		if(client.getClient().equals("")){
			sb.append("Le nom est obligatoire \n");
			valider = false;
		}
		if(client.getPrenomClient().equals("")){
			sb.append("Le prenom est obligatoire \n");
			valider = false;
		}
		if(client.getAdresse1().equals("")){
			sb.append("L'adresse est obligatoire \n");
			valider = false;
		}
		if(client.getCodePostal().equals("")){
			sb.append("Le code postal est obligatoire \n");
			valider = false;
		}
		if(client.getVille().equals("")){
			sb.append("La ville est obligatoire \n");
			valider = false;
		}
		if(client.getEmail().equals("")){
			sb.append("L'email est obligatoire \n");
			valider = false;
		}
		if(!valider){
			throw new BLLException(sb.toString());
		}
	}
}
