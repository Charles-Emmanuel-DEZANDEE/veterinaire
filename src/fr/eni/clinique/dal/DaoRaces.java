package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Races;

import java.util.List;

public interface DaoRaces extends Dao<Races>{

	public List<String> getListRaceByEspece(String espece)throws DALException;
	public List<String> getListEspece() throws DALException;
	public Races selectByPK(String race, String espece)throws DALException;
}
