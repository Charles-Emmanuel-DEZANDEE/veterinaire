package fr.eni.clinique.ihm.ecranPriseRDV;

import javax.swing.JTable;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

public class RDVTable extends JTable{
	
	private RDVTableModel model;
	
	public RDVTable() throws BLLException{
		model = new RDVTableModel();
		setModel(model);
	}

	public RDVTableModel getPersonnelsModel() {
		return model;
	}
	

}
