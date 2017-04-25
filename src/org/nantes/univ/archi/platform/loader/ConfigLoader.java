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

    private static ConfigLoader uniqueConfigLoaderInstance = null;

    private ConfigLoader() {
    }

    public static ConfigLoader getInstance() {
        if (null == uniqueConfigLoaderInstance) {
            uniqueConfigLoaderInstance = new ConfigLoader();
        }

        return uniqueConfigLoaderInstance;
    }

    /**
     * Load application config
     */
    public void loadConfig() {
        Map<String, Map> pluginConfigs = loadConfigFile();
        PlatformLoader platformLoader = PlatformLoader.getInstance();

        for (Map.Entry<String, Map> pluginConfig : pluginConfigs.entrySet()) {
            platformLoader.addPluginDescriptions(loadPluginConfig(pluginConfig.getValue()));
        }
    }

    /**
     * Load a specific pluginDescriptions config
     *
     * @param pluginConfig
     * @return IDescription
     */
    private IDescription loadPluginConfig(Map pluginConfig) {

        // TODO vérifier que le plugin a bien le paramètre class

        return new Description((String) pluginConfig.get("class"), pluginConfig);
    }

    /**
     * Load main config file
     *
     * @return Map<String, Map>
     */
    private Map<String, Map> loadConfigFile() {
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
