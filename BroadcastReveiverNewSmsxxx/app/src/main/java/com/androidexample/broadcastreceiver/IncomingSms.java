package com.androidexample.broadcastreceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import android.provider.CalendarContract;
import android.os.Bundle;
import android.view.View;
import java.util.Calendar;
import android.provider.CalendarContract.Events;


public class IncomingSms extends BroadcastReceiver {
	private EditText et1;
	String hora;
	String fecha;
	String servicio;
	int codigo;
	int horas;
	int minutos;
	int dia;
	int mes;
	int año;

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
					fecha = message.substring(19, 29);

					hora = message.substring(36, 41);
					servicio = message.substring(71, 83);
					codigo = Integer.parseInt(message.substring(message.length() - 3, message.length()));
					dia = Integer.parseInt(message.substring(19, 20));
					mes = Integer.parseInt(message.substring(22, 23));
					año = Integer.parseInt(message.substring(25, 28));
					horas = Integer.parseInt(message.substring(36, 38));
					minutos = Integer.parseInt(message.substring(39, 41));

						// Crear evento en calendario
						Calendar cal = Calendar.getInstance();

						cal.set(Calendar.DAY_OF_MONTH, 29);
						cal.set(Calendar.MONTH, 4);
						cal.set(Calendar.YEAR, 2013);

						cal.set(Calendar.HOUR_OF_DAY, 22);
						cal.set(Calendar.MINUTE, 45);

						Intent intent2 = new Intent(Intent.ACTION_EDIT);
						intent2.setType("vnd.android.cursor.item/event");

						intent2.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, cal.getTimeInMillis());
						intent2.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, cal.getTimeInMillis()+60*60*1000);

						intent2.putExtra(Events.ALL_DAY, false);
						intent2.putExtra(Events.RRULE , "FREQ=DAILY");
						intent2.putExtra(Events.TITLE, "Título de vuestro evento");
						intent2.putExtra(Events.DESCRIPTION, "Descripción");
						intent2.putExtra(Events.EVENT_LOCATION,"Calle ....");






					//Insertar registro en BBDD
					AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "avisos", null, 1);
					SQLiteDatabase bd = admin.getWritableDatabase();
					ContentValues registro = new ContentValues();
					registro.put("fecha", fecha);
					registro.put("hora", hora);
					registro.put("servicio", servicio);
					registro.put("codigo", codigo);
					bd.insert("avisos", null, registro);
					bd.close();

					//Codigo 123 no comer doce horas antes
				/**	if (codigo==123){
						AdminSQLiteOpenHelper admin2 = new AdminSQLiteOpenHelper(context, "recomendaciones", null, 1);
						SQLiteDatabase bd2 = admin.getWritableDatabase();
						ContentValues registro2 = new ContentValues();
						registro2.put("fecha", fecha);
						registro2.put("hora", hora);
						registro2.put("servicio", servicio);
						registro2.put("codigo", codigo);
						bd2.insert("recomendaciones", null, registro);
						bd2.close();



					}*/

					//    Log.i("SmsReceiver", "senderNum: "+ senderNum + "; message: " + message);

					int duration = Toast.LENGTH_LONG;
					Toast toast = Toast.makeText(context, "hora:" + message.substring(36, 38) + ", minuto: " + message.substring(39, 41) + ", año: " + message.substring(25, 29) + ", codigo: " + codigo, duration);
					toast.show();


				} // end for loop
				// bundle is null
			}
		}
		 catch (Exception e) {
			Log.e("SmsReceiver", "Exception smsReceiver" + e);

		}
	}






}


	
	
