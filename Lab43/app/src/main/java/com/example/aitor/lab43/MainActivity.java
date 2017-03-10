package com.example.aitor.lab43;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void verCrear(View view) {
        Intent i = new Intent(this, Crear.class);
        startActivity(i);
    }

    public void verBorrar(View view) {
        Intent i = new Intent(this, Borrar.class);
        startActivity(i);

    }

    public void verLeer(View view) {
        Intent i = new Intent(this, Leer.class);
        startActivity(i);


    }

    public void verActualizar(View view) {
        Intent i = new Intent(this, Actualizar.class);
        startActivity(i);


    }



    }




