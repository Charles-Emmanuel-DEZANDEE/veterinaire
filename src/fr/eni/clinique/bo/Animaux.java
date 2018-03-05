package fr.eni.clinique.bo;

public class Animaux {
	
	private int CodeAnimal;
	private String NomAnimal;
	private String Sexe;
	private String Couleur;
	private String Race;
	private String Espece;
	private long CodeClient;
	private String Tatouage;
	private String Antecedents;
	private boolean Archive;
	
	public Animaux(){
		
	}
	
	public Animaux(int CodeAnimal, String NomAnimal, String Sexe, String Couleur, String Race,
			String Espece, int CodeClient, String Tatouage, String Antecedents, boolean Archive){
		this.CodeAnimal = CodeAnimal;
		this.NomAnimal = NomAnimal;
		this.Sexe = Sexe;
		this.Couleur = Couleur;
		this.Race = Race;
		this.Espece = Espece;
		this.CodeClient = CodeClient;
		this.Tatouage = Tatouage;
		this.Antecedents = Antecedents;
		this.Archive = Archive;
	}
	
	public Animaux(String NomAnimal, String Sexe, String Couleur, String Race,
			String Espece, int CodeClient, String Tatouage, String Antecedents, boolean Archive){
		this.NomAnimal = NomAnimal;
		this.Sexe = Sexe;
		this.Couleur = Couleur;
		this.Race = Race;
		this.Espece = Espece;
		this.CodeClient = CodeClient;
		this.Tatouage = Tatouage;
		this.Antecedents = Antecedents;
		this.Archive = Archive;
	}

	public int getCodeAnimal() {
		return CodeAnimal;
	}

	public void setCodeAnimal(int codeAnimal) {
		CodeAnimal = codeAnimal;
	}

	public String getNomAnimal() {
		return NomAnimal;
	}

	public void setNomAnimal(String nomAnimal) {
		NomAnimal = nomAnimal;
	}

	public String getSexe() {
		return Sexe;
	}

	public void setSexe(String sexe) {
		Sexe = sexe;
	}

	public String getCouleur() {
		return Couleur;
	}

	public void setCouleur(String couleur) {
		Couleur = couleur;
	}

	public String getRace() {
		return Race;
	}

	public void setRace(String race) {
		Race = race;
	}

	public String getEspece() {
		return Espece;
	}

	public void setEspece(String espece) {
		Espece = espece;
	}

	public Long getCodeClient() {
		return CodeClient;
	}

	public void setCodeClient(int codeClient) {
		CodeClient = codeClient;
	}

	public String getTatouage() {
		return Tatouage;
	}

	public void setTatouage(String tatouage) {
		Tatouage = tatouage;
	}

	public String getAntecedents() {
		return Antecedents;
	}

	public void setAntecedents(String antecedents) {
		Antecedents = antecedents;
	}

	public boolean isArchive() {
		return Archive;
	}

	public void setArchive(boolean archive) {
		Archive = archive;
	}
	
	public String toString(){
		return this.CodeAnimal + ' ' + this.NomAnimal + ' ' + this.Sexe + ' ' + 
				this.Couleur + ' ' + this.Race + ' ' + this.Espece + ' ' + this.CodeClient + ' ' +
				this.Tatouage + ' ' + this.Antecedents + ' ' + this.Archive;
	}

}
