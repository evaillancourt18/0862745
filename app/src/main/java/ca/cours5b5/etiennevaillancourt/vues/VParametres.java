package ca.cours5b5.etiennevaillancourt.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Arrays;

import ca.cours5b5.etiennevaillancourt.R;
import ca.cours5b5.etiennevaillancourt.global.GConstantes;

//ajout tag

public class VParametres extends ConstraintLayout {

    public VParametres(Context context) {
        super(context);
    }

    public VParametres(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VParametres(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        Spinner spinHauteur = this.findViewById(R.id.spinnerHauteur);
        ArrayAdapter<Integer> adapterHauteur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinHauteur.setAdapter(adapterHauteur);
        for(int i = GConstantes.MINHAUTEUR;i<=GConstantes.MAXHAUTEUR;i++){
            adapterHauteur.add(i);
        }
        spinHauteur.setSelection(adapterHauteur.getPosition(GConstantes.DEFAUTHAUTEUR));



        Spinner spinLargeur = this.findViewById(R.id.spinnerLargeur);
        ArrayAdapter<Integer> adapterLargeur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinLargeur.setAdapter(adapterLargeur);
        for(int i = GConstantes.MINLARGEUR;i<=GConstantes.MAXLARGEUR;i++){
            adapterLargeur.add(i);
        }
        spinLargeur.setSelection(adapterLargeur.getPosition(GConstantes.DEFAUTLARGEUR));

        Spinner spinGagner = this.findViewById(R.id.spinnerGagner);
        ArrayAdapter<Integer> adapterGagner = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinGagner.setAdapter(adapterGagner);
        for(int i = GConstantes.MINGAGNER;i<=GConstantes.MAXGAGNER;i++){
            adapterGagner.add(i);
        }
        spinGagner.setSelection(adapterGagner.getPosition(GConstantes.DEFAUTGAGNER));


    }
}
