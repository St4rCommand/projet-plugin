package org.nantes.univ.archi.platform.loader;

import org.nantes.univ.archi.platform.behaviour.IDescription;
import org.nantes.univ.archi.platform.handler.LogHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
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
     * @return Object
     */
    public static Object loadPlugin(IDescription description) {
        Class<?> cl;

        try {
            cl = Class.forName(description.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        Object ob;
        try {
            ob = cl.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

        return getProxyFor(ob);
    }



    /**
     * Get plugin list
     *
     * @param constraint
     * @return List<IDescription>
     * @throws ClassNotFoundException
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

    /**
     *
     * @param o
     * @return Object
     */
    protected static Object getProxyFor(Object o) {
        InvocationHandler ih = new LogHandler(o);

        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), ih);
    }
}
