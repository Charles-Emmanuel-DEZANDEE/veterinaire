package fr.eni.clinique.bll;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Agendas;
import fr.eni.clinique.dal.AgendaDAOJdbcImpl;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.DaoAgenda;
import fr.eni.clinique.dto.RDV;

public class AgendaManager {
	private static DaoAgenda daoAgendas;
	private static AgendaManager instance;

	public AgendaManager() throws BLLException {
		try {
			daoAgendas = DAOFactory.getAgendasDAO();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	public static AgendaManager getInstance() throws BLLException{
		if (AgendaManager.instance == null){
			AgendaManager.instance = new AgendaManager();
		}
		return AgendaManager.instance;
	}
	
	public void addAgenda(Agendas agenda) throws BLLException {
		try {
			this.validerRDV(agenda);
			daoAgendas.insert(agenda);
		} catch (DALException e) {
			throw new BLLException("Echec ajout de l'agenda", e);
		}
	}
	
	public void updateRDV(Agendas agenda) throws BLLException{
		try {
			this.validerRDV(agenda);
			daoAgendas.update(agenda);
		} catch (DALException e) {
			throw new BLLException("Echec modification de l'agenda" + agenda, e);
		}
	}
	
	public void removeRDV(Agendas agenda) throws BLLException{
		try {
			((AgendaDAOJdbcImpl)daoAgendas).delete(agenda);
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression du RDV", e);
		}
	}
	
	public List<Agendas> getListeRDV() throws BLLException{
		List<Agendas> data = new ArrayList<>();
		try {
			data = daoAgendas.selectAll();
		} catch (DALException e) {
			throw new BLLException("Echec de la récupération de la liste des RDV", e);
		}
		return data;
	}
	
	public List<RDV> getRDVByVetEtDate(Long codeVet, Date dateRDV) throws BLLException{
		List<RDV> data = new ArrayList<>();
		try {
			data = daoAgendas.getRDVByVetEtDate(codeVet, dateRDV);
		} catch (DALException e) {
			throw new BLLException("Echec de la récupération de la liste des RDV", e);
		}
		return data;
	}
	

	public void validerRDV(Agendas agenda) throws BLLException
	{
		boolean valider = true;
		StringBuffer sb = new StringBuffer();

		if(agenda == null){
			throw new BLLException("race null");
		}
		if(agenda.getCodeAnimal() == 0){
			sb.append("Le code Animal est obligatoire \n");
			valider = false;
		}
		if(agenda.getCodeVeto() == 0){
			sb.append("Le code veterinaire est obligatoire \n");
			valider = false;
		}
		if(agenda.getDateRdv() == null){
			sb.append("La date du RDV est obligatoire \n");
			valider = false;
		}
		if(!valider){
			throw new BLLException(sb.toString());
		}
	}
}
