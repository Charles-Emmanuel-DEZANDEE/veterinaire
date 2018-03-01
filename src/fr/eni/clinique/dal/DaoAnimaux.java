package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;

public interface DaoAnimaux extends Dao<Animaux>{

	public Animaux selectByNom(String nom)throws DALException;
	public void delete(int  codePers)throws DALException;
	public List<Animaux> selectAminauxByClient(Clients client)throws DALException;
}
