package fr.eni.clinique.dal;


import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.bo.Races;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class AppliTestDAL {

	public static void main(String[] args) throws DALException, BLLException {

		//D�claration et instanciation de la DAO
		Dao<Personnels> personnelsDAO = DAOFactory.getPersonnelsDAO();
		Dao<Animaux> animauxDAO = DAOFactory.getAnimauxDAO();
		Dao<Clients> clientsDAO = DAOFactory.getClientsDAO();
		Dao<Races> racesDAO = DAOFactory.getRacesDAO();

		
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
//			System.out.println("Personnel ajout� : " + p1.toString());
//			personnelsDAO.insert(p2);
//			System.out.println("Personnel ajout� : " + p2.toString());
//			personnelsDAO.insert(p3);
//			System.out.println("Personnel ajout� : " + p3.toString());
			
			System.out.println("Ajout de la liste des clients... ");
			clientsDAO.insert(c1);
			System.out.println("Client ajout� : " + c1.toString());
			clientsDAO.insert(c2);
			System.out.println("Client ajout� : " + c2.toString());
			clientsDAO.insert(c3);
			System.out.println("Client ajout� : " + c3.toString());

			Races r1 = new Races("labrador", "chien");
			Races r2 = new Races("tekel", "chien");
			Races r3 = new Races("caniche", "chien");
			Races r4 = new Races("persan", "chat");
			Races r5 = new Races("siamois", "chat");

//			racesDAO.insert(r1);
//			System.out.println("races ajout� : " + r1.toString());
//			racesDAO.insert(r2);
//			System.out.println("races ajout� : " + r2.toString());
//			racesDAO.insert(r3);
//			System.out.println("races ajout� : " + r3.toString());
//			racesDAO.insert(r4);
//			System.out.println("races ajout� : " + r4.toString());
//			racesDAO.insert(r5);
//			System.out.println("races ajout� : " + r5.toString());

			Animaux a1 = new Animaux("NomAnimal1", "M", "Noir", r1.getRace(), r1.getEspece(), c1.getCodeClient(), "Tatouage", "Antecedents", false);
			Animaux a2 = new Animaux("NomAnimal2", "M", "Noir", r2.getRace(), r2.getEspece(), c2.getCodeClient(), "Tatouage", "Antecedents", false);
			Animaux a3 = new Animaux("NomAnimal3", "M", "Noir", r4.getRace(), r4.getEspece(), c3.getCodeClient(), "Tatouage", "Antecedents", false);

			animauxDAO.insert(a1);
			System.out.println("animal ajout� : " + a1.toString());
			animauxDAO.insert(a2);
			System.out.println("animal ajout� : " + a2.toString());
			animauxDAO.insert(a3);
			System.out.println("animal ajout� : " + a3.toString());


//			System.out.println("Ajout de la liste des animaux... ");
//			animauxDAO.insert(a1);
//			System.out.println("Animal ajout� : " + a1.toString());
//			animauxDAO.insert(a2);
//			System.out.println("Animal ajout� : " + a2.toString());
//			animauxDAO.insert(a3);
//			System.out.println("Animal ajout� : " + a3.toString());
			
			//S�l�ction du personnel par id
			Personnels p = personnelsDAO.selectById(p2.getCodePers());
			System.out.println("\nSélection de Personnel par id  : " + p.toString() );
			
			//S�l�ction du personnel par nom
			Personnels p4 = ((PersonnelsDAOJdbcImpl)personnelsDAO).selectByNom(p2.getNom());
			System.out.println("\nSélection de Personnel par nom  : " + p4.toString() );

			//S�l�ction de tous les personnels
			List<Personnels> personnels = personnelsDAO.selectAll();
			System.out.println("\nSélection de tous les Personnels  : "  );
			afficherPersonnels(personnels);

			//Modification d'un personnel
			System.out.println("\nModification d'un Personnel  : " );
			System.out.println("Personnel avant modification : "  + p1.toString());
    		p1.setNom("chang�");
     		p1.setMotPasse("motPasse");
			personnelsDAO.update(p1);
			System.out.println("Personnel après modification  : " + p1.toString() );	
			
			//Suppression d'un personnel
			personnelsDAO.update(p1);
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
