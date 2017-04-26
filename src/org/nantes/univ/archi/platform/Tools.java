package org.nantes.univ.archi.platform;

import org.nantes.univ.archi.platform.behaviour.IDescription;
import org.nantes.univ.archi.platform.behaviour.Plugin;
import org.nantes.univ.archi.platform.model.DescriptionStatus;

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

    public static String getStatusMessage(int status) {
        switch (status) {
            case DescriptionStatus.FOUND:
                return "trouvé";
            case DescriptionStatus.LOADED:
                return "chargé";
            case DescriptionStatus.NOT_FOUND:
                return "non-trouvé";
            default:
                return "PAS DE MESSAGE";
        }
    }
}
