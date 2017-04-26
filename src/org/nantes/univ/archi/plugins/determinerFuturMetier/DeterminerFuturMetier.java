package org.nantes.univ.archi.plugins.determinerFuturMetier;

import org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims.Etudiant;
import org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims.Jauge;
import org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims.PluginSimsMiageInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by denis on 26/04/2017.
 */
public class DeterminerFuturMetier implements PluginSimsMiageInterface {

    @Override
    public List<Jauge> calculer(Etudiant etudiant) {
        List<Jauge> res = new ArrayList<Jauge>();
        List<Jauge> notes = etudiant.getJauge("notes");
        Double com = 0.0;
        Double archi = 0.0;
        Double pdo = 0.0;
        Double urba = 0.0;
        Double ang = 0.0;

        for(Jauge j : notes) {
            if("Urbanisation des SI".equals(j.getNom())) {
                urba = j.getValeur();
            } else if("Anglais".equals(j.getNom())) {
                ang = j.getValeur();
            } else if("Architecture des SI".equals(j.getNom())) {
                archi = j.getValeur();
            } else if("Communication".equals(j.getNom())) {
                com = j.getValeur();
            } else if("Processus de développement objet".equals(j.getNom())) {
                pdo = j.getValeur();
            }
        }

        res.add(new Jauge("% Commercial", ((com + ang) / 40) * 100, new Date()));
        res.add(new Jauge("% Architecte", ((urba + archi) / 40) * 100, new Date()));
        res.add(new Jauge("% Directeur de projet", com + ang + urba + pdo + archi, new Date()));
        res.add(new Jauge("% Chef de projet", ((com + ang + pdo) / 60) * 100, new Date()));
        res.add(new Jauge("% Developpeur", (pdo / 20) * 100, new Date()));

        return res;
    }

}
