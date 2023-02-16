package com.example.practicapuzzle;

public class Jugador {

    private String nombre;
    private String puntuaciones;

    public Jugador(String nombre, String puntuaciones) {
        this.nombre = nombre;
        this.puntuaciones = puntuaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuntuaciones() {
        return puntuaciones;
    }


}
