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

//Declaramos la clase MiAdaptador que extiende de ArrayAdapter
public class MiAdaptador extends ArrayAdapter {
    //Declaramos los diferentes atributos que tiene esta clase
    private Context ctx;
    private int layoutTemplate;
    private List<Personas> listaPersonas;

    //Declaramos un constructor personas con los diferentes atributos
    public MiAdaptador(Context context, int resource, List objects) {
        super(context, resource, objects);

        this.ctx = context;
        this.layoutTemplate = resource;
        this.listaPersonas = objects;
    }

    @NonNull
    @Override
    //Implementamos el metodo getView que obtiene una vista que muestra los datos de la posicion
    //actual del conjunto de datos
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent, false);

        //Obtiene la persona de la posicion actual
        Personas personaActual = listaPersonas.get(position);

        //Enlazamos los determinados componentes del adaptador con la vinculacion de datos
        ImageView imageViewPersona = v.findViewById(R.id.imageView);
        TextView textViewNombre = v.findViewById(R.id.textViewNombre);
        TextView textViewApellidos = v.findViewById(R.id.textViewApellidos);
        TextView textViewCiclo = v.findViewById(R.id.textViewCiclo);

        //Cambiamos el texto de los diferentes componentes por los obtenidos de la persona actual
        textViewNombre.setText(personaActual.getNombre());
        textViewApellidos.setText(personaActual.getApellidos());
        textViewCiclo.setText(personaActual.getCiclo());

        //Si el dato de la persona actual es igual al introducido la cambia la imagen por una concreta
        //sino le cambia la imagen por otra
        if (personaActual.getSexo() == "Hombre") {
            imageViewPersona.setImageResource(R.drawable.boy_avatar_icon_148454);
        } else {
            imageViewPersona.setImageResource(R.drawable.girl_avatar_icon_148461);
        }
        //Devuelve la vista
        return v;
    }
}
