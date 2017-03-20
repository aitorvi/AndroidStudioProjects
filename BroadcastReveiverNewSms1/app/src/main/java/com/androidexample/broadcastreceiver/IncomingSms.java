package com.androidexample.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;


public class IncomingSms extends BroadcastReceiver {
	String hora;
	String fecha;
	String servicio;
	String aviso;
	private EditText et1;
	// Get the object of SmsManager
	final SmsManager sms = SmsManager.getDefault();



	public void onReceive(Context context, Intent intent) {

		// Retrieves a map of extended data from the intent.
		final Bundle bundle = intent.getExtras();

		try {

			if (bundle != null) {

				final Object[] pdusObj = (Object[]) bundle.get("pdus");

				for (int i = 0; i < pdusObj.length; i++) {

					SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
					String phoneNumber = currentMessage.getDisplayOriginatingAddress();

					String senderNum = phoneNumber;
					String message = currentMessage.getDisplayMessageBody();

					//Si el numero remitente coincide con el del proveedor se agrega a la primera tabla de la base de datos
				//if (senderNum.equals(123)) {
					fecha = message.substring(19, 30);
					hora = message.substring(36, 41);
					servicio = message.substring(71, 83);
					aviso = message.substring(message.length() - 3, message.length());
					AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "mensajes", null, 1);
				//}

					SQLiteDatabase bd = admin.getWritableDatabase();

						ContentValues registro = new ContentValues();

						registro.put("fecha", fecha);
						registro.put("hora", hora);
						registro.put("servicio", servicio);
						registro.put("aviso", aviso);
						bd.close();




					//Log.i("SmsReceiver", "fecha: " + hora + "; message: " + fecha + "; message: " + servicio + "; message: " + aviso);
					int duration = Toast.LENGTH_LONG;
					Toast toast = Toast.makeText(context, "fecha: " + fecha + ", hora: " + hora +", hora: " + servicio +", aviso: " + aviso, duration);
					toast.show();

				} // end for loop
			} // bundle is null

		} catch (Exception e) {
			Log.e("SmsReceiver", "Exception smsReceiver" + e);

		}

	}






	}

	
	
