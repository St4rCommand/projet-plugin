package org.nantes.univ.archi.gestionEtudiants;

import java.util.Date;

public class Jauge {
	
	private String nom;
	private Double valeur;
	private Date date;
	
	public Jauge(String nom, Double valeur, Date date) {
		super();
		this.nom = nom;
		this.valeur = valeur;
		this.date = date;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Double getValeur() {
		return valeur;
	}
	
	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Jauge [nom=" + nom + ", valeur=" + valeur + ", date=" + date + "]";
	}
	
}
