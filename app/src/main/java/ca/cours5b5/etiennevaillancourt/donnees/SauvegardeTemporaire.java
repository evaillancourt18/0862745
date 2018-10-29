package ca.cours5b5.etiennevaillancourt.donnees;

import android.os.Bundle;
import android.util.Log;

import java.util.Map;


import ca.cours5b5.etiennevaillancourt.exceptions.ErreurModele;
import ca.cours5b5.etiennevaillancourt.serialisation.Jsonification;

public class SauvegardeTemporaire extends SourceDeDonnees {

    private Bundle bundle;

    public SauvegardeTemporaire(Bundle bundle){
        this.bundle = bundle;
    }


    @Override
    public void chargerModele(String cheminSauvegarde, ListenerChargement listenerChargement) {

        if(bundle != null && bundle.containsKey(cheminSauvegarde)){

            String json = bundle.getString(cheminSauvegarde);

            Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

            listenerChargement.reagirSucces(objetJson);

        }else{
            listenerChargement.reagirErreur(new ErreurModele("Clé inexistante"));

        }
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {

        Log.d("Atelier11", "sauvegarderModele: sauvegardeTemp ");
        if(bundle != null){

            String json = Jsonification.enChaineJson(objetJson);
            bundle.putString(cheminSauvegarde, json);

        }
    }

}