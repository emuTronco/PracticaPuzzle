package com.example.practicapuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PuzzleActivity extends AppCompatActivity {

    TextView tv1, tvNumIntentos;
    ImageView ib1, ib2, ib3, ib4, ib5, ib6, ib7, ib8;
    Drawable dw1, dw2, dw3, dw4, dw5, dw6, dw7, dw8;
    boolean cambiar = false;
    int boton;
    int aux = -1;
    boolean terminado = false;
    boolean seleccionado = false;
    int numIntentos = 0;
    String mensajeIntentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        tvNumIntentos = findViewById(R.id.tvIntentos);
        mensajeIntentos = getString(R.string.numIntentos, numIntentos);
        tvNumIntentos.setText(mensajeIntentos);

        tv1 = findViewById(R.id.ordenaNombre);
        tv1.setText(getString(R.string.ArrangePuzzle).concat(" ").concat(getIntent().getStringExtra("nombreJugador")));

        ib1 = findViewById(R.id.pieza1);
        ib1.setImageResource(R.drawable.imagen1);
        ib1.setTag(R.drawable.imagen1);
        dw1 = ib1.getDrawable();

        ib2 = findViewById(R.id.pieza2);
        ib2.setImageResource(R.drawable.imagen2);
        ib2.setTag(R.drawable.imagen2);
        dw2 = ib2.getDrawable();

        ib3 = findViewById(R.id.pieza3);
        ib3.setImageResource(R.drawable.imagen3);
        ib3.setTag(R.drawable.imagen3);
        dw3 = ib3.getDrawable();

        ib4 = findViewById(R.id.pieza4);
        ib4.setImageResource(R.drawable.imagen4);
        ib4.setTag(R.drawable.imagen4);
        dw4 = ib4.getDrawable();

        ib5 = findViewById(R.id.pieza5);
        ib5.setImageResource(R.drawable.imagen5);
        ib5.setTag(R.drawable.imagen5);
        dw5 = ib5.getDrawable();

        ib6 = findViewById(R.id.pieza6);
        ib6.setImageResource(R.drawable.imagen6);
        ib6.setTag(R.drawable.imagen6);
        dw6 = ib6.getDrawable();

        ib7 = findViewById(R.id.pieza7);
        ib7.setImageResource(R.drawable.imagen7);
        ib7.setTag(R.drawable.imagen7);
        dw7 = ib7.getDrawable();

        ib8 = findViewById(R.id.pieza8);
        ib8.setImageResource(R.drawable.imagen8);
        ib8.setTag(R.drawable.imagen8);
        dw8 = ib8.getDrawable();

    }

    private boolean puzzleTerminado(boolean terminado) {
        if (ib1.getDrawable() == dw1 && ib2.getDrawable().equals(R.drawable.imagen2) && ib3.getDrawable().equals(R.drawable.imagen3) && ib4.getDrawable().equals(R.drawable.imagen4) && ib5.getDrawable().equals(R.drawable.imagen5) && ib6.getDrawable().equals(R.drawable.imagen6) && ib7.getDrawable().equals(R.drawable.imagen7) && ib8.getDrawable().equals(R.drawable.imagen8)) {
            System.out.println("Terminado");
            terminado = true;
        }
        return terminado;
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

        if (!terminado) {

            if (!cambiar && aux == -1) {
                if (v.getId() == R.id.pieza1) {
                    aux = (Integer) ib1.getTag();
                    boton = 1;
                } else if (v.getId() == (R.id.pieza2)) {
                    aux = (Integer) ib2.getTag();
                    boton = 2;
                } else if (v.getId() == (R.id.pieza3)) {
                    aux = (Integer) ib3.getTag();
                    boton = 3;
                } else if (v.getId() == (R.id.pieza4)) {
                    aux = (Integer) ib4.getTag();
                    boton = 4;
                } else if (v.getId() == (R.id.pieza5)) {
                    aux = (Integer) ib5.getTag();
                    boton = 5;
                } else if (v.getId() == (R.id.pieza6)) {
                    aux = (Integer) ib6.getTag();
                    boton = 6;
                } else if (v.getId() == (R.id.pieza7)) {
                    aux = (Integer) ib7.getTag();
                    boton = 7;
                } else {
                    aux = (Integer) ib8.getTag();
                    boton = 8;
                }
                cambiar = true;
            } else {
                if (v.getId() == (R.id.pieza1)) {
                    moverHacia(ib1);
                } else if (v.getId() == (R.id.pieza2)) {
                    moverHacia(ib2);
                } else if (v.getId() == (R.id.pieza3)) {
                    moverHacia(ib3);
                } else if (v.getId() == (R.id.pieza4)) {
                    moverHacia(ib4);
                } else if (v.getId() == (R.id.pieza5)) {
                    moverHacia(ib5);
                } else if (v.getId() == (R.id.pieza6)) {
                    moverHacia(ib6);
                } else if (v.getId() == (R.id.pieza7)) {
                    moverHacia(ib7);
                } else {
                    moverHacia(ib8);
                }
                cambiar = false;
                aux = -1;

            }
            puzzleTerminado(terminado);
            if (!seleccionado) {
                seleccionado = true;
            } else {
                numIntentos++;
                mensajeIntentos = getString(R.string.numIntentos, numIntentos);
                tvNumIntentos.setText(mensajeIntentos);
                seleccionado = false;
            }

        }
    }

    private void moverHacia(ImageView ib) {
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