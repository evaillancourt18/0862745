package ca.cours5b5.etiennevaillancourt.vues;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import ca.cours5b5.etiennevaillancourt.R;
import ca.cours5b5.etiennevaillancourt.controleurs.ControleurObservation;
import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.etiennevaillancourt.exceptions.ErreurObservation;
import ca.cours5b5.etiennevaillancourt.global.GCouleur;
import ca.cours5b5.etiennevaillancourt.modeles.MParametresPartie;
import ca.cours5b5.etiennevaillancourt.modeles.MPartie;
import ca.cours5b5.etiennevaillancourt.modeles.Modele;


public class VPartie extends Vue {

    private VGrille grille;

    private TextView texteJoueur1;
    private TextView texteJoueur2;

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
    protected void onFinishInflate() {
        super.onFinishInflate();

        initialiser();

        observerPartie();

    }

    private void initialiser() {

        grille = findViewById(R.id.grille);
        texteJoueur1 = findViewById(R.id.texte_joueur_un);
        texteJoueur2 = findViewById(R.id.texte_joueur_deux);

    }

    private void observerPartie() {

        ControleurObservation.observerModele(getNomModele(),
                new ListenerObservateur() {
                    @Override
                    public void reagirNouveauModele(Modele modele) {

                        MPartie partie = getPartie(modele);

                        preparerAffichage(partie);

                        miseAJourGrille(partie);

                    }

                    @Override
                    public void reagirChangementAuModele(Modele modele) {

                        MPartie partie = getPartie(modele);

                        miseAJourGrille(partie);

                    }
                });
    }

    private void preparerAffichage(MPartie partie) {

        MParametresPartie parametresPartie = partie.getParametres();

        grille.creerGrille(parametresPartie.getHauteur(), parametresPartie.getLargeur());

    }

    private MPartie getPartie(Modele modele){

        try{

            return (MPartie) modele;

        }catch(ClassCastException e){

            throw new ErreurObservation(e);

        }

    }

    private void miseAJourGrille(MPartie partie){

        grille.afficherJetons(partie.getGrille());
        setCouleur(partie.getCouleurCourante());

    }

    public void setCouleur(GCouleur couleurCourante){

        if(couleurCourante == GCouleur.ROUGE){
            texteJoueur1.setBackgroundColor(Color.RED);
            texteJoueur2.setBackgroundColor(Color.WHITE);
        } else if(couleurCourante == GCouleur.JAUNE){
            texteJoueur2.setBackgroundColor(Color.YELLOW);
            texteJoueur1.setBackgroundColor(Color.WHITE);
        }

    }

    protected String getNomModele() {return MPartie.class.getSimpleName();}

}
