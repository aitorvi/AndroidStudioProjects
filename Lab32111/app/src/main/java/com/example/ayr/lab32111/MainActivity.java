package com.example.ayr.lab32111;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et1);
    }

    public void verificar(View v) {
        String clave=et1.getText().toString();
        if (clave.equals("abc123")) {
            Intent i = new Intent(this, Bienvenido.class);
            startActivity(i);
        }
        else {
            Toast notificacion= Toast.makeText(this,"Clave incorrecta", Toast.LENGTH_LONG);
            notificacion.show();
        }
    }

}

