package fr.eni.clinique.bll;

import fr.eni.clinique.bo.Races;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.RacesDAOJdbcImpl;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class RacesManager {
	private static Dao<Races> daoRaces;
	private static RacesManager instance;

	public RacesManager() throws DALException, BLLException {
		daoRaces = DAOFactory.getRacesDAO();
	}
	
	public static RacesManager getInstance() throws BLLException, DALException{
		if (RacesManager.instance == null){
			RacesManager.instance = new RacesManager();
		}
		return RacesManager.instance;
	}
	

//todo
	public List<Races> getListeRacesByEspece(String espece) throws BLLException{
		List<Races> r1 = null;
		try {
			r1 = ((RacesDAOJdbcImpl)daoRaces).selectByEspece(espece);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur r�cup�ration de la race par Nom", e);
		}
		return r1;
	}
	
	public List<Races> getListeRaces() throws BLLException{
		List<Races> races = null;
		try {
			races = daoRaces.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur r�cup�ration de la liste des races", e);
		}	
		return races;
	}

	public List<String> getListeEspece() throws BLLException {
		List<Races> races = getListeRaces();
		ListIterator<Races> it = races.listIterator();
		List<String> especes = null;
		while(it.hasNext()){
			especes.add( it.next().getEspece());
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
