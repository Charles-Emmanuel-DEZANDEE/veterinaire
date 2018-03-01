package fr.eni.clinique.dal;

import fr.eni.clinique.bll.BLLException;

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
		DaoClients DaoClient = new ClientsDAOJdbcImpl();
		return DaoClient;
	}
	
	public static DaoRaces getRacesDAO() throws DALException, BLLException {
        DaoRaces DaoRace = new RacesDAOJdbcImpl();
		return DaoRace;
	}

}
