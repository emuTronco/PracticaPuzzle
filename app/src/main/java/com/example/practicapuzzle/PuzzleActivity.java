package com.example.practicapuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PuzzleActivity extends AppCompatActivity {

    TextView tv1, tvNumIntentos;
    ImageView ib1, ib2, ib3, ib4, ib5, ib6, ib7, ib8;
    boolean cambiar = false;
    int boton;
    int aux = -1;
    boolean terminado = false;
    boolean seleccionado = false;
    int numIntentos = 0;
    String mensajeIntentos;
    ArrayList<ImageView> listaPiezas = new ArrayList<>();
    int[] listaID = {R.drawable.imagen1, R.drawable.imagen2, R.drawable.imagen3, R.drawable.imagen4, R.drawable.imagen5, R.drawable.imagen6, R.drawable.imagen7, R.drawable.imagen8,};
    String consultaMinPuntuacion = "SELECT * FROM Jugador WHERE nombre = ?";
    String nombreJugador = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        tvNumIntentos = findViewById(R.id.tvIntentos);
        mensajeIntentos = getString(R.string.numIntentos, numIntentos);
        tvNumIntentos.setText(mensajeIntentos);

        nombreJugador = getIntent().getStringExtra("nombreJugador");
        tv1 = findViewById(R.id.ordenaNombre);
        tv1.setText(getString(R.string.ArrangePuzzle).concat(" ").concat(nombreJugador));

        ib1 = findViewById(R.id.pieza1);
        ib2 = findViewById(R.id.pieza2);
        ib3 = findViewById(R.id.pieza3);
        ib4 = findViewById(R.id.pieza4);
        ib5 = findViewById(R.id.pieza5);
        ib6 = findViewById(R.id.pieza6);
        ib7 = findViewById(R.id.pieza7);
        ib8 = findViewById(R.id.pieza8);

        listaPiezas.add(ib1);
        listaPiezas.add(ib2);
        listaPiezas.add(ib3);
        listaPiezas.add(ib4);
        listaPiezas.add(ib5);
        listaPiezas.add(ib6);
        listaPiezas.add(ib7);
        listaPiezas.add(ib8);

        randomizar(listaPiezas);

    }

    private void puzzleTerminado() {
        if ((int) ib1.getTag() == listaID[0] && (int) ib2.getTag() == listaID[1] && (int) ib3.getTag() == listaID[2] && (int) ib4.getTag() == listaID[3] && (int) ib5.getTag() == listaID[4] && (int) ib6.getTag() == listaID[5] && (int) ib7.getTag() == listaID[6] && (int) ib8.getTag() == listaID[7]) {
            terminado = true;
            TextView tv1 = findViewById(R.id.tvTerminado);
            tv1.setVisibility(View.VISIBLE);
            UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
            SQLiteDatabase db = usdbh.getWritableDatabase();
            ContentValues cv = new ContentValues();
            Cursor c = db.rawQuery(consultaMinPuntuacion, new String[] {nombreJugador});
            int minPuntuacion;
            if (c.moveToFirst()) {
                minPuntuacion = c.getInt(1);
                if (numIntentos < minPuntuacion) {
                    cv.put("minPuntuacion1", numIntentos);
                    String clausula = "nombre= '" + nombreJugador + "'";
                    db.update("Jugador", cv, clausula, null);
                    TextView tv2 = findViewById(R.id.tvNewRecord);
                    tv2.setVisibility(View.VISIBLE);
                }
            }
        }
    }


    private void randomizar(ArrayList<ImageView> lista) {
        int indice;
        for (int i = 0; i < 8; i++) {
            indice = (int) (Math.random() * (8 - i));
            lista.get(indice).setImageResource(listaID[i]);
            lista.get(indice).setTag(listaID[i]);
            lista.remove(indice);
        }
    }

    public void cambiar(View v) {

        puzzleTerminado();

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
            if (!seleccionado) {
                seleccionado = true;
            } else {
                numIntentos++;
                mensajeIntentos = getString(R.string.numIntentos, numIntentos);
                tvNumIntentos.setText(mensajeIntentos);
                seleccionado = false;
            }

        }
        puzzleTerminado();
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