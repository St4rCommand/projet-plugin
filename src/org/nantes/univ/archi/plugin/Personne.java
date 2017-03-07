package org.nantes.univ.archi.plugin;

/**
 * Created by romain on 07/03/17.
 */
public class Personne {
    protected String nom;
    protected String ville;
    protected int age;

    public Personne() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return this.nom + " ("+this.age+" ans) habite à " + this.ville;
    }

}