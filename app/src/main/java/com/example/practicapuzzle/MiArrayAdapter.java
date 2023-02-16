package com.example.practicapuzzle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MiArrayAdapter extends ArrayAdapter<Jugador> {
    public MiArrayAdapter(Context context, Jugador[] jugadores) {
        super(context, 0, jugadores);
    }
    public MiArrayAdapter(Context context, java.util.List<Jugador> libros) {
        super(context, 0, libros);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Jugador j = getItem(position);
        View v;
        v = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        TextView tv;
        tv = (TextView) v.findViewById(android.R.id.text1);
        tv.setText(j.getNombre());
        tv = (TextView) v.findViewById(android.R.id.text2);
        tv.setText(j.getPuntuaciones());

        return v;
    }
}