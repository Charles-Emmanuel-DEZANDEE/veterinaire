package fr.eni.clinique.dal;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Personnels;

public class DAOFactory {

	
	public static Dao<Personnels> getPersonnelsDAO() throws DALException, BLLException {
		Dao<Personnels> sDao = new PersonnelsDAOJdbcImpl();
		return sDao;
	}

	public static Dao<Animaux> getAnimauxDAO() throws DALException, BLLException {
		Dao<Animaux> sDao = new AnimauxDAOJdbcImpl();
		return sDao;
	}
	
	
	/*
	public static Dao<Reservation> getReservationDAO() throws DALException, BLLException {
		// todo mettre le jdbc de reservation
		Dao<Reservation> rDao = new ReservationDAOJdbcImpl();
		return rDao;
	}

	public static Dao<Client> getClientDAO() throws DALException, BLLException {
		// todo mettre le jdbc de reservation
		Dao<Client> cDao = new ClientDAOJdbcImpl();
		return cDao;
	}
*/
}
