package com.example.ejerciciogridview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.ejerciciogridview.databinding.ActivityModulosBinding;

public class ActivityModulos extends AppCompatActivity {

    private ActivityModulosBinding binding2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding2 = ActivityModulosBinding.inflate(getLayoutInflater());
        setContentView(binding2.getRoot());

        Bundle datos = getIntent().getExtras();
        String ciclo = datos.getString("ciclo");

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
    private void volver () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
