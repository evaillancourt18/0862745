package ca.cours5b5.etiennevaillancourt.modeles;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.etiennevaillancourt.global.GConstantes;
import ca.cours5b5.etiennevaillancourt.serialisation.AttributSerialisable;

public class MParametresPartie extends Modele {

    @AttributSerialisable
    public Integer hauteur;
    protected final String __hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    protected final String __largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    protected final String __pourGagner = "pourGagner";

    public static MParametresPartie aPartirMParametres(MParametres mParametres){
        MParametresPartie mParametresPartie;

        mParametresPartie = mParametres.getParametresPartie().cloner();

        return mParametresPartie;

    }

    public MParametresPartie cloner(){

            MParametresPartie mParametresPartie = new MParametresPartie();

                mParametresPartie.setHauteur(this.getHauteur());
                mParametresPartie.setLargeur(this.getLargeur());
                mParametresPartie.setPourGagner(this.getPourGagner());


            return mParametresPartie;


    }

    public MParametresPartie(){
        this.hauteur = GConstantes.DEFAUTHAUTEUR;
        this.largeur = GConstantes.DEFAUTLARGEUR;
        this.pourGagner = GConstantes.DEFAUTGAGNER;
    }

    public Integer getHauteur() {
        return hauteur;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public Integer getPourGagner() {
        return pourGagner;
    }

    public void setHauteur(Integer hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(Integer largeur){
        this.largeur = largeur;
    }

    public void setPourGagner(Integer pourGagner) {
        this.pourGagner = pourGagner;
    }


    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {

        for(Map.Entry entry : objetJson.entrySet()){
            if(entry.getKey().equals("hauteur")){
                hauteur = Integer.valueOf((String)entry.getValue());
            }else if(entry.getKey().equals("largeur")){
                largeur = Integer.valueOf((String)entry.getValue());
            }else if(entry.getKey().equals("pourGagner")){
                pourGagner=Integer.valueOf((String)entry.getValue());
            }
        }
    }

    @Override
    public Map<String, Object> enObjetJson() {
        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put("hauteur",hauteur.toString());
        objetJson.put("largeur",largeur.toString());
        objetJson.put("pourGagner",pourGagner.toString());
        return objetJson;
    }
}
