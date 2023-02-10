package com.example.practicapuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PuzzleActivity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);
        tv1 = findViewById(R.id.ordenaNombre);
        tv1.setText(getString(R.string.ArrangePuzzle).concat(getIntent().getStringExtra("nombreJugador")));
    }
}