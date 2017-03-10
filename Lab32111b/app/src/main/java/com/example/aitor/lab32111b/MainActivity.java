package com.example.aitor.lab32111b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et1);

    }

    public void verificar(View v) {
        String modelo="abc123";
        String clave=et2.getText().toString();
        if (clave==modelo) {
            Toast notificacion= Toast.makeText(this,"La clave es distinta", Toast.LENGTH_LONG);
            notificacion.show();
        }
        else {
            Toast notificacion= Toast.makeText(this,"Else", Toast.LENGTH_LONG);
            notificacion.show();


        }
    }
}
