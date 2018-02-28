package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.Dao;
import fr.eni.clinique.dal.AnimauxDAOJdbcImpl;

public class AnimauxManager {
	private static Dao<Animaux> daoAnimaux;
	private static AnimauxManager instance;
	
	public AnimauxManager() throws DALException, BLLException {
		daoAnimaux = DAOFactory.getAnimauxDAO();
	}
	
	public static AnimauxManager getInstance() throws BLLException, DALException{
		if (AnimauxManager.instance == null){
			AnimauxManager.instance = new AnimauxManager();
		}
		return AnimauxManager.instance;
	}
	
	public Animaux getAnimalById(int CodeAnimal) throws BLLException{
		Animaux animal = null;
		try {
			animal = daoAnimaux.selectById(CodeAnimal);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur récupération de l'animal par Id", e);
		}
		return animal;
	}
	
	public Animaux getAnimalByNom(String NomAnimal) throws BLLException{
		Animaux animal = null;
		try {
			animal = ((AnimauxDAOJdbcImpl)daoAnimaux).selectByNom(NomAnimal);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur récupération de l'animal par Nom", e);
		}
		return animal;
	}
	
	public List<Animaux> getListeAnimaux() throws BLLException{
		List<Animaux> animaux = null;
		try {
			animaux = daoAnimaux.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur récupération de la liste des animaux", e);
		}	
		return animaux;
	}
	
	public void addAnimal(Animaux animal) throws BLLException {
		try {
			this.validerAnimal(animal);
			daoAnimaux.insert(animal);
		} catch (DALException e) {
			throw new BLLException("Echec ajout d'un animal", e);
		}
	}
	
	public void updateAnimal(Animaux animal) throws BLLException{
		try {
			this.validerAnimal(animal);
			daoAnimaux.update(animal);
		} catch (DALException e) {
			throw new BLLException("Echec modification de l'animal" + animal, e);
		}
	}
	
	public void removeAnimal(int CodeAnimal) throws BLLException{
		try {
			((AnimauxDAOJdbcImpl)daoAnimaux).delete(CodeAnimal);
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression de l'animal", e);
		}
	}
	
	public void archiverAnimal(int CodeAnimal) throws BLLException{
		Animaux animal = null;
		try {
			animal = this.getAnimalById(CodeAnimal);
			animal.setArchive(true);
			daoAnimaux.update(animal);
		} catch (DALException e) {
			throw new BLLException("Echec de l'archive de l'animal", e);
		}
	}

	public void validerAnimal(Animaux animal) throws BLLException
	{
		boolean valider = true;
		StringBuffer sb = new StringBuffer();

		if(animal == null){
			throw new BLLException("animal null");
		}
		if(animal.getCodeClient() == 0){
			sb.append("Le code client est obligatoire \n");
			valider = false;
		}
		if(animal.getNomAnimal() == null){
			sb.append("Le nom est obligatoire \n");
			valider = false;
		}
		if(animal.getSexe() == null){
			sb.append("Le sexe est obligatoire \n");
			valider = false;
		}
		if(animal.getCouleur() == null){
			sb.append("La couleur est obligatoire \n");
			valider = false;
		}
		if(animal.getRace() == null){
			sb.append("La Race est obligatoire \n");
			valider = false;
		}
		if(animal.getEspece() == null){
			sb.append("L'Espèce est obligatoire \n");
			valider = false;
		}
		if(!valider){
			throw new BLLException(sb.toString());
		}
	}
}
