package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Personnels;

public interface DaoPersonnels extends Dao<Personnels>{

	public Personnels selectByNom(String nom)throws DALException;
	public void delete(int  codePers)throws DALException;
	public List<Personnels> selectListeVeterniaires() throws DALException;
}
