package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.Dao;
import fr.eni.clinique.dal.PersonnelsDAOJdbcImpl;

public class PersonnelsManager {
	private static Dao<Personnels> daoPersonnels;
	private static PersonnelsManager instance;
	
	public PersonnelsManager() throws DALException, BLLException {
		//Instancierr le Data Access Object
		daoPersonnels =DAOFactory.getPersonnelsDAO();
	}

	// fait par MAHMOUDI
	public static PersonnelsManager getInstance() throws BLLException, DALException{
		if ( PersonnelsManager.instance == null){
			PersonnelsManager.instance = new PersonnelsManager();
		}
		return PersonnelsManager.instance;
	}
	
	public Personnels getPersonnelById(int codePers) throws BLLException{
		Personnels personnel=null;
		try {
			personnel = daoPersonnels.selectById(codePers);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur r?cup?ration du personnel par Id", e);
		}
		
		return personnel;
	}
	
	public Personnels getPersonnelByNom(String nom) throws BLLException{
		Personnels personnel=null;
		try {
			personnel = ((PersonnelsDAOJdbcImpl)daoPersonnels).selectByNom(nom);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur r?cup?ration du personnel par Id", e);
		}
		
		return personnel;
	}
	
	
	public List<Personnels> getListePersonnel() throws BLLException{
		List<Personnels> personnels=null;
		try {
			personnels = daoPersonnels.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur r?cup?ration de la liste du pesonnel", e);
		}
		
		return personnels;
	}
	
	
	public void addPersonnel(Personnels newPersonnel) throws BLLException {

		try {
			//on valide le personnel
			this.validerPersonnel(newPersonnel);

			// on ajoute le personnel
			daoPersonnels.insert(newPersonnel);
			
		} catch (DALException e) {
			throw new BLLException("Echec addPersonnel", e);
		}
	}
	
	public void updateReservation(Personnels personnel) throws BLLException{
		try {
			this.validerPersonnel(personnel);
			daoPersonnels.update(personnel);
			
		} catch (DALException e) {
			throw new BLLException("Echec updatepersonnel-personnel:"+personnel, e);
		}
	}
	
	public void removePersonnel(int  codePers) throws BLLException{
		try {
			((PersonnelsDAOJdbcImpl)daoPersonnels).delete(codePers);

		} catch (DALException e) {
			throw new BLLException("Echec de la suppression de la reservation - ", e);
		}
		
	}
	
	public void archivePersonnel(int  codePers) throws BLLException{
		Personnels personnel=null;
		try {
			personnel = this.getPersonnelById(codePers);
			// archiver
			personnel.setArchive(true);
			daoPersonnels.update(personnel);
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression de la reservation - ", e);
		}
		
	}

	public void validerPersonnel(Personnels personnel) throws BLLException
	{
		boolean valide = true;
		StringBuffer sb = new StringBuffer();

		if(personnel==null){
			throw new BLLException("personnel null");
		}
		//Les attributs du personnel sont obligatoires
		if(personnel.getNom() == null){
			sb.append("Le nom est obligatoire \n");
			valide = false;
		}
		if(personnel.getMotPasse() == null){
			sb.append("Le mot de passe est obligatoire \n");
			valide = false;
		}
		if(personnel.getRole() == null){
			sb.append("Le role est obligatoire \n");
			valide = false;
		}

		if(!valide){
			throw new BLLException(sb.toString());
		}

	}
	

}
