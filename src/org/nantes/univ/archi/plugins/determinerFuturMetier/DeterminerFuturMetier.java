package org.nantes.univ.archi.plugins.determinerFuturMetier;

import org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims.Etudiant;
import org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims.Jauge;
import org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims.PluginSimsMiageInterface;

import java.util.List;

/**
 * Created by denis on 26/04/2017.
 */
public class DeterminerFuturMetier implements PluginSimsMiageInterface {

    @Override
    public List<Jauge> calculer(Etudiant etudiant) {
        System.out.println("DeterminerFuturMetier");
        return null;
    }

}
