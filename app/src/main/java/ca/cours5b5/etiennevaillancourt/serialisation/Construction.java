package ca.cours5b5.etiennevaillancourt.serialisation;

import ca.cours5b5.etiennevaillancourt.exceptions.ErreurDeConstruction;

public class Construction {

    public static <T extends Constructible> T construire(Class<T> classeAInstantier) throws ErreurDeConstruction{
        return null;
    }

    private static <T extends Constructible> T finaliserContruction(Class<T> classeAInstatier, Object obj){
        return null;
    }
}
