package fr.eni.clinique.bo;

import java.sql.Date;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;

public class AppliTestBO {

	public static void main(String[] args) throws DALException, BLLException {
		
		Personnels p = new Personnels("nomClient", "MotPasse", "vet", false);
		Clients c = new Clients("nomClient", "prenomClient" , "Adresse1", "Adresse2", "CP", "Ville", "NumTel", "Assurance", "Email", "Remarque", false);
		Animaux an = new Animaux("nomChien", "M", "Couleur", "Race", "Espece", 01245, "Tatouage", "Antecedents", false);
		Races r = new Races("Espece", "Race");
		Agendas a = new Agendas(0, new Date(118,05,23), 8877);
		
			System.out.println(p.toString());
			System.out.println(c.toString());
			System.out.println(a.toString());
			System.out.println(an.toString());
			System.out.println(r.toString());

	}
}
