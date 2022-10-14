package com.example.ejerciciogridview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.ejerciciogridview.databinding.ActivityModulosBinding;

public class ActivityModulos extends AppCompatActivity {
    //Creamos el binding que nos sirve para la vinculacion de vista
    private ActivityModulosBinding binding2;

    //Indica que se debe ignorar las advertencias especificas
    @SuppressLint("SetTextI18n")
    @Override
    //Este metodo es el metodo que se llama para que comienze el activity
    protected void onCreate(Bundle savedInstanceState) {
        //Esta tres lineas hace que se nos vincule las vistas con el activity
        super.onCreate(savedInstanceState);
        binding2 = ActivityModulosBinding.inflate(getLayoutInflater());
        setContentView(binding2.getRoot());

        //Creamos un objeto de tipo Bundle que lo que hace es recoger los datos que hemos mandado
        //anteriormente, capturando el intent y los datos asociados. Tambien guardamos en una variable
        //los datos asociados que qeremos extraer
        Bundle datos = getIntent().getExtras();
        String ciclo = datos.getString("ciclo");

        //Comparamos si es igual el dato extraido con lo indicado y si es asi que le ponga a la pantalla
        //un color determinado, que le ponga una imagen determinada, que escriba un texto determinado
        //y que el boton realice una accion cuando se le pulsa, la funcion volver
        if (ciclo.equals("ASIR")) {
            binding2.pantalla.setBackgroundColor(getResources().getColor(R.color.asir));
            binding2.imageViewCiclos.setImageResource(R.drawable.asir_icon);
            binding2.textViewCiclos.setText("Estás en el ciclo ASIR");
            binding2.btCiclos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    volver();
                }
            });
        } else if (ciclo.equals("DAW")) {
            binding2.pantalla.setBackgroundColor(getResources().getColor(R.color.daw));
            binding2.imageViewCiclos.setImageResource(R.drawable.daw_icon);
            binding2.textViewCiclos.setText("Estás en el ciclo DAW");
            binding2.btCiclos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    volver();
                }
            });
        } else if (ciclo.equals("DAM")) {
            binding2.pantalla.setBackgroundColor(getResources().getColor(R.color.dam));
            binding2.imageViewCiclos.setImageResource(R.drawable.dam_icon);
            binding2.textViewCiclos.setText("Estás en el ciclo DAM");
            binding2.btCiclos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    volver();
                }
            });
        }
    }
    //Definimos la funcion que crea un intent para que se vaya al MainActivity, que realice el salto
    //a la nueva actividad y que cuando la actividad haya terminado que se cierre
    private void volver () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
