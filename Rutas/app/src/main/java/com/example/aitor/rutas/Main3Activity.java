package com.example.aitor.rutas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle bundle = getIntent().getExtras();
        String dato=bundle.getString("direccion");
        Toast.makeText(this, dato, Toast.LENGTH_LONG).show();

    }



}
