package fr.eni.clinique.ihm.ecranPriseRDV;

import javax.swing.JTable;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

public class PersonnelsTable extends JTable{
	
	private PersonnelsTableModel model;
	
	public PersonnelsTable() throws BLLException{
		model = new PersonnelsTableModel();
		setModel(model);
	}

	public PersonnelsTableModel getPersonnelsModel() {
		return model;
	}
	

}
