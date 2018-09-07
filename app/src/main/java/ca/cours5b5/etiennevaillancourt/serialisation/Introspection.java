package ca.cours5b5.etiennevaillancourt.serialisation;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.etiennevaillancourt.exceptions.ErreurIntrospection;

public class Introspection {
    private static final List<String> PAQUETS = new ArrayList<>();

    public static <T> Class<T> trouverClasse(String nomClasse) throws ErreurIntrospection {
        return null;
    }
}
