package com.example.practicapuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickEmpezar(View v) {
        EditText et1 = findViewById(R.id.nombreUsuario);
        String nombre = et1.getText().toString();
        Intent i = new Intent(this, PuzzleActivity.class);
        i.putExtra("nombreJugador", nombre);
        startActivity(i);
    }
}