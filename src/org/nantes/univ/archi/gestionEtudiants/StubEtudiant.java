package org.nantes.univ.archi.gestionEtudiants;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class StubEtudiant {

    private List<Promotion> promotions;

    public StubEtudiant() {

        promotions = new ArrayList<Promotion>();
        int annee = 2012;
        Date date = new Date();
        Random random = new Random();

        for(int i=0; i < 5; i++) {

            List<Etudiant> etudiants = new ArrayList<Etudiant>();

            for(int j=0; j < 10; j++) {

                Map<String, List<Jauge>> jauges = new HashMap<String, List<Jauge>>();
                List<Jauge> amis = new ArrayList<Jauge>();
                List<Jauge> interets = new ArrayList<Jauge>();
                String id = String.valueOf(i) + String.valueOf(j);

                // jauge amis
                double r = random.nextDouble();
                amis.add(new Jauge("nom" + id, r, date));
                jauges.put("amis", amis);

                // jauge interets
                if((i % 2) == 0) {
                    r = random.nextDouble();
                    interets.add(new Jauge("Foot", r, date));
                    r = random.nextDouble();
                    interets.add(new Jauge("Cinema", r, date));
                }

                if((i % 2) == 1) {
                    r = random.nextDouble();
                    interets.add(new Jauge("Jeux vidéos", r, date));
                    r = random.nextDouble();
                    interets.add(new Jauge("Vélo", r, date));
                }

                if((j % 2) == 0) {
                    r = random.nextDouble();
                    interets.add(new Jauge("Voyages", r, date));
                    r = random.nextDouble();
                    interets.add(new Jauge("Basket", r, date));
                }

                if((j % 2) == 1) {
                    r = random.nextDouble();
                    interets.add(new Jauge("Films", r, date));
                    r = random.nextDouble();
                    interets.add(new Jauge("Tennis", r, date));
                }
                jauges.put("interets", interets);

                // jauge notes
                List<Jauge> notes = new ArrayList<Jauge>();
                r = random.nextDouble() * 20;
                notes.add(new Jauge("Communication", r, date));
                r = random.nextDouble() * 20;
                notes.add(new Jauge("Urbanisation des SI", r, date));
                r = random.nextDouble() * 20;
                notes.add(new Jauge("Anglais", r, date));
                r = random.nextDouble() * 20;
                notes.add(new Jauge("Architecture des SI", r, date));
                r = random.nextDouble() * 20;
                notes.add(new Jauge("Processus de développement objet", r, date));
                jauges.put("notes", notes);


                // etudiants
                Etudiant etu = new Etudiant(Integer.parseInt(id), "nom" + id, "prenom" + id, annee - 20, jauges);
                etudiants.add(etu);
            }


            // creation d'une nouvelle promotion
            Promotion p = new Promotion("promo" + (i + 1), annee, etudiants);

            // ajout a la liste des promotions
            this.promotions.add(p);
            annee++;
        }
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

}
