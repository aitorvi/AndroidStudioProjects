package com.example.aitor.lab43;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Actualizar extends AppCompatActivity {
    private EditText et1,et2,et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
    }
    public void modificar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "personas", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nom = et1.getText().toString();
        String ape = et2.getText().toString();
        String num = et3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("nombre", nom);
        registro.put("apellido1", ape);
        registro.put("telefono", num);
        int cant = bd.update("personas", registro, "nombre='" + nom +"'", null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(this, "no existe un artículo con el código ingresado",
                    Toast.LENGTH_SHORT).show();
    }
    public void atras(View v){
        finish();
    }
}

