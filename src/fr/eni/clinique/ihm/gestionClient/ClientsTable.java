package fr.eni.clinique.ihm.gestionClient;

import javax.swing.JTable;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

public class ClientsTable extends JTable{
	
	private ClientsTableModel model;
	
	public ClientsTable() throws BLLException, DALException{
		model = new ClientsTableModel();
		setModel(model);
	}

	public ClientsTableModel getClientsModel() {
		return model;
	}
	

}
