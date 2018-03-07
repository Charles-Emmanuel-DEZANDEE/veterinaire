package fr.eni.clinique.dto;

import java.util.Date;

public class RDV {
	
	private long CodeVeto;
	private Date DateRdv;
	private int CodeAnimal;
	private String nomClient;
	private String nomAnimal;
	private String race;
	
	public RDV(long CodeVeto, Date DateRdv, int CodeAnimal,
			String nomClient, String nomAnimal,String race  ){
		this.CodeVeto = CodeVeto;
		this.DateRdv = DateRdv;
		this.CodeAnimal = CodeAnimal;
		this.nomClient = nomClient;
		this.nomAnimal = nomAnimal;
		this.race = race;
	}

	
	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getNomAnimal() {
		return nomAnimal;
	}

	public void setNomAnimal(String nomAnimal) {
		this.nomAnimal = nomAnimal;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public RDV(){
		
	}
	
	public long getCodeVeto() {
		return CodeVeto;
	}

	public void setCodeVeto(long codeVeto) {
		CodeVeto = codeVeto;
	}

	public Date getDateRdv() {
		return DateRdv;
	}

	public void setDateRdv(Date dateRdv) {
		DateRdv = dateRdv;
	}

	public int getCodeAnimal() {
		return CodeAnimal;
	}

	public void setCodeAnimal(int codeAnimal) {
		CodeAnimal = codeAnimal;
	}
	
	public String toString(){
		return this.DateRdv.toString()+ ' ' + 
				this.nomClient + ' ' + 
				this.nomAnimal+ ' ' + 
				this.race;
	}

}
