package org.nantes.univ.archi.plugins.testafficheur;

import org.nantes.univ.archi.plugins.test.TestAfficheur;

/**
 * Created on 04/04/17.
 */
public class AfficheurConsole implements TestAfficheur {

    @Override
    public void afficher(String message) {
        System.out.println(message);
    }
}
