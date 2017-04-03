package org.nantes.univ.archi.platform;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by romain on 07/03/17.
 */
public class Loader {

    private static List<IDescription> pluginsDescription = new ArrayList<>();

    public static void main(String[] args) {
        loadConfig();
        lauchAutoRunPlugins();
    }

    /**
     * Start autorun plugins
     */
    private static void lauchAutoRunPlugins() {
        for (IDescription plugin : pluginsDescription) {

            if (isAutoRunPlugin(plugin)) {

                // TODO charger ses dépendances

                Plugin o = (Plugin) loadPlugin(plugin);
                o.start();
            }
        }
    }

    private static boolean isAutoRunPlugin(IDescription plugin) {

        // TODO vérifier si le plugin doit être lancé au démarrage

        return true;
    }

    /**
     * Load the main plugin class
     *
     * @param description
     * @return
     */
    public static Object loadPlugin(IDescription description) {
        Class<?> cl = null;

        try {
            cl = Class.forName(description.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        Object ob = null;
        try {
            ob = cl.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

        return ob;
    }

    /**
     * Load application config
     */
    private static void loadConfig() {
        Map<String, Map> pluginConfigs = loadConfigFile();

        for (Map.Entry<String, Map> pluginConfig : pluginConfigs.entrySet()) {
            pluginsDescription.add(loadPluginConfig(pluginConfig.getValue()));
        }
    }

    /**
     * Load a specific pluginsDescription config
     *
     * @param pluginConfig
     * @return
     */
    private static IDescription loadPluginConfig(Map pluginConfig) {

        // TODO vérifier que la class principale implémente une fonction start (mettre en place une interface)

        return new Description((String) pluginConfig.get("class"), pluginConfig);
    }

    /**
     * Load main config file
     *
     * @return
     */
    private static Map<String, Map> loadConfigFile() {
        Map<String, Map> map = new HashMap<>();

        try {
            InputStream input = new FileInputStream(new File("./ressources/config.yml"));
            Yaml yaml = new Yaml();
            map = (Map<String, Map>) yaml.load(input);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return map;
    }
}
