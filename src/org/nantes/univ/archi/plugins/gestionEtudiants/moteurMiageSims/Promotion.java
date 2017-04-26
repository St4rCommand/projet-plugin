package org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims;

import java.util.List;

public class Promotion {
	
	private String nom;
	private int annee;
	private List<Etudiant> etudiants;
	
	public Promotion(String nom, int annee, List<Etudiant> etudiants) {
		super();
		this.nom = nom;
		this.annee = annee;
		this.etudiants = etudiants;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getAnnee() {
		return annee;
	}
	
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public Etudiant getEtudiant(String nom) {
		Etudiant res = null;
		for(Etudiant etu : etudiants) {
			if(nom.equals(etu.getNom())) {
				res = etu;
			}
		}
		return res;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	@Override
	public String toString() {
		return "\nPromotion [nom=" + nom + ", annee=" + annee + ", etudiants=" + etudiants + "]";
	}
	
}
