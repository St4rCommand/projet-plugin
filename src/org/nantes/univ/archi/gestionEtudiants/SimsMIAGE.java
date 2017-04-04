package org.nantes.univ.archi.gestionEtudiants;

import java.util.List;

import org.nantes.univ.archi.platform.behaviour.Plugin;

/**
 * Created by romain on 04/04/17.
 */
public class SimsMIAGE implements Plugin {
	
    @Override
    public void start() {
    	
    	System.out.println("Création du jeu de données...");
    	StubEtudiant stub = new StubEtudiant();
    	List<Promotion> promotions = stub.getPromotions();
    	System.out.println(promotions);
    	
    	System.out.println("Chargement du module simsmiage");
    }
}
