package com.example.aitor.lab43;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Crear extends AppCompatActivity {
    private EditText et1,et2,et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
    }

    public void crear(View v) {
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
        bd.insert("personas", null, registro);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        Toast.makeText(this, "Se cargaron los datos del artículo",
                Toast.LENGTH_SHORT).show();
    }
    public void atras(View v){
        finish();
    }
}
