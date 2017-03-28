package org.nantes.univ.archi.gestionEtudiants;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Etudiant {
	
	private int id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private Map<String, List<Jauge>> jauges;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Map<String, List<Jauge>> getJauges() {
		return jauges;
	}
	public void setJauges(Map<String, List<Jauge>> jauges) {
		this.jauges = jauges;
	}
	
}
