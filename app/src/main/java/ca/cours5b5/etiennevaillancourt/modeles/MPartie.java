package ca.cours5b5.etiennevaillancourt.modeles;

import java.util.Map;

import ca.cours5b5.etiennevaillancourt.serialisation.AttributSerialisable;

public class MPartie extends Modele {


    @AttributSerialisable
    public MParametresPartie parametres = new MParametresPartie();
    private final String __parametres= "parametres";

    public MPartie(MParametresPartie parametres){
    this.parametres = getParametres();
    }

    public MParametresPartie getParametres(){
        return parametres;
    }
    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {

    }

    @Override
    public Map<String, Object> enObjetJson() {
        return null;
    }
}
