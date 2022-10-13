package com.example.ejerciciogridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MiAdaptador extends ArrayAdapter {

    private Context ctx;
    private int layoutTemplate;
    private List<Personas> listaPersonas;


    public MiAdaptador(Context context, int resource, List objects) {
        super(context, resource, objects);

        this.ctx = context;
        this.layoutTemplate = resource;
        this.listaPersonas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent, false);

        Personas personaActual = listaPersonas.get(position);

        ImageView imageViewPersona = v.findViewById(R.id.imageView);
        TextView textViewNombre = v.findViewById(R.id.textViewNombre);
        TextView textViewApellidos = v.findViewById(R.id.textViewApellidos);
        TextView textViewCiclo = v.findViewById(R.id.textViewCiclo);

        textViewNombre.setText(personaActual.getNombre());
        textViewApellidos.setText(personaActual.getApellidos());
        textViewCiclo.setText(personaActual.getCiclo());

        if (personaActual.getSexo() == "Hombre") {
            imageViewPersona.setImageResource(R.drawable.boy_avatar_icon_148454);
        } else {
            imageViewPersona.setImageResource(R.drawable.girl_avatar_icon_148461);
        }

        return v;
    }
}
