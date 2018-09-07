package ca.cours5b5.etiennevaillancourt.modeles;

import java.util.Map;

import ca.cours5b5.etiennevaillancourt.serialisation.Serialisable;

public abstract class Modele {
    public abstract Map<String,Object> serialiser(Serialisable obj);

}
