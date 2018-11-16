package ca.cours5b5.etiennevaillancourt.controleurs;

import ca.cours5b5.etiennevaillancourt.global.GCommande;
import ca.cours5b5.etiennevaillancourt.global.GCouleur;

public class ControleurPartie {

    private ControleurPartie(){}

    private static final ControleurPartie instance = new ControleurPartie();

    public static ControleurPartie getInstance(){
        return instance;
    }

    public void gagnerPartie(GCouleur couleurGagnante){

        Action actionGagner = ControleurAction.demanderAction(GCommande.AFFICHER_GAGNANT);
        actionGagner.setArguments(couleurGagnante);
        actionGagner.executerDesQuePossible();

    }
}
