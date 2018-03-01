package fr.eni.clinique.bll;

import fr.eni.clinique.bo.Races;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class RacesManager {
	private static DaoRaces daoRaces;
	private static RacesManager instance;

	public RacesManager() throws BLLException {
		try {
			daoRaces = DAOFactory.getRacesDAO();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	public static RacesManager getInstance() throws BLLException, DALException{
		if (RacesManager.instance == null){
			RacesManager.instance = new RacesManager();
		}
		return RacesManager.instance;
	}
	

//todo
//	public List<Races> getListeRacesByEspece(String espece) throws BLLException{
//		List<Races> r1 = null;
//		try {
//			r1 = ((RacesDAOJdbcImpl)daoRaces).selectByEspece(espece);
//		} catch (DALException e) {
//			e.printStackTrace();
//			throw new BLLException("Erreur r�cup�ration de la race par Nom", e);
//		}
//		return r1;
//	}
	
	public List<String> getListeRaces(String espece) throws BLLException{
		List<String> races = null;
		try {
			races = daoRaces.getListRaceByEspece(espece);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur r�cup�ration de la liste des races", e);
		}	
		return races;
	}

	public List<String> getListeEspece() throws BLLException {
		List<String> especes = null;
		try {
			especes = daoRaces.getListEspece();
		} catch (DALException e) {
			e.printStackTrace();
		}
		return especes;
	}
	
	public void addrace(Races race) throws BLLException {
		try {
			this.validerAnimal(race);
			daoRaces.insert(race);
		} catch (DALException e) {
			throw new BLLException("Echec ajout d'une race", e);
		}
	}
	
	public void updateRace(Races race) throws BLLException{
		try {
			this.validerAnimal(race);
			daoRaces.update(race);
		} catch (DALException e) {
			throw new BLLException("Echec modification de l'race" + race, e);
		}
	}
	
	public void removeRace(String race, String espece) throws BLLException{
		try {
			((RacesDAOJdbcImpl)daoRaces).delete(race, espece);
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression de l'race", e);
		}
	}
	

	public void validerAnimal(Races race) throws BLLException
	{
		boolean valider = true;
		StringBuffer sb = new StringBuffer();

		if(race == null){
			throw new BLLException("race null");
		}
		if(race.getRace() == null){
			sb.append("La race est obligatoire \n");
			valider = false;
		}
		if(!valider){
			throw new BLLException(sb.toString());
		}
	}
}
