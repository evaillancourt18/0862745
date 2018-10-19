package ca.cours5b5.etiennevaillancourt.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;

import ca.cours5b5.etiennevaillancourt.R;
import ca.cours5b5.etiennevaillancourt.controleurs.ControleurObservation;
import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.etiennevaillancourt.modeles.MPartie;
import ca.cours5b5.etiennevaillancourt.modeles.Modele;

public class VPartie extends Vue {

    private VGrille grille;

    public VPartie(Context context) {
        super(context);
    }

    public VPartie(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate(){
        Log.d("Atelier06", "VPartie::onFinishInflate");
        super.onFinishInflate();
        initialiser();
        observerPartie();


    }


    private void initialiser(){
        grille = this.findViewById(R.id.grille);
    }

    private void observerPartie(){
        Log.d("Atelier06", "VPartie::observerPartie");
        String name = MPartie.class.getSimpleName();

        ControleurObservation.observerModele(name, new ListenerObservateur() {
            @Override
            public void reagirNouveauModele(Modele modele) {
                Log.d("Atelier06", "VPartie::reagirNouveauModele");
                super.reagirNouveauModele(modele);
                MPartie partie = (MPartie) modele;

                initialiserGrille(partie);
                miseAJourGrille((MPartie) modele);
            }

            @Override
            public void reagirChangementAuModele(Modele modele){
                miseAJourGrille((MPartie) modele);
            }
        });

    }

    private void initialiserGrille(MPartie mPartie){
    int hauteur = mPartie.getParametres().getHauteur();
    int largeur = mPartie.getParametres().getLargeur();
    grille.creerGrille(hauteur,largeur);
    }


    private void miseAJourGrille(MPartie partie){
        Log.d("Atelier07","miseAJour");
      grille.afficherJetons(partie.getGrille());
    }


}
