package fr.eni.clinique.ihm.gestionClient;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.AnimauxManager;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.dal.DALException;

public class ClientsTableModel extends AbstractTableModel{
	
	private List<Animaux> listeAnimaux;
	
	public ClientsTableModel() throws BLLException, DALException{
		this.listeAnimaux = AnimauxManager.getInstance().getListeAnimauxByClient();
	}
	
	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return this.listeAnimaux.size();
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
