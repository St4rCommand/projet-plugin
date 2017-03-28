package org.nantes.univ.archi.gestionEtudiants;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {
	
	public Window() {
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Gestion des étudiants");
		fenetre.setSize(800, 500);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);

		JComboBox combo = new JComboBox();
		combo.setPreferredSize(new Dimension(100, 20));
	    combo.addItem("2012-2013");
	    combo.addItem("2013-2014");
	    combo.addItem("2014-2015");
	    combo.addItem("2015-2016");
	    combo.addItem("2016-2017");
	    
		//Instanciation d'un objet JPanel
		JPanel pan = new JPanel();
		//On prévient notre JFrame que notre JPanel sera son content pane
		pan.add(combo);
		
		
		
		fenetre.setContentPane(pan);               
		fenetre.setVisible(true);
	}

}
