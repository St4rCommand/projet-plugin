package org.nantes.univ.archi.platform;

import org.yaml.snakeyaml.Yaml;
import sun.security.krb5.internal.crypto.Des;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by romain on 07/03/17.
 */
public class Loader {

    // TODO return List<IDescription>
    public static IDescription getDescriptionForPlugin(Class<?> constraint) throws Exception {

        Properties p = new Properties();
        p.load(new FileReader("./ressources/personne.txt"));

        String className = (String) p.get("class");
        Class<?> cl = Class.forName(className);
        if (!constraint.isAssignableFrom(cl)) {
            throw new Exception("La classe "+cl.getName()+" n'est pas du type "+constraint.getName());
        }

        Map<String, String> proprietes = new TreeMap<>();
        for (Object property : p.keySet()) {
            String stringProperty = (String) property;

            if (!stringProperty.equals("class")) {
                proprietes.put(stringProperty, p.getProperty(stringProperty));
            }
        }

        Description description = new Description(className, proprietes);

        return description;
    }

    public static Object getPluginForDescription(IDescription description) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> cl = Class.forName(description.getName());

        Object ob = cl.newInstance();
        Method[] methods = cl.getMethods();

        Map<String, String> proprietes = description.getProprietes();

        for (Object property : proprietes.keySet()) {

            String stringProperty = (String) property;
            String setterName = "set"+stringProperty;

            for (Method method: methods) {

                if (method.getName().equals(setterName)) {
                    Class<?> setterTypeParameter = method.getParameterTypes()[0];

                    if (setterTypeParameter.equals(int.class)) {
                        method.invoke(ob, Integer.parseInt(proprietes.get(stringProperty)));
                    } else if (setterTypeParameter.equals(String.class)) {
                        method.invoke(ob, proprietes.get(stringProperty));
                    }
                }
            }
        }

        return ob;
    }
}
