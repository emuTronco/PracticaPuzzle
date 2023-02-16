package com.example.practicapuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static int versionTabla = 1;
    private static boolean reiniciado = false;
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!reiniciado) {  //se reinicia la bbdd la primera vez que se inicie la aplicacion
            reiniciarBBDD();
            reiniciado = true;
            //Abrimos la base de datos 'DBContactos' en modo escritura
            UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
            SQLiteDatabase db = usdbh.getWritableDatabase();
        }

    }

    public void onClickEmpezar(View v) {
        EditText et1 = findViewById(R.id.nombreUsuario);
        String nombre = et1.getText().toString();
        Intent i = new Intent(this, PuzzleActivity.class);
        i.putExtra("nombreJugador", nombre);
        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
        SQLiteDatabase db = usdbh.getWritableDatabase();
        String[] nombreArray = new String[]{nombre};
        Cursor c = db.rawQuery("Select * FROM Jugador WHERE nombre = ?;", nombreArray);
        if (!(c.moveToFirst())) {
            String insertarUsuario = "INSERT into Jugador VALUES ('" + nombre + "',99,99);";
            db.execSQL(insertarUsuario);
        }
        startActivity(i);

    }

    public void onClickPuntuaciones(View v) {
        Intent i = new Intent(this, PuntuacionesActivity.class);
        startActivity(i);
    }

    public void onClickMusica(View v) {
        if (isPlaying) {
            stopService(new Intent(MainActivity.this, BackgroundSoundService.class));
            isPlaying = false;
        } else {
            startService(new Intent(MainActivity.this, BackgroundSoundService.class));
            isPlaying = true;
        }

    }


    private void reiniciarBBDD() {
        this.deleteDatabase("DBUsuarios");
    }
}