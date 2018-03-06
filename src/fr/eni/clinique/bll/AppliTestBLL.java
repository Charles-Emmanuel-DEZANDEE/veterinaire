package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dto.RDV;

public class AppliTestBLL {
	
	public static void main(String[] args) throws DALException, BLLException {
		Personnels p1 = new Personnels("nom1", "mdp1", "vet", false);
		List<RDV> listeRDV = AgendaManager.getInstance().getRDVByVetEtDate(75L, new java.util.Date() );
		
		for(RDV rdv : listeRDV){
			System.out.println(rdv.toString());
		}
	}
	
	
}
