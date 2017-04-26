package org.nantes.univ.archi.plugins.calculBonheur;

import org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims.Etudiant;
import org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims.Jauge;
import org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims.PluginSimsMiageInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by denis on 26/04/2017.
 */
public class CalculBonheur implements PluginSimsMiageInterface {

    @Override
    public List<Jauge> calculer(Etudiant etudiant) {
        List<Jauge> res = new ArrayList<Jauge>();
        List<Jauge> notes = etudiant.getJauge("notes");
        Double moyenne = 0.0;
        Double humeur;
        Boolean inf6 = false;
        Boolean sup15 = false;
        for(Jauge j : notes) {
            if(j.getValeur() < 6) {
                inf6 = true;
            } else if (j.getValeur() >= 15) {
                sup15 = true;
            }
            moyenne += j.getValeur();
        }
        moyenne /= notes.size();
        humeur = (moyenne / 20) * 50;
        if(!inf6) {
            humeur += 15;
        }
        if(sup15) {
            humeur += 35;
        }
        res.add(new Jauge("% Bonheur", humeur, new Date()));
        return res;
    }
}
