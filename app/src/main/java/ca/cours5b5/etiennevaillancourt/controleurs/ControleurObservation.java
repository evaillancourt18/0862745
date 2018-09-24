package ca.cours5b5.etiennevaillancourt.controleurs;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.etiennevaillancourt.modeles.MParametres;
import ca.cours5b5.etiennevaillancourt.modeles.Modele;

public class ControleurObservation {

    private static Map<Modele, ListenerObservateur> observations;

    static{
    observations=new HashMap<>();
    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){

    observations.put(MParametres.instance, listenerObservateur);
    lancerObservation(MParametres.instance);

    }

    public static void lancerObservation(Modele modele){
        ListenerObservateur listenerObservateur = observations.get(modele);
        if(listenerObservateur!=null){
            listenerObservateur.reagirChangementAuModele(modele);
        }
    }
}
