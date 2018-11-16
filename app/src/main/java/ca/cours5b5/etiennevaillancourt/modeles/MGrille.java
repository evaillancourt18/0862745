package ca.cours5b5.etiennevaillancourt.modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.cours5b5.etiennevaillancourt.exceptions.ErreurSerialisation;
import ca.cours5b5.etiennevaillancourt.global.GCouleur;
import ca.cours5b5.etiennevaillancourt.global.GDirection;


public class MGrille extends Modele  {

    private List<MColonne> colonnes;

    public MGrille(int largeur){

        colonnes = new ArrayList<>();

        initialiserColonnes(largeur);

    }

    private void initialiserColonnes(int largeur) {

        for(int i=0; i<largeur; i++){

            colonnes.add(new MColonne());

        }
    }


    public List<MColonne> getColonnes() {
        return colonnes;
    }


    public void placerJeton(int colonne, GCouleur couleur) {

        colonnes.get(colonne).placerJeton(couleur);

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

        throw new UnsupportedOperationException();

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {

        throw new UnsupportedOperationException();

    }


    public boolean siCouleurGagne(GCouleur couleur, int pourGagner){
        return false;
    }

    private boolean siCouleurGagneCetteColonne(GCouleur couleur, int idColonne, int pourGagner){
        return false;
    }

    private boolean siCouleurGagneCetteCase(GCouleur couleur, int idColonne, int idRangee, int pourGagner){
        return false;
    }

    private boolean siCouleurGagneDansCetteDirection(GCouleur couleur, int idColonne, int idRangee, GDirection direction, int pourGagner){
        return false;
    }

    private boolean siMemeCouleurCetteCase(GCouleur couleur, int idColonne, int idRangee){
        return false;
    }

}
