package fr.eni.clinique.ihm.gestionClient;

import javax.swing.JTable;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

public class AnimauxTable extends JTable{
	
	private AnimauxTableModel model;
	
	public AnimauxTable() throws BLLException, DALException{
		model = new AnimauxTableModel();
		setModel(model);
	}

	public AnimauxTableModel getAnimauxModel() {
		return model;
	}
	

}
