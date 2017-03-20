package com.androidexample.broadcastreceiver;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;


public class BroadcastNewSms extends Activity {
    private EditText et1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
	}
    public void consultarTodos(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "avisos", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor c = bd.rawQuery("SELECT fecha,hora, servicio FROM avisos", null);


        //Recorremos los resultados para mostrarlos en pantalla

        if (c.moveToFirst())

        {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String fec = c.getString(0);
                String hor = c.getString(1);
                String ser = c.getString(2);

                et1.append(" " + fec + " - " + hor +" - " + ser +  "\n");
            } while (c.moveToNext());
        }

    }
    public void consultarPasadas(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "avisos", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor c = bd.rawQuery("SELECT fecha,hora, servicio FROM avisos where fecha", null);


        //Recorremos los resultados para mostrarlos en pantalla

        if (c.moveToFirst())

        {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String fec = c.getString(0);
                String hor = c.getString(1);
                String ser = c.getString(2);

                et1.append(" " + fec + " - " + hor +" - " + ser +  "\n");
            } while (c.moveToNext());
        }

    }
    public void consultarFuturos(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "avisos", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor c = bd.rawQuery("SELECT fecha,hora, servicio FROM avisos", null);


        //Recorremos los resultados para mostrarlos en pantalla

        if (c.moveToFirst())

        {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String fec = c.getString(0);
                String hor = c.getString(1);
                String ser = c.getString(2);

                et1.append(" " + fec + " - " + hor +" - " + ser +  "\n");
            } while (c.moveToNext());
        }

    }
}
