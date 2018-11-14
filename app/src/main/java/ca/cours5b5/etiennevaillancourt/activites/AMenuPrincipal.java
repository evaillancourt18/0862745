package ca.cours5b5.etiennevaillancourt.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.firebase.ui.auth.AuthUI;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.etiennevaillancourt.R;
import ca.cours5b5.etiennevaillancourt.controleurs.ControleurAction;
import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.Fournisseur;
import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.etiennevaillancourt.global.GCommande;
import ca.cours5b5.etiennevaillancourt.global.GConstantes;
import ca.cours5b5.etiennevaillancourt.modeles.MPartieReseau;


public class AMenuPrincipal extends Activite implements Fournisseur {

    private static List<AuthUI.IdpConfig> fournisseursDeConnexion = new ArrayList<>();

    static{

        fournisseursDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        fournirActions();

    }

    private void fournirActions() {

        fournirActionOuvrirMenuParametres();

        fournirActionDemarrerPartie();

        fournirActionConnexion();

        fournirActionJoindreOuCreerPartieReseau();
    }

    private void fournirActionOuvrirMenuParametres() {

        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_MENU_PARAMETRES,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionParametres();

                    }
                });
    }

    private void fournirActionDemarrerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.DEMARRER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionPartie();

                    }
                });
    }

    private void fournirActionConnexion() {

        ControleurAction.fournirAction(this,
                GCommande.CONNEXION,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        effectuerConnexion();

                    }
                });
    }

    private void fournirActionJoindreOuCreerPartieReseau() {

        ControleurAction.fournirAction(this,
                GCommande.JOINDRE_OU_CREER_PARTIE_RESEAU,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionPartieReseau();

                    }
                });
    }

    private void transitionParametres(){

        Intent intentionParametres = new Intent(this, AParametres.class);
        startActivity(intentionParametres);

    }

    private void transitionPartie(){

        Intent intentionPartie = new Intent(this, APartie.class);
        startActivity(intentionPartie);

    }

    private void transitionPartieReseau(){

        Intent intentionPartieReseau = new Intent(this, APartieReseau.class);
        intentionPartieReseau.putExtra(MPartieReseau.class.getSimpleName(), GConstantes.FIXME_JSON_PARTIE_RESEAU);
        startActivity(intentionPartieReseau);
    }

    private void effectuerConnexion(){

        Intent intentionConnexion = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(fournisseursDeConnexion).build();

        this.startActivityForResult(intentionConnexion, GConstantes.CODE_CONNEXION_FIREBASE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == GConstantes.CODE_CONNEXION_FIREBASE){
            if(resultCode == RESULT_OK){
                Log.d("Atelier11", "onActivityResult: Reussi");
            } else {
                Log.d("Atelier11", "onActivityResult: Echoue");
            }
        }
    }

}
