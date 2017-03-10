package com.example.aitor.lab44;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Leer extends AppCompatActivity {
    private EditText et1, et2, et3, et4, et8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer);
        et1 = (EditText) findViewById(R.id.et1);

        et8 = (EditText) findViewById(R.id.et8);
    }
    public void consultar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "sms", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor c = bd.rawQuery("SELECT cuerpo, remitente FROM sms", null);


        //Recorremos los resultados para mostrarlos en pantalla
        et8.setText("");
        if (c.moveToFirst())

        {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String cod = c.getString(0);
                String nom = c.getString(1);

                et8.append(" " + cod + " - " + nom + "\n");
            } while (c.moveToNext());
        }

    }
    public void borrartodos(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "sms", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod= "*.*";
        int cant = bd.delete("sms", "remitente='" + cod +"'", null);
        Toast.makeText(this, "Pasa",
                Toast.LENGTH_SHORT).show();
        bd.close();

        if (cant == 1)
            Toast.makeText(this, "Se borraron todos",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe un artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
    }
}

