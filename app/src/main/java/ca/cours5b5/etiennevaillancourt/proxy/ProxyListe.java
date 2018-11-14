package ca.cours5b5.etiennevaillancourt.proxy;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.List;

import ca.cours5b5.etiennevaillancourt.controleurs.Action;
import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.Fournisseur;
import ca.cours5b5.etiennevaillancourt.global.GCommande;

public class ProxyListe extends Proxy implements Fournisseur {

    private ChildEventListener childEventListener;

    private Query requete;

    private Action actionNouvelItem;

    private List<DatabaseReference> noeudsAjoutes;

    public ProxyListe(String cheminServeur){
        super(cheminServeur);
        setActionNouvelItem(GCommande.RECEVOIR_COUP_RESEAU);
    }

    public void setActionNouvelItem(GCommande commande){

    }

    public void ajouterValeur(Object valeur){

    }

    private void creerListener(){

    }

    protected Query getRequete(){
        return null;
    }

    @Override
    public void deconnecterDuServeur(){

    }
    @Override
    public void detruireValeurs() {

    }
}
