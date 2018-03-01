package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.Dao;
import fr.eni.clinique.dal.DaoPersonnels;

public class PersonnelsManager {
	private static DaoPersonnels daoPersonnels;
	private static PersonnelsManager instance;
	
	public PersonnelsManager() throws  BLLException {
		//Instancier le Data Access Object
		
		try {
			daoPersonnels =DAOFactory.getPersonnelsDAO();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException("Erreur création du DaoPersonnels", e);
		}
	}

	// fait par MAHMOUDI
	public static PersonnelsManager getInstance() throws BLLException{
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
			personnel = daoPersonnels.selectByNom(nom);
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
	
	public void updatePersonnels(Personnels personnel) throws BLLException{
		try {
			this.validerPersonnel(personnel);
			daoPersonnels.update(personnel);
			
		} catch (DALException e) {
			throw new BLLException("Echec updatepersonnel-personnel:"+personnel, e);
		}
	}
	
	public void removePersonnel(int  codePers) throws BLLException{
		try {
			daoPersonnels.delete(codePers);

		} catch (DALException e) {
			throw new BLLException("Echec de la suppression de la reservation - ", e);
		}
		
	}
	
	public void archivePersonnel(Personnels  personnel) throws BLLException{
		try {
			// archiver
			personnel.setArchive(true);
			daoPersonnels.update(personnel);
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression du personnel - ", e);
		}
		
	}
	
	public void reinitMotPasse(String  nomPersonnel, String motPasse) throws BLLException{
		Personnels personnel=null;
		try {
			personnel = this.getPersonnelByNom(nomPersonnel);
			personnel.setMotPasse(motPasse);
			daoPersonnels.update(personnel);
		} catch (DALException e) {
			throw new BLLException("Echec de la reinitialisation du mot de passe - ", e);
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
