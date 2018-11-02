package ca.cours5b5.etiennevaillancourt.usagers;

import com.google.firebase.auth.FirebaseAuth;

public class UsagerCourant {

    public static boolean siUsagerConnecte() {

        boolean connecte = false;

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            connecte = true;
        }
            return connecte;

    }

    public static String getId() {

        String identifiant;

        if(siUsagerConnecte()){

            identifiant = FirebaseAuth.getInstance().getCurrentUser().getUid();

        }
        else{

            identifiant = "defaut";

        }

        return identifiant;
    }
}
