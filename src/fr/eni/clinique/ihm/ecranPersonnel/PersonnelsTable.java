package fr.eni.clinique.ihm.ecranPersonnel;

import javax.swing.JTable;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

public class PersonnelsTable extends JTable{
	
	public PersonnelsTable() throws BLLException, DALException {
		super(new PersonnelsTableModel());
	}

}
