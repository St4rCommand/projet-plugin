package org.nantes.univ.archi.platform;

import org.nantes.univ.archi.platform.behaviour.IDescription;

import javax.swing.*;
import java.util.List;

/**
 * Created on 26/04/17.
 */
public class Moniteur extends JFrame{

    private DescriptionTableModel pluginTableModel = new DescriptionTableModel();
    private JPanel pluginMoniteur = new JPanel();
    private JTable pluginTable = new JTable(pluginTableModel);

    public Moniteur(){

        this.setTitle("Moniteur");
        this.setSize(400, 500);
        pluginTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createUIComponents();
        this.setVisible(true);
//        pack();
    }

    private void createUIComponents() {
        pluginMoniteur.add(pluginTable);
        setContentPane(pluginMoniteur);
    }

    public void updatePluginsData(List<IDescription> descriptions) {
        this.pluginTableModel.updateDescription(descriptions);
    }
}
