package com.example.aitor.lab4;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private TextView tv2, tv3,tv4;
    private Button b1;
    private int numero;
    private int intentos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        SharedPreferences prefe = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String v = String.valueOf(prefe.getInt("puntos", 0));
        tv2.setText(v);
        numero = 1 + (int) (Math.random() * 10);
    }

    public void verificar(View v) {
        intentos=++intentos;
        int valor = Integer.parseInt(et1.getText().toString());
        if (numero == valor) {
            int puntosactual = Integer.parseInt(tv2.getText()
                    .toString());
            puntosactual++;
            tv2.setText(String.valueOf(puntosactual));
            tv3.setText("Muy bien ganó. Ahora pienso otro numero");
            et1.setText("");
            tv4.setText(String.valueOf(intentos));
            SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferencias.edit();
            editor.putInt("puntos", puntosactual);
            editor.commit();
            numero = 1 + (int) (Math.random() * 10);
        } else {
            if (valor > numero) {
                tv3.setText("Ingreso un numero mayor al que penso la maquina.");
                tv4.setText(String.valueOf(intentos));
            } else {
                tv3.setText("Ingreso un numero menor al que penso la maquina.");
                tv4.setText(String.valueOf(intentos));
            }

        }
    }
    public void nuevo(View v) {
        numero = 1 + (int) (Math.random() * 10);
        tv3.setText("Adivine un numero entre el 1 y el 10");
        intentos=0;
    }
}
