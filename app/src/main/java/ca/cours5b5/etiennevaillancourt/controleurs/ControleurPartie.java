package ca.cours5b5.etiennevaillancourt.controleurs;

import ca.cours5b5.etiennevaillancourt.global.GCouleur;

public class ControleurPartie {

    private ControleurPartie(){}

    private static final ControleurPartie instance = null;

    public static ControleurPartie getInstance(){
        return instance;
    }

    public void gagnerPartie(GCouleur couleurGagnante){

    }
}
