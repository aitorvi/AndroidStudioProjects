package com.example.aitor.lab43;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Leer extends AppCompatActivity {
    private EditText et1,et2,et3,et4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
    }
        public void consultar(View v) {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                    "personas", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String nom = et1.getText().toString();
            Cursor fila = bd.rawQuery(
                    "select apellido1,telefono from personas where nombre='" + nom +"'", null);

            if (fila.moveToFirst()) {
                et2.setText(fila.getString(0));
                et3.setText(fila.getString(1));
                et4.setText(nom);
                Toast.makeText(this, "Entro",
                        Toast.LENGTH_SHORT).show();

            } else
                Toast.makeText(this, "No existe un artículo con dicho código",
                        Toast.LENGTH_SHORT).show();
            bd.close();
        }
    public void atras(View v){
        finish();
    }
    }

