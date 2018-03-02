package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Agendas;
import fr.eni.clinique.bo.Races;
import fr.eni.clinique.dto.RDV;

import java.sql.Date;
import java.util.List;

public interface DaoAgenda extends Dao<Agendas>{
	public void delete(Agendas agenda)throws DALException;
	public List<RDV> getRDVByVetEtDate(int codeVet, Date dateRDV) throws DALException;
}
