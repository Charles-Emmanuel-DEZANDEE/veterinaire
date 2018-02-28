package fr.eni.clinique.dal;


import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Personnels;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class AppliTestDAL {

	public static void main(String[] args) throws DALException, BLLException {

		//D�claration et instanciation de la DAO
		Dao<Personnels> personnelsDAO = DAOFactory.getPersonnelsDAO();
		Dao<Animaux> animauxDAO = DAOFactory.getAnimauxDAO();
		Dao<Clients> clientsDAO = DAOFactory.getClientsDAO();
		
		
		//Instanciation du jeu d'essai
		Personnels p1 = new Personnels("MAHMOUDI", "12345", "vet", false);
		Personnels p2 = new Personnels("KHADHAR", "54321", "sec", false);
		Personnels p3 = new Personnels("DEZANDEE", "78945", "adm", false);
			
		
		System.out.println("Ajout de la liste du personnel... ");
		//TODO...
		try {
			
			personnelsDAO.insert(p1);
			System.out.println("Personnel ajouté  : " + p1.toString() );
			personnelsDAO.insert(p2);
			System.out.println("Personnel ajouté  : " + p2.toString() );
			personnelsDAO.insert(p3);
			System.out.println("Personnel ajouté  : " + p3.toString() );
			

			//Sélection de l'article par id
			Personnels p = personnelsDAO.selectById(p2.getCodePers());
			System.out.println("\nSélection de Personnel par id  : " + p.toString() );
			
			//Sélection de l'article par nom
			Personnels p4 = ((PersonnelsDAOJdbcImpl)personnelsDAO).selectByNom(p2.getNom());
			System.out.println("\nSélection de Personnel par nom  : " + p4.toString() );

			//Sélection de tous les personnels
			List<Personnels> personnels = personnelsDAO.selectAll();
			System.out.println("\nSélection de tous les Personnels  : "  );
			afficherPersonnels(personnels);

			//Modification d'un personnel
			System.out.println("\nModification d'un Personnel  : " );
			System.out.println("Personnel avant modification : "  + p1.toString());
			p1.setNom("changé");
			p1.setMotPasse("motPasse");
			personnelsDAO.update(p1);
			System.out.println("Personnel après modification  : " + p1.toString() );
			
			
			//Suppression d'un personnel
			//personnelsDAO.update(p1);
			System.out.println("\nSuppression de Personnel  : " + p1.toString());
			personnels = personnelsDAO.selectAll();
			System.out.println("Liste des Personnel après suppression : "  );
			afficherPersonnels(personnels);
			System.out.println("---------------------------------------------------------------");

			
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		
	}

	
	private static void afficherPersonnels(List<Personnels> personnels){
		StringBuffer sb = new StringBuffer();
		for(Personnels art: personnels){
			sb.append(art.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
