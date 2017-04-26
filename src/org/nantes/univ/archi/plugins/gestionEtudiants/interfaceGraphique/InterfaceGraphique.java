package org.nantes.univ.archi.plugins.gestionEtudiants.interfaceGraphique;

import org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims.Etudiant;
import org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims.Promotion;
import org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims.SimsMiageInterface;
import org.nantes.univ.archi.plugins.gestionEtudiants.stubMiageSims.StubInterface;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by denis on 26/04/2017.
 */
public class InterfaceGraphique extends JFrame implements SimsMiageInterface {

    private StubInterface stub;
    private List<String> promotions;
    private List<String> etudiants;
    private Promotion promo;
    private Etudiant selectedEtu;

    private JPanel rootPanel;
    private JComboBox listePromotions;
    private JList listeEtudiants;
    private JLabel idLabel;
    private JLabel nomLabel;
    private JLabel prenomLabel;
    private JLabel dateLabel;
    private JLabel idValue;
    private JLabel nomValue;
    private JLabel prenomValue;
    private JLabel dateValue;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panelEtu;
    private JPanel panelBtn;


    private void initPanel() {
        setContentPane(rootPanel);
        clearSelection();
        promotions = new ArrayList<String>();
        for (Promotion p : stub.getPromotions()) {
            promotions.add(p.getNom());
        }
        listePromotions.setModel(new DefaultComboBoxModel(promotions.toArray()));

        listePromotions.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearSelection();
                promo = stub.getPromotion(listePromotions.getSelectedItem().toString());
                etudiants = new ArrayList<String>();
                for(Etudiant etu : promo.getEtudiants()) {
                    etudiants.add(etu.getNom() + " " + etu.getPrenom());
                }
                listeEtudiants.setModel(new DefaultComboBoxModel(etudiants.toArray()));
            }
        });

        listeEtudiants.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    if(listeEtudiants.getSelectedValue() != null) {
                        idLabel.setVisible(true);
                        nomLabel.setVisible(true);
                        prenomLabel.setVisible(true);
                        dateLabel.setVisible(true);
                        idValue.setVisible(true);
                        nomValue.setVisible(true);
                        prenomValue.setVisible(true);
                        dateValue.setVisible(true);

                        String[] value = listeEtudiants.getSelectedValue().toString().split(" ");
                        selectedEtu = promo.getEtudiant(value[0]);
                        idValue.setText(Integer.toString(selectedEtu.getId()));
                        nomValue.setText(selectedEtu.getNom());
                        prenomValue.setText(selectedEtu.getPrenom());
                        dateValue.setText(Integer.toString(selectedEtu.getDateNaissance()));
                    }
                }
            }
        });

    }



    private void clearSelection() {
        listeEtudiants.clearSelection();
        idLabel.setVisible(false);
        nomLabel.setVisible(false);
        prenomLabel.setVisible(false);
        dateLabel.setVisible(false);
        idValue.setVisible(false);
        nomValue.setVisible(false);
        prenomValue.setVisible(false);
        dateValue.setVisible(false);
    }


    @Override
    public void init(StubInterface stub) {
        this.stub = stub;
        initPanel();

        setPreferredSize(new Dimension(800,400));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
