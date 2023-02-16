package com.example.practicapuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PuntuacionesActivity extends AppCompatActivity {

    String consultaJugadores = "SELECT * FROM Jugador";
    String puntuacionFormat = "Puzzle 1: %d     Puzzle 2: %d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
        SQLiteDatabase db = usdbh.getWritableDatabase();
        Cursor c = db.rawQuery(consultaJugadores, null);
        while (c.moveToNext()) {
            jugadores.add(new Jugador(c.getString(0), String.format(puntuacionFormat, c.getInt(1), c.getInt(2))));
        }

        MiArrayAdapter aa = new MiArrayAdapter(this, jugadores);
        ListView lv = (ListView) findViewById(R.id.lvPuntuaciones);
        lv.setAdapter(aa);
    }

}