package org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims;

import java.util.List;
import java.util.Map;

public class Etudiant {
	
	private int id;
	private String nom;
	private String prenom;
	private int dateNaissance;
	private Map<String, List<Jauge>> jauges;
	
	public Etudiant(int id, String nom, String prenom, int dateNaissance, Map<String, List<Jauge>> jauges) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.jauges = jauges;
	}

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
	
	public int getDateNaissance() {
		return dateNaissance;
	}
	
	public void setDateNaissance(int dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public Map<String, List<Jauge>> getJauges() {
		return jauges;
	}
	
	public void setJauges(Map<String, List<Jauge>> jauges) {
		this.jauges = jauges;
	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", jauges=" + jauges + "]";
	}
	
}
