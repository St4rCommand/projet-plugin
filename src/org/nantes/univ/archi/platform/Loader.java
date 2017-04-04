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

    private static List<IDescription> pluginDescriptions = new ArrayList<>();


    // TODO mettre en place les status
    public static void main(String[] args) {
        loadConfig();
        lauchAutoRunPlugins();
    }

    /**
     * Start autorun plugins
     */
    private static void lauchAutoRunPlugins() {
        for (IDescription plugin : pluginDescriptions) {

            if (isAutoRunPlugin(plugin)) {

                Object o = loadPlugin(plugin);

                if (! isAutoRunClass(o.getClass())) {

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

    /**
     * Check if plugin is autorun
     *
     * @param plugin
     * @return
     */
    private static boolean isAutoRunPlugin(IDescription plugin) {

        if (! plugin.getProprietes().containsKey("autoRun")) {
            return false;
        }

        Object autoRun = plugin.getProprietes().get("autoRun");

        if (! (autoRun instanceof Boolean)) {
            // TODO throw exception
            return false;
        }

        return (Boolean) autoRun;
    }

    /**
     * Check if class is an autorun class (implement Plugin)
     *
     * @param cl
     * @return
     */
    private static boolean isAutoRunClass(Class<?> cl) {

        return Plugin.class.isAssignableFrom(cl);
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
            pluginDescriptions.add(loadPluginConfig(pluginConfig.getValue()));
        }
    }

    /**
     * Load a specific pluginDescriptions config
     *
     * @param pluginConfig
     * @return
     */
    private static IDescription loadPluginConfig(Map pluginConfig) {

        // TODO vérifier que le plugin a bien le paramètre class

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

    /**
     * Get plugin list
     *
     * @param constraint
     * @return
     * @throws Exception
     */
    public static List<IDescription> getPluginsDescription(Class<?> constraint) throws ClassNotFoundException {

        String className;
        Class<?> cl;
        List<IDescription> list = new ArrayList<>();

        for (IDescription pluginDescription :
                pluginDescriptions) {

            className = pluginDescription.getProprietes().get("class");
            cl = Class.forName(className);

            if (constraint.isAssignableFrom(cl)) {
                list.add(pluginDescription);
            }
        }

        return list;
    }
}
