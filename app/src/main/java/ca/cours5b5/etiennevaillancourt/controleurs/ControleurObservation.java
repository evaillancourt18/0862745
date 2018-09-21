package ca.cours5b5.etiennevaillancourt.controleurs;

import java.util.Map;

import ca.cours5b5.etiennevaillancourt.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.etiennevaillancourt.modeles.Modele;

public class ControleurObservation {

    private static Map<Modele, ListenerObservateur> observations;

    static{

    }

    public static void observerModele(String nomMOdele, final ListenerObservateur listenerObservateur){

    }

    public static void lancerObservation(Modele modele){

    }
}
