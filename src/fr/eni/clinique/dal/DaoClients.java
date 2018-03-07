package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.Personnels;

public interface DaoClients extends Dao<Clients>{
	public List<Clients> selectByNom(String NomClient) throws DALException;
}
