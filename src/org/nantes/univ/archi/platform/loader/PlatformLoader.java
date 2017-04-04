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

    // TODO Gérer des dépendances requises
    // TODO Refactoring pour supprimer tous les statics (singleton sur la plateforme ?)

    // TODO passer en privé
    public static List<IDescription> pluginDescriptions = new ArrayList<>();


    // TODO mettre en place les status
    public static void main(String[] args) {
        ConfigLoader.loadConfig();
        lauchAutoRunPlugins();
    }

    /**
     * Start autorun plugins
     */
    private static void lauchAutoRunPlugins() {
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


}
