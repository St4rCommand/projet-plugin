package org.nantes.univ.archi.plugin;

import org.nantes.univ.archi.appli.IAfficheur;

/**
 * Created by romain on 07/03/17.
 */
public class PersonneAfficheur implements IAfficheur<Personne> {

    @Override
    public void afficher(Personne personne) {
        System.out.println(personne);
    }
}
