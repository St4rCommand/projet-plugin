package org.nantes.univ.archi.appli;

import org.nantes.univ.archi.platform.Loader;
import org.nantes.univ.archi.plugin.Personne;

/**
 * Created by romain on 07/03/17.
 */
public class ArchiPlugin {

    public static void main(String[] args) throws Exception {
        Object ob = Loader.loadPlugin("./ressources/bean.txt", Personne.class);
        // TODO comment s'assurer que le type est bien personne ?
        IAfficheur<Personne> afficheur = (IAfficheur<Personne>) Loader.loadPlugin("./ressources/conf.txt", IAfficheur.class);

        if (! ob.getClass().equals(Personne.class)) {
            throw new Exception();
        }

        Personne personne = (Personne) ob;
        afficheur.afficher(personne);
    }
}
