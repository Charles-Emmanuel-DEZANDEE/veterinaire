package fr.eni.clinique.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.*;

public class AnimauxManager {
	private static DaoAnimaux daoAnimaux;
	private static AnimauxManager instance;
	
	public AnimauxManager() throws BLLException {
		try {
			daoAnimaux = DAOFactory.getAnimauxDAO();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	public static AnimauxManager getInstance() throws BLLException{
		if (AnimauxManager.instance == null){
			AnimauxManager.instance = new AnimauxManager();
		}
		return AnimauxManager.instance;
	}
	
	public Animaux getAnimalById(long CodeAnimal) throws BLLException{
		Animaux animal = null;
		try {
			animal = daoAnimaux.selectById(CodeAnimal);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur r�cup�ration de l'animal par Id", e);
		}
		return animal;
	}
	
	public List<Animaux> getAnimalByClient(Clients client) throws BLLException{
		List<Animaux> data = new ArrayList<>();
		try {
			data = ((AnimauxDAOJdbcImpl)daoAnimaux).selectAminauxByClient(client);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur r�cup�ration de l'animal par client", e);
		}
		return data;
	}

	public Animaux getAnimalByNom(String NomAnimal) throws BLLException{
		Animaux animal = null;
		try {
			animal = ((AnimauxDAOJdbcImpl)daoAnimaux).selectByNom(NomAnimal);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur r�cup�ration de l'animal par Nom", e);
		}
		return animal;
	}
	
	public List<Animaux> getListeAnimaux() throws BLLException{
		List<Animaux> animaux = null;
		try {
			animaux = daoAnimaux.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur r�cup�ration de la liste des animaux", e);
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
			throw new BLLException("Echec modification de l'animal" , e);
		}
	}
	
	public void removeAnimal(Animaux animal) throws BLLException{
		try {
			animal.setArchive(true);
			daoAnimaux.update(animal);
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression de l'animal", e);
		}
	}
	
	public void archiverAnimal(Long CodeAnimal) throws BLLException{
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
		if(animal.getNomAnimal().equals("")){
			sb.append("Le nom est obligatoire \n");
			valider = false;
		}
		if(animal.getSexe().equals(null)){
			sb.append("Le sexe est obligatoire \n");
			valider = false;
		}
		if(animal.getCouleur().equals("")){
			sb.append("La couleur est obligatoire \n");
			valider = false;
		}
		if(animal.getRace() == null){
			sb.append("La Race est obligatoire \n");
			valider = false;
		}
		if(animal.getEspece() == null){
			sb.append("L'Espece est obligatoire \n");
			valider = false;
		}
		if(!valider){
			throw new BLLException(sb.toString());
		}
	}
}
