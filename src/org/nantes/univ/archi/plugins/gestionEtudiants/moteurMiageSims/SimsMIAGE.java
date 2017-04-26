package org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims;

import java.util.List;

import org.nantes.univ.archi.plugins.gestionEtudiants.stubMiageSims.StubInterface;
import org.nantes.univ.archi.platform.behaviour.IDescription;
import org.nantes.univ.archi.platform.behaviour.Plugin;
import org.nantes.univ.archi.platform.loader.PluginLoader;

/**
 * Created by romain on 04/04/17.
 */
public class SimsMIAGE implements Plugin {
	
    @Override
    public void start() throws Exception {

		List<IDescription> stubPluginList = PluginLoader.getPluginsDescription(StubInterface.class);

		if (stubPluginList.size() == 0) {
			throw new Exception("aucun afficheur n'est disponible");
		}

		StubInterface stub = (StubInterface) PluginLoader.loadPlugin(stubPluginList.get(0));
		stub.init();


		List<IDescription> interfacePluginList = PluginLoader.getPluginsDescription(SimsMiageInterface.class);

		if (interfacePluginList.size() == 0) {
			throw new Exception("aucun afficheur n'est disponible");
		}

		SimsMiageInterface afficheur = (SimsMiageInterface) PluginLoader.loadPlugin(interfacePluginList.get(0));
		afficheur.init(stub);

    }
}
