package com.journaldev.sqlite;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.journaldev.sqlite.R.id.subject_edittext;

public class AddActividadesActivity extends Activity implements OnClickListener {

    private Button addTodoBtn;
    private EditText subjectEditText, et2, et3;
    private RadioButton r1, r2, r3, r4, r5;
    TextView et1;
    EditText date,time;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialogcker;


    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Añadir Tarea");

        setContentView(R.layout.activity_add_record);

        subjectEditText = (EditText) findViewById(subject_edittext);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        r1 = (RadioButton) findViewById(R.id.r1);
        r4 = (RadioButton) findViewById(R.id.r4);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);
        r5 = (RadioButton) findViewById(R.id.r5);
        date = (EditText) findViewById(R.id.date);
        time =  (EditText) findViewById(R.id.time);





        addTodoBtn = (Button) findViewById(R.id.add_record);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_record:

                final String name = subjectEditText.getText().toString();
                String desc = "Hecho";
                String prioridad = "Baja";
                final String fecha = "";
                final String hora = "";


                if (r1.isChecked() == true) {
                    desc = "Pendiente";
                }


                if (r3.isChecked() == true) {
                    prioridad = "Baja";
                }

                if (r5.isChecked() == true) {
                    prioridad = "alta";
                }

                dbManager.insert(name, desc,prioridad,fecha,hora);

                Intent main = new Intent(AddActividadesActivity.this, ListaActividadesActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                break;
                /**dbManager.insert(name, desc, prioridad, fecha, hora);

                Intent main = new Intent(AddActividadesActivity.this, ListaActividadesActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Toast notificacion = Toast.makeText(this, "Ingresado", Toast.LENGTH_LONG);
                notificacion.show();
                startActivity(main);
                break;*/
        }
    }
    public void addFecha(View v) {
        // calender class's instance and get current date , month and year from calender
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        // date picker dialog
        datePickerDialog = new DatePickerDialog(AddActividadesActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        date.setText(dayOfMonth + "/"
                                + (monthOfYear + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();    }

    // abrir TimePicer y añadir hora a text
    public void addHora(View v) {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(AddActividadesActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                time.setText(selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();   }

    public void cancel (View v) {
        finish();
    }
    // devuelve todos los componentes de la activity a su estado original
    public void clear (View v) {
        subjectEditText.setText("");
        //r2.che
        //r4.isSelected();
        time.setText("");
        date.setText("");
    }
}