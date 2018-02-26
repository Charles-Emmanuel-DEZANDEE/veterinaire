package fr.eni.clinique.bo;

public class Personnels {
	
	private int CodePers;
	private String Nom;
	private String MotPasse;
	private String Role;
	private boolean Archive;
	
	public Personnels(){
		
	}
	
	public Personnels(int CodePers, String Nom, String MotPasse, String Role, boolean Archive){
		this.CodePers = CodePers;
		this.Nom = Nom;
		this.MotPasse = MotPasse;
		this.Role = Role;
		this.Archive = Archive;
	}
	
	public Personnels(String Nom, String MotPasse, String Role, boolean Archive){
		this.Nom = Nom;
		this.MotPasse = MotPasse;
		this.Role = Role;
		this.Archive = Archive;
	}

	public int getCodePers() {
		return CodePers;
	}

	public void setCodePers(int codePers) {
		CodePers = codePers;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getMotPasse() {
		return MotPasse;
	}

	public void setMotPasse(String motPasse) {
		MotPasse = motPasse;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public boolean isArchive() {
		return Archive;
	}

	public void setArchive(boolean archive) {
		Archive = archive;
	}
	
	public String toString(){
		return this.CodePers + ' ' + this.Nom + ' ' + this.MotPasse + ' ' + this.Role + ' ' + this.Archive;
	}

}
