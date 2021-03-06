package org.nantes.univ.archi.platform.loader;

import org.nantes.univ.archi.platform.Moniteur;
import org.nantes.univ.archi.platform.Tools;
import org.nantes.univ.archi.platform.behaviour.IDescription;
import org.nantes.univ.archi.platform.behaviour.Observable;
import org.nantes.univ.archi.platform.behaviour.Observer;
import org.nantes.univ.archi.platform.behaviour.Plugin;
import org.nantes.univ.archi.platform.model.Description;
import org.nantes.univ.archi.platform.model.DescriptionStatus;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by romain on 07/03/17.
 */
public class PlatformLoader implements Observer {


    // TODO Gérer des dépendances requises
    protected List<IDescription> pluginDescriptions = new ArrayList<>();
    private static PlatformLoader uniquePlatformLoaderInstance = null;
    private Moniteur moniteur = new Moniteur();

    private PlatformLoader() {
        moniteur.setVisible(true);
    }

    static PlatformLoader getInstance() {
        if (null == uniquePlatformLoaderInstance) {
            uniquePlatformLoaderInstance = new PlatformLoader();
        }

        return uniquePlatformLoaderInstance;
    }


    public static void main(String[] args) {

        ConfigLoader configLoader = ConfigLoader.getInstance();
        configLoader.loadConfig();

        PlatformLoader platformLoader = PlatformLoader.getInstance();
        platformLoader.lauchAutoRunPlugins();
    }

    /**
     * Start autorun plugins
     */
    private void lauchAutoRunPlugins() {

        for (IDescription plugin : pluginDescriptions) {

            if (Tools.isAutoRunPlugin(plugin)) {

                Object o = PluginLoader.loadPlugin(plugin);

                if (! Tools.isAutoRunClass(o.getClass())) {

                    // TODO throw new exception
                    break;
                }

                Plugin autoRunPlugin = (Plugin) o;
                try {
                    autoRunPlugin.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    List<IDescription> getPluginDescription() {
        return this.pluginDescriptions;
    }

    void addPluginDescriptions(IDescription iDescription) {
        if (iDescription instanceof Description) {
            ((Description) iDescription).addObserver(this);
        }

        this.pluginDescriptions.add(iDescription);
    }

    @Override
    public void update(Observable observable) {

        if (observable instanceof IDescription) {
            IDescription plugin = (IDescription) observable;
            System.out.println("[PLATFORM]     -  Le plugin "+ plugin.getName()+ " est " + Tools.getStatusMessage(plugin.getStatus()));
            this.moniteur.updatePluginsData(pluginDescriptions);
        }
    }
}
