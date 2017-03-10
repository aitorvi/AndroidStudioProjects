package com.example.aitor.lab44;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.CallLog;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView salida = (TextView) findViewById(R.id.salida);
        Uri llamadas = Uri.parse("content://sms");
        Cursor c = managedQuery(llamadas, null, null, null, null);
        while (c.moveToNext()) {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                    "sms", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String cue = c.getString(c.getColumnIndex(Telephony.Sms.BODY));
            Integer rem = c.getColumnIndex(Telephony.Sms.Inbox.ADDRESS);
            ContentValues registro = new ContentValues();
            registro.put("cuerpo", cue);
            registro.put("remitente", rem);

            bd.insert("sms", null, registro);

            salida.append("\n"

                    + c.getString(c.getColumnIndex(Telephony.Sms.BODY)) + ") "
                   + c.getString(c.getColumnIndex(Telephony.Sms.ADDRESS)));
        }
    }

    public void verLeer(View view) {
        Intent i = new Intent(this, Leer.class);
        startActivity(i);
    }
}
