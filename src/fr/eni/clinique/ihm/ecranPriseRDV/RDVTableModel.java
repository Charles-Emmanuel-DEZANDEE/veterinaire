package fr.eni.clinique.ihm.ecranPriseRDV;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.bll.AgendaManager;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dto.RDV;

import java.util.Calendar;
import java.util.Date;

public class RDVTableModel extends AbstractTableModel{
	
	private List<RDV> listeRDV;
	
	public RDVTableModel(long codeVet,Date dateRDV) throws BLLException{
		try {
			this.listeRDV = AgendaManager.getInstance().getRDVByVetEtDate(codeVet, dateRDV);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<RDV> getListePersonnel() {
		return listeRDV;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.listeRDV.size();
	}

	@Override
	public Object getValueAt(int arg0, int col) {
		if (col == 0){
			return listeRDV.get(arg0).getDateRdv().getDate();
		}
		if(col == 1){
			return listeRDV.get(arg0).getNomClient();
		}
		if(col == 1){
			return listeRDV.get(arg0).getNomAnimal();
		}
		if(col == 1){
			return listeRDV.get(arg0).getRace();
		}
		return null;
	}
	
}
