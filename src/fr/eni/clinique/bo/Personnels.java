package fr.eni.clinique.bo;

public class Personnels {
	
	private Long CodePers;
	private String Nom;
	private String MotPasse;
	private String Role;
	private boolean Archive;
	
	public Personnels(){
		
	}
	
	public Personnels(Long CodePers, String Nom, String MotPasse, String Role, boolean Archive){
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

	public Long getCodePers() {
		return CodePers;
	}

	public void setCodePers(Long codePers) {
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
		return this.Nom;
	}

}
