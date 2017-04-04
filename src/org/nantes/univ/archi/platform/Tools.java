package org.nantes.univ.archi.platform;

import org.nantes.univ.archi.platform.behaviour.IDescription;
import org.nantes.univ.archi.platform.behaviour.Plugin;

/**
 * Created on 04/04/17.
 */
public class Tools {

    /**
     * Check if plugin is autorun
     *
     * @param plugin
     * @return
     */
    public static boolean isAutoRunPlugin(IDescription plugin) {

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
    public static boolean isAutoRunClass(Class<?> cl) {

        return Plugin.class.isAssignableFrom(cl);
    }
}
