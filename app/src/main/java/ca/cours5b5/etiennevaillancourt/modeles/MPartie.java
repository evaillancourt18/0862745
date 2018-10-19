package ca.cours5b5.etiennevaillancourt.modeles;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.etiennevaillancourt.controleurs.ControleurAction;
import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.Fournisseur;
import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.etiennevaillancourt.exceptions.ErreurDeSerialisation;
import ca.cours5b5.etiennevaillancourt.global.GCommande;
import ca.cours5b5.etiennevaillancourt.global.GCouleur;
import ca.cours5b5.etiennevaillancourt.serialisation.AttributSerialisable;

public class MPartie extends Modele implements Fournisseur {


    @AttributSerialisable
    public MParametresPartie parametres;

    @AttributSerialisable
    public List<Integer> coups;

    private MGrille grille;
    private GCouleur couleurCourante;
    public static MPartie instance;

    public MPartie(MParametresPartie parametres){
        coups = new ArrayList<>();
        this.parametres = parametres;
        initialiserCouleurCourante();
        grille = new MGrille(this.parametres.getLargeur());
        fournirActionPlacerJeton();
    }

    private void initialiserCouleurCourante(){

        couleurCourante= GCouleur.ROUGE;
    }

    private void fournirActionPlacerJeton(){
        ControleurAction.fournirAction(this , GCommande.JOUER_COUP_ICI, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                jouerCoup((int) args[0]);
            }
        });
    }

    protected void jouerCoup(int colonne){
        Log.d("Atelier07","JouerCoup: " + colonne);
        grille.placerJeton(colonne,couleurCourante);
        coups.add(colonne);
        prochaineCouleurCourante();
    }

    private void prochaineCouleurCourante(){
        if(couleurCourante==GCouleur.JAUNE){
            couleurCourante=GCouleur.ROUGE;
        }else if(couleurCourante==GCouleur.ROUGE){
            couleurCourante=GCouleur.JAUNE;
        }

    }



    public MParametresPartie getParametres(){
        return parametres;
    }


    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {

        MParametresPartie parametresPartie = new MParametresPartie();

            if(objetJson.containsKey("parametres")){
                parametresPartie.aPartirObjetJson((Map<String, Object>) objetJson.get("parametres"));
            }else {
                throw new ErreurDeSerialisation( "Je devrais avoir les parametres.");
            }


        grille = new MGrille(parametresPartie.getLargeur());
        initialiserCouleurCourante();
        List<Integer> temp = new ArrayList<>();

            if(objetJson.containsKey("coups")){
                temp = listeCoupsAPartirJson((List<String>) objetJson.get("coups"));
            }else{
                throw new ErreurDeSerialisation( "Je devrais avoir les coups.");
            }

            rejouerLesCoups(temp);
            Log.d("aPartirObjetJson", "allo");

    }

    @Override
    public Map<String, Object> enObjetJson() {

        Map<String,Object> objetJson = new HashMap<>();

        objetJson.put("coups", listeCoupsEnObjetJson(coups));
        objetJson.put("parametres", parametres.enObjetJson());



    return objetJson;
    }


    private void rejouerLesCoups (List<Integer> coupsARejouer){
        coups.clear();
        for(int i=0; i<coupsARejouer.size();i++){
            jouerCoup(coupsARejouer.get(i));
        }
    }

    private List<Integer> listeCoupsAPartirJson(List<String> listeCoupsObjetJson){
        List<Integer> temp = new ArrayList<>();

        for (int i=0 ; i< listeCoupsObjetJson.size();i++){
            temp.add(Integer.parseInt(listeCoupsObjetJson.get(i)));
        }

        return temp;
    }

    private List<String> listeCoupsEnObjetJson(List<Integer> listeCoups){
        List<String> temp = new ArrayList<>();

        for(int i=0; i<listeCoups.size();i++){
            temp.add(listeCoups.get(i).toString());
        }

        return temp;
    }

    public MGrille getGrille() {
        return grille;
    }
}
