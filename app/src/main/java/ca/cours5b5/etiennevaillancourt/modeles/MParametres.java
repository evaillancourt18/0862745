package ca.cours5b5.etiennevaillancourt.modeles;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.etiennevaillancourt.controleurs.ControleurAction;
import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.Fournisseur;
import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.etiennevaillancourt.exceptions.ErreurDeSerialisation;
import ca.cours5b5.etiennevaillancourt.global.GCommande;
import ca.cours5b5.etiennevaillancourt.global.GConstantes;
import ca.cours5b5.etiennevaillancourt.serialisation.AttributSerialisable;

import static java.lang.Math.max;

public class MParametres extends Modele implements Fournisseur{

    public static MParametres instance = new MParametres();

    @AttributSerialisable
    public MParametresPartie parametresPartie;
    private String __parametresPartie= "parametresPartie";




    private List<Integer> choixHauteur;
    private List<Integer> choixLargeur;
    private List<Integer> choixPourGagner;

    public MParametres(){
        parametresPartie = new MParametresPartie();
        choixHauteur = new ArrayList<Integer>();
        choixLargeur = new ArrayList<Integer>();
        choixPourGagner = new ArrayList<Integer>();
        genererListesDeChoix();
        ControleurAction.fournirAction(this, GCommande.CHOISIR_HAUTEUR, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                parametresPartie.setHauteur((int)args[0]);
                choixPourGagner = genererListeChoix(GConstantes.MINGAGNER, max(parametresPartie.getHauteur(),parametresPartie.getLargeur())*75/100);
            }
        });
        ControleurAction.fournirAction(this, GCommande.CHOISIR_LARGEUR, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                parametresPartie.setLargeur((int)args[0]);
                choixPourGagner = genererListeChoix(GConstantes.MINGAGNER, max(parametresPartie.getHauteur(),parametresPartie.getLargeur())*75/100);
            }
        });
        ControleurAction.fournirAction(this, GCommande.CHOISIR_POUR_GAGNER, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                parametresPartie.setPourGagner((int)args[0]);
            }
        });


    }


    public List<Integer> getChoixHauteur(){
    return choixHauteur;
    }

    public List<Integer> getChoixLargeur() {
        return choixLargeur;
    }

    public List<Integer> getChoixPourGagner() {
        return choixPourGagner;
    }

    public MParametresPartie getParametresPartie() {
        return parametresPartie;
    }



    private void genererListesDeChoix(){
        choixHauteur = genererListeChoix(GConstantes.MINHAUTEUR,GConstantes.MAXHAUTEUR);
        choixLargeur = genererListeChoix(GConstantes.MINLARGEUR,GConstantes.MAXLARGEUR);
        choixPourGagner = genererListeChoix(GConstantes.MINGAGNER, max(parametresPartie.getHauteur(),parametresPartie.getLargeur())*75/100);

    }

    private List<Integer> genererListeChoix(int min, int max){
        List<Integer> temp = new ArrayList<Integer>();
        for(int i = min;i<=max;i++){
            temp.add(i);
        }
        return temp;
    }






    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {
        for(Map.Entry entry : objetJson.entrySet()){
            if(entry.getKey().equals("hauteur")){
                parametresPartie.hauteur = Integer.valueOf((String)entry.getValue());
            }else if(entry.getKey().equals("largeur")){
                parametresPartie.largeur = Integer.valueOf((String)entry.getValue());
            }else if(entry.getKey().equals("pourGagner")){
                parametresPartie.pourGagner=Integer.valueOf((String)entry.getValue());
            }
        }
    }

    @Override
    public Map<String, Object> enObjetJson() {
        Map<String, Object> objetJson = new HashMap<>();

            objetJson.put("hauteur",parametresPartie.hauteur.toString());
            objetJson.put("largeur",parametresPartie.largeur.toString());
            objetJson.put("pourGagner",parametresPartie.pourGagner.toString());

        return objetJson;
}

}
