package ca.cours5b5.etiennevaillancourt.proxy;

import com.google.firebase.database.DatabaseReference;

public abstract class Proxy {

    private String cheminServeur;

    protected DatabaseReference noeudServeur;

    public Proxy(String cheminServeur){

    }

    public void connecterAuServeur(){

    }

    public void deconnecterDuServeur(){

    }

    public abstract void detruireValeurs();
}
