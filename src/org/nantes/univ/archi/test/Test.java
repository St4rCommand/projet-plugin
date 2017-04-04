package org.nantes.univ.archi.test;

import org.nantes.univ.archi.platform.IDescription;
import org.nantes.univ.archi.platform.Loader;
import org.nantes.univ.archi.platform.Plugin;

import java.util.List;

/**
 * Created on 04/04/17.
 */
public class Test implements Plugin {

    @Override
    public void start() throws Exception {

        List<IDescription> afficheurPluginList = Loader.getPluginsDescription(TestAfficheur.class);

        if (afficheurPluginList.size() == 0) {
            throw new Exception("aucun afficheur n'est disponible");
        }

        TestAfficheur afficheur = (TestAfficheur) Loader.loadPlugin(afficheurPluginList.get(0));

        afficheur.afficher("Les modules sont correctements chargés");
    }
}
