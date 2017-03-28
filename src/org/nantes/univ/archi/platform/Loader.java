package org.nantes.univ.archi.platform;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by romain on 07/03/17.
 */
public class Loader {

	public static Object loadPlugin(String configFileName, Class<?> returnedClass) throws Exception { // à modifier


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


	public static void main(String[] args) {
		// parcourir le dossier où il y a le fichier de config

		// lancer les config en autorun

	}


}
