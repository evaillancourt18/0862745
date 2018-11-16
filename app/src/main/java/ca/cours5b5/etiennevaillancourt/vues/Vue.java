package ca.cours5b5.etiennevaillancourt.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;

import ca.cours5b5.etiennevaillancourt.controleurs.ControleurAction;
import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.Fournisseur;
import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.etiennevaillancourt.global.GCommande;


public abstract class Vue extends ConstraintLayout implements Fournisseur {

    public Vue(Context context) {
        super(context);
    }

    public Vue(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Vue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ControleurAction.fournirAction(this, GCommande.AFFICHER_GAGNANT, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                String couleur = args[0].toString();
                String message = "Le joueur " + couleur + " a gagné";
                Snackbar fenetreMessage = Snackbar.make(Vue.this, message , Snackbar.LENGTH_SHORT);
                fenetreMessage.show();

            }
        });
    }
}
