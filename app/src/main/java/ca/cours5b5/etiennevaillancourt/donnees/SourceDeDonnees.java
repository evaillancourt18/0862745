package ca.cours5b5.etiennevaillancourt.donnees;

import java.util.Map;


public abstract class SourceDeDonnees {

    public abstract void chargerModele(final String cheminSauvegarde, final ListenerChargement listenerChargement);

    public abstract void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson);

    protected String getNomModele(String cheminDeSauvegarde){
        return cheminDeSauvegarde.split("/")[0];
    }

    public abstract void detruireSauvegarde(String cheminDeSauvegarde);

}
