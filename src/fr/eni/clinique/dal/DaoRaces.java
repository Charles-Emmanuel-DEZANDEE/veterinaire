package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Races;

import java.util.List;

public interface DaoRaces extends Dao<Races>{

	public List<Races> selectByEspece(String espece)throws DALException;
	public Races selectByPK(String race, String espece)throws DALException;
}
