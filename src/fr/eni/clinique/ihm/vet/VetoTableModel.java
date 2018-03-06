package fr.eni.clinique.ihm.vet;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Agendas;
import fr.eni.clinique.bo.Personnels;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class VetoTableModel extends AbstractTableModel{
	
	private List<Agendas> listeRdv;
	
	public VetoTableModel() throws BLLException{
//		this.listeRdv = AgendaManager.getInstance().getListePersonnel();
	}
	
	public List<Agendas> getListeRDV() {
		return listeRdv;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.listeRdv.size();
	}

	@Override
	public Object getValueAt(int arg0, int col) {
		String motDePasse = "";
		if (col == 0){
			return listeRdv.get(arg0).getCodeVeto();
		}
		if(col == 1){
			return listeRdv.get(arg0).getCodeAnimal();
		}
		if(col == 2){
			return listeRdv.get(arg0).getDateRdv();
		}
		return null;
	}
	
}
