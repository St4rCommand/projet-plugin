package org.nantes.univ.archi.platform.loader;

import org.nantes.univ.archi.platform.Tools;
import org.nantes.univ.archi.platform.behaviour.IDescription;
import org.nantes.univ.archi.platform.behaviour.Plugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by romain on 07/03/17.
 */
public class PlatformLoader {


    private static PlatformLoader uniquePlatformLoaderInstance = null;

    private PlatformLoader() {
    }

    public static PlatformLoader getInstance() {
        if (null == uniquePlatformLoaderInstance) {
            uniquePlatformLoaderInstance = new PlatformLoader();
        }

        return uniquePlatformLoaderInstance;
    }

    // TODO Gérer des dépendances requises

    protected List<IDescription> pluginDescriptions = new ArrayList<>();


    // TODO mettre en place les status
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
        PluginLoader pluginLoader = PluginLoader.getInstance();

        for (IDescription plugin : pluginDescriptions) {

            if (Tools.isAutoRunPlugin(plugin)) {

                Object o = pluginLoader.loadPlugin(plugin);

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


    public List<IDescription> getPluginDescription() {
        return this.pluginDescriptions;
    }

    public void addPluginDescriptions(IDescription iDescription) {
        this.pluginDescriptions.add(iDescription);
    }
}
