package fr.eni.clinique.ihm.vet;

import fr.eni.clinique.bll.BLLException;

import javax.swing.*;

public class VetoTable extends JTable{
	
	private VetoTableModel model;
	
	public VetoTable() throws BLLException{
		model = new VetoTableModel();
		setModel(model);
	}

	public VetoTableModel getPersonnelsModel() {
		return model;
	}
	

}
