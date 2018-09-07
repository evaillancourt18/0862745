package ca.cours5b5.etiennevaillancourt.serialisation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

import ca.cours5b5.etiennevaillancourt.modeles.MParametres;

public class Jsonification {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T extends Serialisable> T aPartirJson(Class<T> classeAImplanter, String json){

        Map<String, Object> objetJson = gson.fromJson(json, Map.class);

        Serialisable obj = null;

        if(classeAImplanter.getSimpleName().equals(MParametres.class.getSimpleName())){

            obj = (Serialisable) new MParametres();

        }




        Serialisation.deserialiser( (Serialisable) obj, objetJson);
        return  (T) obj;
    }

    public static String enJson(Serialisable obj){

        Map<String, Object> objetJson = MParametres.instance.serialiser(obj);

        return gson.toJson(objetJson);
    }

}
