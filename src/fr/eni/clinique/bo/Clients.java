package fr.eni.clinique.bo;

import java.util.List;
import java.util.ArrayList;

public class Clients {
	
	private int CodeClient;
	private String Client;
	private String PrenomClient;
	private String Adresse1;
	private String Adresse2;
	private String CodePostal;
	private String Ville;
	private String NumTel;
	private String Assurance;
	private String Email;
	private String Remarque;
	private boolean Archive;
	private List<Animaux> listeAnimaux;


	public Clients(){
		this.listeAnimaux = new ArrayList<>();
	}
	
	public Clients(int CodeClient, String Client, String PrenomClient, String Adresse1,
			String Adresse2, String CodePostal, String Ville, String NumTel,
			String Assurance, String Email, String Remarque, boolean Archive){
		this.CodeClient = CodeClient;
		this.Client = Client;
		this.PrenomClient = PrenomClient;
		this.Adresse1 = Adresse1;
		this.Adresse2 = Adresse2;
		this.CodePostal = CodePostal;
		this.Ville = Ville;
		this.NumTel = NumTel;
		this.Assurance = Assurance;
		this.Email = Email;
		this.Remarque = Remarque;
		this.Archive = Archive;
	}
	
	public Clients(String Client, String PrenomClient, String Adresse1,
			String Adresse2, String CodePostal, String Ville, String NumTel,
			String Assurance, String Email, String Remarque, boolean Archive){
		this.Client = Client;
		this.PrenomClient = PrenomClient;
		this.Adresse1 = Adresse1;
		this.Adresse2 = Adresse2;
		this.CodePostal = CodePostal;
		this.Ville = Ville;
		this.NumTel = NumTel;
		this.Assurance = Assurance;
		this.Email = Email;
		this.Remarque = Remarque;
		this.Archive = Archive;
	}

	public int getCodeClient() {
		return CodeClient;
	}

	public void setCodeClient(int codeClient) {
		CodeClient = codeClient;
	}

	public String getClient() {
		return Client;
	}

	public void setClient(String client) {
		Client = client;
	}

	public String getPrenomClient() {
		return PrenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		PrenomClient = prenomClient;
	}

	public String getAdresse1() {
		return Adresse1;
	}

	public void setAdresse1(String adresse1) {
		Adresse1 = adresse1;
	}

	public String getAdresse2() {
		return Adresse2;
	}

	public void setAdresse2(String adresse2) {
		Adresse2 = adresse2;
	}

	public String getCodePostal() {
		return CodePostal;
	}

	public void setCodePostal(String codePostal) {
		CodePostal = codePostal;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getNumTel() {
		return NumTel;
	}

	public void setNumTel(String numTel) {
		NumTel = numTel;
	}

	public String getAssurance() {
		return Assurance;
	}

	public void setAssurance(String assurance) {
		Assurance = assurance;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getRemarque() {
		return Remarque;
	}

	public void setRemarque(String remarque) {
		Remarque = remarque;
	}

	public boolean isArchive() {
		return Archive;
	}

	public void setArchive(boolean archive) {
		Archive = archive;
	}

	public List<Animaux> getListeAnimaux() {
		return listeAnimaux;
	}

	public void setListeAnimaux(List<Animaux> listeAnimaux) {
		this.listeAnimaux = listeAnimaux;
	}


	public String toString(){
		return this.CodeClient + ' ' + this.Client + ' ' + this.PrenomClient + ' ' + 
				this.Adresse1 + ' ' + this.Adresse2 + ' ' + this.CodePostal + ' ' +
				this.Ville + ' ' + this.NumTel + ' ' + this.Assurance + ' ' +
				this.Assurance + ' ' + this.Email + ' ' + this.Remarque + ' ' +
				this.Archive;
	}
}
