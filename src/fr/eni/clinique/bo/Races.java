package fr.eni.clinique.bo;

public class Races {
	
	private String Race;
	private String Espece;
	
	public Races(String Race, String Espece){
		this.Espece = Espece;
		this.Race = Race;
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
	
	public String toString(){
		return this.Race + ' ' + this.Espece;
	}

}
