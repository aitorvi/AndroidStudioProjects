package com.example.ayr.lab32b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Condiciones extends AppCompatActivity {
    private EditText et1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condiciones);

        et1 = (EditText) findViewById(R.id.et1);

        Bundle bundle = getIntent().getExtras();
        String dato = bundle.getString("nombre");
        et1.setText("Hola " + dato + " ¿Aceptas las condiciones?");


    }

    public void aceptar(View v) {

        Intent intent = new Intent();
        intent.putExtra("resultado", "aceptado");
        setResult(RESULT_OK, intent);

        finish();
    }

    public void rechazar(View v) {

        Intent intent = new Intent();
        intent.putExtra("resultado", "rechazado");
        setResult(RESULT_OK, intent);

        finish();

    }
}