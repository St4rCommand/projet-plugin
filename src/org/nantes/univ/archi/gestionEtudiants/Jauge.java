package org.nantes.univ.archi.gestionEtudiants;

import java.util.Date;

public class Jauge {
	
	private String nom;
	private float valeur;
	private Date date;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getValeur() {
		return valeur;
	}
	public void setValeur(float valeur) {
		this.valeur = valeur;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
