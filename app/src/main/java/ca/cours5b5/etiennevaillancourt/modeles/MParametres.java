package ca.cours5b5.etiennevaillancourt.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.etiennevaillancourt.global.GConstantes;
import ca.cours5b5.etiennevaillancourt.serialisation.AttributSerialisable;

public class MParametres extends Modele{

    public static MParametres instance;

    @AttributSerialisable
    public Integer hauteur;

    @AttributSerialisable
    public Integer largeur;

    @AttributSerialisable
    public Integer pourGagner;

    private List<Integer> choixHauteur;
    private List<Integer> choixLargeur;
    private List<Integer> choixPourGagner;

    public MParametres(){
        hauteur = GConstantes.DEFAUTHAUTEUR;
        largeur = GConstantes.DEFAUTLARGEUR;
        pourGagner = GConstantes.DEFAUTGAGNER;
        choixHauteur = new ArrayList<Integer>();
        choixLargeur = new ArrayList<Integer>();
        choixPourGagner = new ArrayList<Integer>();


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

    private void genererListesDeChoix(){
        choixHauteur = genererListeChoix(GConstantes.MINHAUTEUR,GConstantes.MAXHAUTEUR);
        choixLargeur = genererListeChoix(GConstantes.MINLARGEUR,GConstantes.MAXLARGEUR);
        choixPourGagner = genererListeChoix(GConstantes.MINGAGNER,GConstantes.MAXGAGNER);

    }

    private List<Integer> genererListeChoix(int min, int max){
        List<Integer> temp = new ArrayList<Integer>();
        for(int i = min;i<max;i++){
            temp.add(i);
        }
        return temp;
    }
}
