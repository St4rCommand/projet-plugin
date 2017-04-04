package org.nantes.univ.archi.test;

import org.nantes.univ.archi.platform.behaviour.IDescription;
import org.nantes.univ.archi.platform.behaviour.Plugin;
import org.nantes.univ.archi.platform.loader.PluginLoader;

import java.util.List;

/**
 * Created on 04/04/17.
 */
public class Test implements Plugin {

    @Override
    public void start() throws Exception {

        List<IDescription> afficheurPluginList = PluginLoader.getPluginsDescription(TestAfficheur.class);

        if (afficheurPluginList.size() == 0) {
            throw new Exception("aucun afficheur n'est disponible");
        }

        TestAfficheur afficheur = (TestAfficheur) PluginLoader.loadPlugin(afficheurPluginList.get(0));

        afficheur.afficher("Les modules sont correctements chargés");
    }
}
