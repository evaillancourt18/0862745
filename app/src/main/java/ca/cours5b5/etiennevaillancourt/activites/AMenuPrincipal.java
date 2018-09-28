package ca.cours5b5.etiennevaillancourt.activites;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ca.cours5b5.etiennevaillancourt.R;
import ca.cours5b5.etiennevaillancourt.controleurs.Action;
import ca.cours5b5.etiennevaillancourt.controleurs.ControleurAction;
import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.Fournisseur;
import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.etiennevaillancourt.global.GCommande;
import ca.cours5b5.etiennevaillancourt.modeles.MParametres;
import ca.cours5b5.etiennevaillancourt.serialisation.Jsonification;
import ca.cours5b5.etiennevaillancourt.vues.VMenuPrincipal;

public class AMenuPrincipal extends Activite implements Fournisseur {

    static{
        Log.d("Atelier04", AMenuPrincipal.class.getSimpleName() + "::static");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Atelier04", AMenuPrincipal.class.getSimpleName() + "::onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);

        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_MENU_PARAMETRES,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        goToParametres();
                    }
                });

        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_MENU_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        goToPartie();
                    }
                });


    }

    @Override
    protected void onResume(){
        Log.d("Atelier04", AMenuPrincipal.class.getSimpleName() + "::onResume");
        super.onResume();
    }

    @Override
    protected void onPause(){
        Log.d("Atelier04", AMenuPrincipal.class.getSimpleName() + "::onPause");
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        Log.d("Atelier04", AMenuPrincipal.class.getSimpleName() + "::onSaveInstanceState");
        super.onSaveInstanceState(outState);

        outState.putInt("MaCle",18);
    }

    @Override
    protected void onDestroy(){
        Log.d("Atelier04", AMenuPrincipal.class.getSimpleName() + "::onDestroy");
        super.onDestroy();
    }

    public void goToParametres(){
        Intent monIntention = new Intent(this, AParametres.class);
        this.startActivity(monIntention);
    }

    public void goToPartie(){
        Intent monIntention = new Intent(this, APartie.class);
        this.startActivity(monIntention);
    }
}
