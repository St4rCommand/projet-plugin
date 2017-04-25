package org.nantes.univ.archi.test.afficheurconsole;

import org.nantes.univ.archi.test.TestAfficheur;

/**
 * Created on 04/04/17.
 */
public class AfficheurConsole implements TestAfficheur {

    @Override
    public void afficher(String message) {
        System.out.println(message);
    }
}
