package ca.cours5b5.etiennevaillancourt.controleurs;

import android.util.Log;

import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.ListenerGetModele;
import ca.cours5b5.etiennevaillancourt.global.GConstantes;
import ca.cours5b5.etiennevaillancourt.modeles.MPartieReseau;
import ca.cours5b5.etiennevaillancourt.modeles.Modele;
import ca.cours5b5.etiennevaillancourt.proxy.ProxyListe;
import ca.cours5b5.etiennevaillancourt.usagers.UsagerCourant;

public class ControleurPartieReseau {

    private static final ControleurPartieReseau instance = new ControleurPartieReseau();
    public static ControleurPartieReseau getInstance(){return instance;};

    private ProxyListe proxyEmettreCoups;
    private ProxyListe proxyRecevoirCoups;

    public void connecterAuServeur(){

        ControleurModeles.getModele(MPartieReseau.class.getSimpleName(), new ListenerGetModele() {
            @Override
            public void reagirAuModele(Modele modele) {
                MPartieReseau mPartieReseau = (MPartieReseau) modele;
                connecterAuServeur(mPartieReseau.idJoueurHote);
            }
        });

    }

    private void connecterAuServeur(String idJoueurHote){

        String cheminCoupJoueurHote = getCheminCoupsJoueurHote(idJoueurHote);
        String cheminCoupJoueurInvite = getCheminCoupsJoueurInvite(idJoueurHote);

        if(UsagerCourant.getId().equals(idJoueurHote)){
         connecterEnTantQueJoueurHote(cheminCoupJoueurHote,cheminCoupJoueurInvite);
        }else{
            connecterEnTantQueJoueurInvite(cheminCoupJoueurHote,cheminCoupJoueurInvite);
        }
        Log.d("Atelier13", "connecterAuServeur");

    }

    private void connecterEnTantQueJoueurHote(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite){
        proxyEmettreCoups = new ProxyListe(cheminCoupsJoueurHote);
        proxyRecevoirCoups = new ProxyListe(cheminCoupsJoueurInvite);
    }
    private void connecterEnTantQueJoueurInvite(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite){
        proxyEmettreCoups = new ProxyListe(cheminCoupsJoueurInvite);
        proxyRecevoirCoups = new ProxyListe(cheminCoupsJoueurHote);
    }
    public void deconnecterDuServeur(){

        proxyEmettreCoups = null;
        proxyRecevoirCoups = null;

    }
    public void transmettreCoup(Integer idColonne){
        proxyEmettreCoups.ajouterValeur(idColonne);

    }
    private String getCheminCoupsJoueurInvite(String idJoueurHote){
        return getCheminPartie(idJoueurHote) + "/" + GConstantes.CLE_COUPS_JOUEUR_INVITE;
    }
    private String getCheminCoupsJoueurHote(String idJoueurHote){
        return getCheminPartie(idJoueurHote) + "/" + GConstantes.CLE_COUPS_JOUEUR_HOTE;
    }
    private String getCheminPartie(String idJoueurHote){
        return MPartieReseau.class.getSimpleName() + "/" + idJoueurHote;
    }
    public void detruireSauvegardeServeur(){

    }
}
