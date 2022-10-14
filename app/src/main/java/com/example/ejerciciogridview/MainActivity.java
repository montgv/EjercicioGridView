package com.example.ejerciciogridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.ejerciciogridview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Creamos el binding que nos sirve para la vinculacion de vista
    private ActivityMainBinding binding;
    //Creamos una lista de la clase Personas
    private List<Personas> miLista;

    //Este metodo es el metodo que se llama para que comienze el activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Esta tres lineas hace que se nos vincule las vistas con el activity
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //EStamos asignandole a miLista que sea un arrayList y le estamos añadiendo diferentes
        //objetos de tipo Personas
        miLista = new ArrayList<>();
        miLista.add(new Personas("Miguel", "López Sánchez", "Hombre", "ASIR"));
        miLista.add(new Personas("Juan", "Pérez Pérez", "Hombre", "DAW"));
        miLista.add(new Personas("Maria", "Martínez Fernández", "Mujer", "DAM"));
        miLista.add(new Personas("Antonio", "González García", "Hombre", "DAM"));
        miLista.add(new Personas("Ana", "Díaz Torres", "Mujer", "ASIR"));

        //Estamos creando un adaptador que lo que hace es devolver una vista para cada objeto
        //de una coleccion de objetos de datos, es decir, para los diferentes objetos que tiene
        //el arrayList, y despues, asociamos al binding a la gridView para que use ese adaptador
        MiAdaptador miAdaptador = new MiAdaptador(this, R.layout.opciones_item, miLista);
        binding.gridView.setAdapter(miAdaptador);

        //Definimos un escuchador para cuando pulsemos en un item del gridView haga lo que se le indica
        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pasarPantalla(i);
            }
        });
    }
    //Definimos la funcion que crea un intent para que se vaya a la ActivityModulos, y que realice el
    //envio de informacion de una actividad a otra, que realice el salta a la nueva actividad y que
    //cuando la actividad haya terminado que se cierre
    private void pasarPantalla(int i) {
        Intent intent = new Intent(this, com.example.ejerciciogridview.ActivityModulos.class);

        String ciclo = miLista.get(i).getCiclo();
        intent.putExtra("ciclo", ciclo);

        startActivity(intent);
        finish();
    }
}