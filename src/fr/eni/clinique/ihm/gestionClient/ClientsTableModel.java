package fr.eni.clinique.ihm.gestionClient;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bo.Clients;


public class ClientsTableModel extends AbstractTableModel{
	
	private List<Clients> listeClients;
	
	public ClientsTableModel() throws BLLException, DALException{
		this.listeClients = ClientsManager.getInstance().getListeClients();
	}
	
	public List<Clients> getListeClient() {
		return listeClients;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return this.listeClients.size();
	}

	@Override
	public Object getValueAt(int arg0, int col) {
		if (col == 0){
			return listeClients.get(arg0).getClient();
		}
		if(col == 1){
			return listeClients.get(arg0).getPrenomClient();
		}
		if(col == 2){
			return listeClients.get(arg0).getCodePostal();
		}
		if(col == 3){
			return listeClients.get(arg0).getVille();
		}
		return null;
	}
	
}
