package ca.cours5b5.etiennevaillancourt.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Arrays;

import ca.cours5b5.etiennevaillancourt.R;
import ca.cours5b5.etiennevaillancourt.global.GConstantes;
import ca.cours5b5.etiennevaillancourt.modeles.MParametres;

//ajout tag

public class VParametres extends Vue {


    static{
        Log.d("Atelier04", VParametres.class.getSimpleName() + "::static");

    }

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
        Log.d("Atelier04", VParametres.class.getSimpleName() + "::onFinishInflate");
        Spinner spinHauteur = this.findViewById(R.id.spinnerHauteur);
        ArrayAdapter<Integer> adapterHauteur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinHauteur.setAdapter(adapterHauteur);
        for(int i=MParametres.instance.getChoixHauteur().get(0); i<=GConstantes.MAXHAUTEUR;i++) {
            adapterHauteur.add(i);
        }
        spinHauteur.setSelection(adapterHauteur.getPosition(GConstantes.DEFAUTHAUTEUR));

        spinHauteur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Integer leChoix = (Integer) parent.getAdapter().getItem(position);
                MParametres.instance.setHauteur(leChoix);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }

        });

        Spinner spinLargeur = this.findViewById(R.id.spinnerLargeur);
        ArrayAdapter<Integer> adapterLargeur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinLargeur.setAdapter(adapterLargeur);
        for(int i=MParametres.instance.getChoixLargeur().get(0); i<=GConstantes.MAXLARGEUR;i++) {
            adapterLargeur.add(i);
        }
        spinLargeur.setSelection(adapterLargeur.getPosition(GConstantes.DEFAUTLARGEUR));

        spinLargeur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Integer leChoix = (Integer) parent.getAdapter().getItem(position);
                MParametres.instance.setLargeur(leChoix);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }

        });

        Spinner spinGagner = this.findViewById(R.id.spinnerGagner);
        ArrayAdapter<Integer> adapterGagner = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinGagner.setAdapter(adapterGagner);
        for(int i=MParametres.instance.getChoixPourGagner().get(0); i<=GConstantes.MAXGAGNER;i++) {
            adapterGagner.add(i);
        }
        spinGagner.setSelection(adapterGagner.getPosition(GConstantes.DEFAUTGAGNER));

        spinGagner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Integer leChoix = (Integer) parent.getAdapter().getItem(position);
                MParametres.instance.setPourGagner(leChoix);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }

        });
    }
}
