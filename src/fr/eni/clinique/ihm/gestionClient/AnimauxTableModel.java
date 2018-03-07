package fr.eni.clinique.ihm.gestionClient;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.AnimauxManager;
import fr.eni.clinique.bo.Animaux;


public class AnimauxTableModel extends AbstractTableModel{
	
	String[] animaux = {"Numéro", "Nom", "Sexe", "Couleur", "Race", "Espece", "Tatouage"};
	
	private List<Animaux> listeAnimaux;
	
	public AnimauxTableModel() throws BLLException, DALException{
		this.listeAnimaux = new ArrayList<>();
	}
	
	public List<Animaux> getListeAnimaux() {
		return listeAnimaux;
	}

	@Override
	public int getColumnCount() {
		return animaux.length;
	}

	@Override
	public int getRowCount() {
		return this.listeAnimaux.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return animaux[col];
	}

	@Override
	public Object getValueAt(int arg0, int col) {
		if (col == 0){
			return listeAnimaux.get(arg0).getCodeAnimal();
		}
		if(col == 1){
			return listeAnimaux.get(arg0).getNomAnimal();
		}
		if(col == 2){
			return listeAnimaux.get(arg0).getSexe();
		}
		if(col == 3){
			return listeAnimaux.get(arg0).getCouleur();
		}
		if(col == 4){
			return listeAnimaux.get(arg0).getRace();
		}
		if(col == 5){
			return listeAnimaux.get(arg0).getEspece();
		}
		if(col == 6){
			return listeAnimaux.get(arg0).getTatouage();
		}
		return null;
	}
	
}
