package fr.eni.clinique.dal;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.bo.Races;

public class DAOFactory {

	
	public static DaoPersonnels getPersonnelsDAO() throws DALException, BLLException {
		DaoPersonnels daoPersonnels = new PersonnelsDAOJdbcImpl();
		return daoPersonnels;
	}

	public static Dao<Animaux> getAnimauxDAO() throws DALException, BLLException {
		Dao<Animaux> aDao = new AnimauxDAOJdbcImpl();
		return aDao;
	}
	
	public static DaoClients getClientsDAO() throws DALException, BLLException {
		DaoClients aDao = new ClientsDAOJdbcImpl();
		return aDao;
	}
	
	public static DaoRaces getRacesDAO() throws DALException, BLLException {
        DaoRaces aDao = new RacesDAOJdbcImpl();
		return aDao;
	}

}
