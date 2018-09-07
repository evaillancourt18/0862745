package ca.cours5b5.etiennevaillancourt.serialisation;

import java.lang.reflect.Field;
import java.util.Map;

import ca.cours5b5.etiennevaillancourt.exceptions.ErreurDeSerialisation;
import ca.cours5b5.etiennevaillancourt.modeles.MParametres;
import ca.cours5b5.etiennevaillancourt.modeles.Modele;

public class Serialisation {

    public static Map<String, Object> serialiser(Serialisable obj) throws ErreurDeSerialisation {

        if(obj instanceof MParametres){

            return ((MParametres)obj).serialiser(obj);

        } else{
            return null;
        }


    }

    public static void deserialiser(Serialisable obj, Map<String, Object> objetJson) throws ErreurDeSerialisation{

        if(obj instanceof MParametres){
           ((MParametres)objetJson).deserialiser(objetJson);
        }

    }

    private static void serialiserAttributs(Map<String, Object> objetJson, Serialisable obj){

    }

    private static boolean siAttributSerialisable(Field attribut){
        return false;
    }

    private static void serialiserAttribut (Map<String, Object> objetJson, Serialisable obj, Field attribut){

    }

    private static Object serialiserValeur(Class type, Object valeur){
        return null;
    }

    private static void deserialiserAttributs(Serialisable obj, Map<String, Object> objetJson){

    }
    private static void deserialiserAttributs(Serialisable obj, String nomAttribut, Object valeurAttribut){

    }
    private static void deserialiserAttributs(Serialisable obj, Field attribut, Object valeurAttribut){

    }
}
