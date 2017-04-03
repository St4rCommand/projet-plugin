package org.nantes.univ.archi.appli;

import org.nantes.univ.archi.platform.IDescription;
import org.nantes.univ.archi.platform.Loader;
import org.nantes.univ.archi.plugin.Personne;

/**
 * Created by romain on 07/03/17.
 */
public class ArchiPlugin {

    public static void main(String[] args) throws Exception {
        IDescription personneDescription = Loader.getDescriptionForPlugin(Personne.class);
        Personne personne = (Personne) Loader.getPluginForDescription(personneDescription);
        System.out.println(personne);
    }
}
