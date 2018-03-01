package fr.eni.clinique.ihm.gestionClient;

import javax.swing.JTable;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.DALException;

public class ClientsTable extends JTable{
	
	public ClientsTable() throws BLLException, DALException {
		super(new ClientsTableModel());
	}
}