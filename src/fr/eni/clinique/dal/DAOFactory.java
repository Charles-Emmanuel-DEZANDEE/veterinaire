package fr.eni.clinique.dal;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.Personnels;

public class DAOFactory {

	
	public static Dao<Personnels> getPersonnelsDAO() throws DALException, BLLException {
		Dao<Personnels> sDao = new PersonnelsDAOJdbcImpl();
		return sDao;
	}

	public static Dao<Animaux> getAnimauxDAO() throws DALException, BLLException {
		Dao<Animaux> aDao = new AnimauxDAOJdbcImpl();
		return aDao;
	}
	
	public static Dao<Clients> getClientsDAO() throws DALException, BLLException {
		Dao<Clients> aDao = new ClientsDAOJdbcImpl();
		return aDao;
	}
	
}
