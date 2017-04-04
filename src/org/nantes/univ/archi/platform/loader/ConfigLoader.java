package org.nantes.univ.archi.platform.loader;

import org.nantes.univ.archi.platform.model.Description;
import org.nantes.univ.archi.platform.behaviour.IDescription;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 04/04/17.
 */
public class ConfigLoader {

    /**
     * Load application config
     */
    public static void loadConfig() {
        Map<String, Map> pluginConfigs = loadConfigFile();

        for (Map.Entry<String, Map> pluginConfig : pluginConfigs.entrySet()) {
            PlatformLoader.pluginDescriptions.add(loadPluginConfig(pluginConfig.getValue()));
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
}
