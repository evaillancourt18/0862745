package ca.cours5b5.etiennevaillancourt.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ca.cours5b5.etiennevaillancourt.controleurs.ControleurModeles;
import ca.cours5b5.etiennevaillancourt.donnees.Disque;
import ca.cours5b5.etiennevaillancourt.donnees.SauvegardeTemporaire;
import ca.cours5b5.etiennevaillancourt.donnees.Serveur;
import ca.cours5b5.etiennevaillancourt.modeles.MParametres;


public abstract class Activite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialiserControleurModeles(savedInstanceState);
        initialiserApplication();

    }

    protected void initialiserControleurModeles(Bundle savedInstanceState) {

        ControleurModeles.setSequenceDeChargement(
                new SauvegardeTemporaire(savedInstanceState),
                Serveur.getInstance(),
                Disque.getInstance());

        
    }

    protected void initialiserApplication(){

        Disque.getInstance().setRepertoireRacine(getFilesDir());

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        ControleurModeles.sauvegarderModeleDansCetteSource(MParametres.class.getSimpleName(),
                new SauvegardeTemporaire(outState));
    }

}
