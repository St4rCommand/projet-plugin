package org.nantes.univ.archi.platform.loader;

import org.nantes.univ.archi.platform.behaviour.IDescription;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 04/04/17.
 */
public class PluginLoader {

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
                PlatformLoader.pluginDescriptions) {

            className = pluginDescription.getProprietes().get("class");
            cl = Class.forName(className);

            if (constraint.isAssignableFrom(cl)) {
                list.add(pluginDescription);
            }
        }

        return list;
    }
}
