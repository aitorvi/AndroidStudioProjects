package com.example.aitor.lab31;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // The activity is being created.
        Toast notificacion = Toast.makeText(this, "OnCreate.", Toast.LENGTH_LONG);
        notificacion.show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // The activity is about to become visible.
        Toast notificacion = Toast.makeText(this, "OnRestart.", Toast.LENGTH_LONG);
        notificacion.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
        Toast notificacion = Toast.makeText(this, "OnStart.", Toast.LENGTH_LONG);
        notificacion.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
        Toast notificacion = Toast.makeText(this, "OnResume.", Toast.LENGTH_LONG);
        notificacion.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
        Toast notificacion = Toast.makeText(this, "OnPause.", Toast.LENGTH_LONG);
        notificacion.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
        Toast notificacion = Toast.makeText(this, "OnStop.", Toast.LENGTH_LONG);
        notificacion.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
        Toast notificacion = Toast.makeText(this, "OnDestroy.", Toast.LENGTH_LONG);
        notificacion.show();
    }

    public void finalizar() {
        System.exit(0);

    }
}