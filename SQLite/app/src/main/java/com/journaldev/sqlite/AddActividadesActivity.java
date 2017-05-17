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





        addTodoBtn = (Button) findViewById(R.id.add_record);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);

    }




}