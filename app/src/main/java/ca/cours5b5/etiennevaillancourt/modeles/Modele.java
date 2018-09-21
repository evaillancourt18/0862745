package ca.cours5b5.etiennevaillancourt.modeles;

import java.util.Map;

import ca.cours5b5.etiennevaillancourt.exceptions.ErreurDeSerialisation;

public abstract class Modele {
   public abstract void aPartirObjetJson(Map<String, Object> objetJson);

   public abstract Map<String, Object> enObjetJson();

}


