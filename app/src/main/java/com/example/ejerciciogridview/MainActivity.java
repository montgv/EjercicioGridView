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

    private ActivityMainBinding binding;
    private List<Personas> miLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        miLista = new ArrayList<>();
        miLista.add(new Personas("Miguel", "López Sánchez", "Hombre", "ASIR"));
        miLista.add(new Personas("Juan", "Pérez Pérez", "Hombre", "DAW"));
        miLista.add(new Personas("Maria", "Martínez Fernández", "Mujer", "DAM"));
        miLista.add(new Personas("Antonio", "González García", "Hombre", "DAM"));
        miLista.add(new Personas("Ana", "Díaz Torres", "Mujer", "ASIR"));

        MiAdaptador miAdaptador = new MiAdaptador(this, R.layout.opciones_item, miLista);
        binding.gridView.setAdapter(miAdaptador);

        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pasarPantalla(i);
            }
        });
    }

    private void pasarPantalla(int i) {
        Intent intent = new Intent(this, com.example.ejerciciogridview.ActivityModulos.class);

        String ciclo = miLista.get(i).getCiclo();
        intent.putExtra("ciclo", ciclo);

        startActivity(intent);
        finish();
    }
}