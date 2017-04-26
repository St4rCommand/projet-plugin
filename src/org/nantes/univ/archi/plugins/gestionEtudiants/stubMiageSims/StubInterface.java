package org.nantes.univ.archi.plugins.gestionEtudiants.stubMiageSims;

import org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims.Promotion;

import java.util.List;

/**
 * Created by denis on 26/04/2017.
 */
public interface StubInterface {

    void init();
    List <Promotion> getPromotions();
    Promotion getPromotion(String nom);

}
