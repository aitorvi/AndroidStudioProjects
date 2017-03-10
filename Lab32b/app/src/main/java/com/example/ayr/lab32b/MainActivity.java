package com.example.ayr.lab32b;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private EditText et2;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
     //   Intent intent= new Intent (this, Condiciones.class );
       //  startActivityForResult(intent,1234);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if (requestCode==1234 && resultCode==RESULT_OK) {
            et2.setText(data.getExtras().getString("resultado"));
        }
    }
    protected void onClick(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condiciones);

        et1=(EditText)findViewById(R.id.et1);

        Bundle bundle = getIntent().getExtras();
        String dato=bundle.getString("respuesta");
        et2.setText(dato);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true; /** true -> el menú ya está visible */
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if  (id == R.id.action_settings) {
           lanzarPreferencias(null);
            return true;
        }
        if (id == R.id. acercaDe) {
           lanzarAcercaDe(null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void lanzarAcercaDe(View view){
        Intent i = new Intent(this, AcercaDeActivity.class);
        startActivity(i);
    }
    public void lanzarPreferencias(View view){
        Intent i = new Intent(this, Preferencias.class);
        startActivity(i);
    }



    public void verificar (View v) {
        Intent i=new Intent(this,Condiciones.class);
        i.putExtra("nombre", et1.getText().toString());
        startActivityForResult(i,1234);
    }
}
