package fr.eni.clinique.bo;

import java.util.Date;

public class Agendas {
	
	private long CodeVeto;
	private Date DateRdv;
	private int CodeAnimal;
	
	public Agendas(){
		
	}
	
	public Agendas(long CodeVeto, Date DateRdv, int CodeAnimal){
		this.CodeVeto = CodeVeto;
		this.DateRdv = DateRdv;
		this.CodeAnimal = CodeAnimal;
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
		return this.CodeVeto + ' ' + this.DateRdv.toString() + ' ' + this.CodeAnimal;
	}

}
