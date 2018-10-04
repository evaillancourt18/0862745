package ca.cours5b5.etiennevaillancourt.vues;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

public class VCase extends AppCompatButton {
    public VCase(Context context) {
        super(context);
        setEnabled(false);
    }

    public VCase(Context context, AttributeSet attrs) {
        super(context, attrs);
        setEnabled(false);
    }

    public VCase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setEnabled(false);
    }
    private int rangee;
    private int colonne;

    public VCase(Context context, int colonne, int rangee) {
        super(context);
        setEnabled(false);
        this.colonne=colonne;
        this.rangee=rangee;

        setText("" +  rangee + "," + colonne);
    }

}
