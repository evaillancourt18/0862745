package ca.cours5b5.etiennevaillancourt.activites;

import android.os.Bundle;

import ca.cours5b5.etiennevaillancourt.R;
import ca.cours5b5.etiennevaillancourt.controleurs.ControleurPartieReseau;
import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.Fournisseur;

public class APartieReseau extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie_reseau);
    }

    @Override
    protected void onPause(){
        super.onPause();
        ControleurPartieReseau.getInstance().detruireSauvegardeServeur();
        ControleurPartieReseau.getInstance().deconnecterDuServeur();
    }

    @Override
    protected void onResume(){
        super.onResume();
        ControleurPartieReseau.getInstance().connecterAuServeur();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
