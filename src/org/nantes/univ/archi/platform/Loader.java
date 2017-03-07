package org.nantes.univ.archi.platform;

import org.nantes.univ.archi.appli.IAfficheur;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by romain on 07/03/17.
 */
public class Loader {

    public static Object loadPlugin(String configFileName, Class<?> returnedClass) throws Exception {
        Properties p = new Properties();
        p.load(new FileReader(configFileName));

        Class<?> cl = Class.forName((String) p.get("class"));

        if (!returnedClass.isAssignableFrom(cl)) {
            throw new Exception("La classe "+cl.getName()+" n'est pas du type "+returnedClass.getName());
        }

        Object ob = cl.newInstance();
        Method[] methods = cl.getMethods();

        for (Object property : p.keySet()) {
            String stringProperty = (String) property;

            if (!stringProperty.equals("class")) {

                // TODO Optimiser car double boucle ...
                for (Method currentMethod : methods) {

                    if (currentMethod.getName().equals("set"+stringProperty)) {

                        Class<?> setterTypeParameter = currentMethod.getParameterTypes()[0];

                        if (setterTypeParameter.equals(int.class)) {
                            currentMethod.invoke(ob, Integer.parseInt((String) p.get(stringProperty)));
                        } else if (setterTypeParameter.equals(String.class)) {
                            currentMethod.invoke(ob, p.get(stringProperty));
                        }
                    }

                }
            }
        }

        return ob;
    }
}
