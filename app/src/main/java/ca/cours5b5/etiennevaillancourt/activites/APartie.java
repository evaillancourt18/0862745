package ca.cours5b5.etiennevaillancourt.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.etiennevaillancourt.R;
import ca.cours5b5.etiennevaillancourt.controleurs.ControleurAction;
import ca.cours5b5.etiennevaillancourt.controleurs.ControleurObservation;
import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.Fournisseur;
import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.etiennevaillancourt.global.GCommande;
import ca.cours5b5.etiennevaillancourt.modeles.MPartie;
import ca.cours5b5.etiennevaillancourt.serialisation.Jsonification;

public class APartie extends Activite implements Fournisseur {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Atelier04", AMenuPrincipal.class.getSimpleName() + "::onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie);

        if(savedInstanceState!=null){
            String json = savedInstanceState .getString(MPartie.class.getSimpleName());
            Map<String, Object> objetJson = Jsonification.enObjetJson(json);
            ControleurObservation.partie.aPartirObjetJson(objetJson);
        }

    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        Map<String, Object> objetJson = ControleurObservation.partie.enObjetJson();
        String json = Jsonification.enChaine(objetJson);

        outState.putString("MPartie", json);
        Log.d("Atelier08", json);

    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
    }



}
