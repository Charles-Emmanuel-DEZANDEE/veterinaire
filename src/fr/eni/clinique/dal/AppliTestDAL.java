package fr.eni.clinique.dal;


import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.Personnels;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class AppliTestDAL {

	public static void main(String[] args) throws DALException, BLLException {

		//Déclaration et instanciation de la DAO
		Dao<Personnels> personnelsDAO = DAOFactory.getPersonnelsDAO();
		Dao<Animaux> animauxDAO = DAOFactory.getAnimauxDAO();
		Dao<Clients> clientsDAO = DAOFactory.getClientsDAO();
		
		
		//Instanciation du jeu d'essai
		Personnels p1 = new Personnels("MAHMOUDI", "12345", "vet", false);
		Personnels p2 = new Personnels("KHADHAR", "54321", "sec", false);
		Personnels p3 = new Personnels("DEZANDEE", "78945", "adm", false);
		Clients c1 = new Clients("Client1", "PrenomClient", "Adresse1", "Adresse2", "CP", "Ville", "NumTel", "Assurance", "Email", "Remarque", false);
		Clients c2 = new Clients("Client2", "PrenomClient", "Adresse1", "Adresse2", "CP", "Ville", "NumTel", "Assurance", "Email", "Remarque", false);
		Clients c3 = new Clients("Client3", "PrenomClient", "Adresse1", "Adresse2", "CP", "Ville", "NumTel", "Assurance", "Email", "Remarque", false);
	
		try {

//			System.out.println("Ajout de la liste du personnel... ");
//			personnelsDAO.insert(p1);
//			System.out.println("Personnel ajouté : " + p1.toString());
//			personnelsDAO.insert(p2);
//			System.out.println("Personnel ajouté : " + p2.toString());
//			personnelsDAO.insert(p3);
//			System.out.println("Personnel ajouté : " + p3.toString());
			
			System.out.println("Ajout de la liste des clients... ");
			clientsDAO.insert(c1);
			System.out.println("Client ajouté : " + c1.toString());
			clientsDAO.insert(c2);
			System.out.println("Client ajouté : " + c2.toString());
			clientsDAO.insert(c3);
			System.out.println("Client ajouté : " + c3.toString());
			
			Animaux a1 = new Animaux("NomAnimal1", "M", "Noir", "Race", "Espece", c1.getCodeClient(), "Tatouage", "Antecedents", false);
			Animaux a2 = new Animaux("NomAnimal2", "M", "Noir", "Race", "Espece", c2.getCodeClient(), "Tatouage", "Antecedents", false);
			Animaux a3 = new Animaux("NomAnimal3", "M", "Noir", "Race", "Espece", c3.getCodeClient(), "Tatouage", "Antecedents", false);

//			System.out.println("Ajout de la liste des animaux... ");
//			animauxDAO.insert(a1);
//			System.out.println("Animal ajouté : " + a1.toString());
//			animauxDAO.insert(a2);
//			System.out.println("Animal ajouté : " + a2.toString());
//			animauxDAO.insert(a3);
//			System.out.println("Animal ajouté : " + a3.toString());
			
			//Séléction du personnel par id
			Personnels p = personnelsDAO.selectById(p2.getCodePers());
			System.out.println("\nSÃ©lection de Personnel par id  : " + p.toString() );
			
			//Séléction du personnel par nom
			Personnels p4 = ((PersonnelsDAOJdbcImpl)personnelsDAO).selectByNom(p2.getNom());
			System.out.println("\nSÃ©lection de Personnel par nom  : " + p4.toString() );

			//Séléction de tous les personnels
			List<Personnels> personnels = personnelsDAO.selectAll();
			System.out.println("\nSÃ©lection de tous les Personnels  : "  );
			afficherPersonnels(personnels);

			//Modification d'un personnel
			System.out.println("\nModification d'un Personnel  : " );
			System.out.println("Personnel avant modification : "  + p1.toString());
    		p1.setNom("changé");
     		p1.setMotPasse("motPasse");
			personnelsDAO.update(p1);
			System.out.println("Personnel aprÃ¨s modification  : " + p1.toString() );	
			
			//Suppression d'un personnel
			personnelsDAO.update(p1);
			System.out.println("\nSuppression de Personnel  : " + p1.toString());
			personnels = personnelsDAO.selectAll();
			System.out.println("Liste des Personnel aprÃ¨s suppression : "  );
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
