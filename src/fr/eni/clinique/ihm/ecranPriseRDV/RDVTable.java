package fr.eni.clinique.ihm.ecranPriseRDV;

import java.sql.Date;

import javax.swing.JTable;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

public class RDVTable extends JTable{
	
	private RDVTableModel model;
	
	public RDVTable(int codeVet,Date dateRDV) throws BLLException{
		model = new RDVTableModel( codeVet,dateRDV);
		setModel(model);
	}

	public RDVTableModel getPersonnelsModel() {
		return model;
	}
	

}
