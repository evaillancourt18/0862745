package ca.cours5b5.etiennevaillancourt.exceptions;

import android.util.Log;

public class ErreurDeSerialisation extends RuntimeException {

    public ErreurDeSerialisation(String message){
        super(message);
    }
}
