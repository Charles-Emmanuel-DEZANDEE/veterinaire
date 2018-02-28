package fr.eni.clinique.ihm.ecranPersonnel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;

public class PersonnelsTableModel extends AbstractTableModel{
	
	private List<Personnels> listePersonnel;
	
	public PersonnelsTableModel() throws BLLException, DALException{
		this.listePersonnel = PersonnelsManager.getInstance().getListePersonnel();
	}
	
	public List<Personnels> getListePersonnel() {
		return listePersonnel;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.listePersonnel.size();
	}

	@Override
	public Object getValueAt(int arg0, int col) {
		String motDePasse = "";
		if (col == 0){
			return listePersonnel.get(arg0).getNom();
		}
		if(col == 1){
			return listePersonnel.get(arg0).getRole();
		}
		if(col == 2){
			for(int i=0; i<listePersonnel.get(arg0).getMotPasse().length();i++){
				motDePasse += "*";
			}
			return motDePasse;
		}
		return null;
	}
	
}
