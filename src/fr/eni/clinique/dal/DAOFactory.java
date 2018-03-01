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

	public static DaoAnimaux getAnimauxDAO() throws DALException, BLLException {
		DaoAnimaux daoAnimau = new AnimauxDAOJdbcImpl();
		return daoAnimau;
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
