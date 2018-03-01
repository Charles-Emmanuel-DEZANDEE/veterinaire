package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Personnels;

public interface DaoPersonnels extends Dao<Personnels>{

	public Personnels selectByNom(String nom)throws DALException;
	public void delete(int  codePers)throws DALException;
}
