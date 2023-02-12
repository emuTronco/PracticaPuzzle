package com.example.practicapuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PuzzleActivity extends AppCompatActivity {

    TextView tv1;
    static ImageButton ib1, ib2, ib3, ib4, ib5, ib6, ib7, ib8;
    boolean cambiar=false;
    int boton;
    int aux=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);
        tv1 = findViewById(R.id.ordenaNombre);
        tv1.setText(getString(R.string.ArrangePuzzle).concat(" ").concat(getIntent().getStringExtra("nombreJugador")));


        ib1 = findViewById(R.id.pieza1);
        ib1.setImageResource(R.drawable.imagen1);
        ib1.setTag(R.drawable.imagen1);

        ib2 = findViewById(R.id.pieza2);
        ib2.setImageResource(R.drawable.imagen2);
        ib2.setTag(R.drawable.imagen2);

        ib3 = findViewById(R.id.pieza3);
        ib3.setImageResource(R.drawable.imagen3);
        ib3.setTag(R.drawable.imagen3);

        ib4 = findViewById(R.id.pieza4);
        ib4.setImageResource(R.drawable.imagen4);
        ib4.setTag(R.drawable.imagen4);

        ib5 = findViewById(R.id.pieza5);
        ib5.setImageResource(R.drawable.imagen5);
        ib5.setTag(R.drawable.imagen5);

        ib6 = findViewById(R.id.pieza6);
        ib6.setImageResource(R.drawable.imagen6);
        ib6.setTag(R.drawable.imagen6);

        ib7 = findViewById(R.id.pieza7);
        ib7.setImageResource(R.drawable.imagen7);
        ib7.setTag(R.drawable.imagen7);

        ib8 = findViewById(R.id.pieza8);
        ib8.setImageResource(R.drawable.imagen8);
        ib8.setTag(R.drawable.imagen8);

//        iniciarImageButton(ib1, R.id.pieza1, R.drawable.imagen1);
//        iniciarImageButton(ib2, R.id.pieza2, R.drawable.imagen2);
//        iniciarImageButton(ib3, R.id.pieza3, R.drawable.imagen3);
//        iniciarImageButton(ib4, R.id.pieza4, R.drawable.imagen4);
//        iniciarImageButton(ib5, R.id.pieza5, R.drawable.imagen5);
//        iniciarImageButton(ib6, R.id.pieza6, R.drawable.imagen6);
//        iniciarImageButton(ib7, R.id.pieza7, R.drawable.imagen7);
//        iniciarImageButton(ib8, R.id.pieza8, R.drawable.imagen8);


    }

    private void iniciarImageButton(ImageButton ib, int pieza, int res) {
        ib = (ImageButton) findViewById(pieza);
        ib.setImageResource(res);
        ib.setTag(res);
    }

    private void randomizar() {
        ib2 = findViewById(R.id.pieza2);
        ib2.setImageResource(R.drawable.imagen4);
        ib2.setTag(R.drawable.imagen4);
        ib3 = findViewById(R.id.pieza2);
        ib2.setImageResource(R.drawable.imagen4);
        ib2.setTag(R.drawable.imagen4);
    }

    public void cambiar(View v) {

        if (!cambiar && aux==-1) {
            if (v.getId()==R.id.pieza1) {
                aux = (Integer) ib1.getTag();
                boton=1;
            }
            else if (v.getId()==(R.id.pieza2)) {
                aux = (Integer) ib2.getTag();
                boton=2;
            }
            else if (v.getId()==(R.id.pieza3)) {
                aux = (Integer) ib3.getTag();
                boton=3;
            }
            else if (v.getId()==(R.id.pieza4)) {
                aux = (Integer) ib4.getTag();
                boton=4;
            }
            else if (v.getId()==(R.id.pieza5)) {
                aux = (Integer) ib5.getTag();
                boton=5;
            }
            else if (v.getId()==(R.id.pieza6)) {
                aux = (Integer) ib6.getTag();
                boton=6;
            }
            else if (v.getId()==(R.id.pieza7)) {
                aux = (Integer) ib7.getTag();
                boton=7;
            }
            else {
                aux = (Integer) ib8.getTag();
                boton=8;
            }
            cambiar=true;
        }
        else{
            if (v.getId()==(R.id.pieza1)) {
                moverHacia(ib1);
            }
            else if (v.getId()==(R.id.pieza2)) {
                moverHacia(ib2);
            }
            else if (v.getId()==(R.id.pieza3)) {
                moverHacia(ib3);
            }
            else if (v.getId()==(R.id.pieza4)) {
                moverHacia(ib4);
            }
            else if (v.getId()==(R.id.pieza5)) {
                moverHacia(ib5);
            }
            else if (v.getId()==(R.id.pieza6)) {
                moverHacia(ib6);
            }
            else if (v.getId()==(R.id.pieza7)) {
                moverHacia(ib7);
            }
            else {
                moverHacia(ib8);
            }
            cambiar=false;
            aux=-1;

        }

    }

    private void moverHacia(ImageButton ib) {
        switch (boton) {
            case 1:
                ib1.setImageResource((Integer) ib.getTag());
                ib1.setTag(ib.getTag());
                break;
            case 2:
                ib2.setImageResource((Integer) ib.getTag());
                ib2.setTag(ib.getTag());
                break;
            case 3:
                ib3.setImageResource((Integer) ib.getTag());
                ib3.setTag(ib.getTag());
                break;
            case 4:
                ib4.setImageResource((Integer) ib.getTag());
                ib4.setTag(ib.getTag());
                break;
            case 5:
                ib5.setImageResource((Integer) ib.getTag());
                ib5.setTag(ib.getTag());
                break;
            case 6:
                ib6.setImageResource((Integer) ib.getTag());
                ib6.setTag(ib.getTag());
                break;
            case 7:
                ib7.setImageResource((Integer) ib.getTag());
                ib7.setTag(ib.getTag());
                break;
            case 8:
                ib8.setImageResource((Integer) ib.getTag());
                ib8.setTag(ib.getTag());
                break;
        }
        ib.setImageResource(aux);
        ib.setTag(aux);
    }
}