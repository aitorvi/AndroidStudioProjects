package com.example.aitor.rutas;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import static com.example.aitor.rutas.R.id.map;
import static java.security.AccessController.getContext;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public TextView mapaRecorrido;
    public TextView mapaDificultad;
    public TextView mapaKml;
    public TextView mapaDescripcion;
    public String kml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);

        //Se recogen los datos de la anterior activity (hay que cambiarlo a un objeto)


        mapaRecorrido = (TextView) findViewById(R.id.tvrecorrido);
        mapaDificultad = (TextView) findViewById(R.id.tvdificultad);
        mapaDescripcion = (TextView) findViewById(R.id.tvdescripcion);



        Bundle bundle = getIntent().getExtras();
        String recorrido=bundle.getString("recorrido");
        String dificultad=bundle.getString("dificultad");
       String descripcion=bundle.getString("descripcion");
        kml=bundle.getString("kml");

//Se rellenan los edittext
        mapaRecorrido.setText(recorrido);
        mapaDificultad.setText(dificultad);
        mapaDescripcion.setText(descripcion);

    }





    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        // Add a marker in Sydney and move the camera
        //kml.substring()
        LatLng inicio = new LatLng(28.61, -13.92);
        mMap.addMarker(new MarkerOptions().position(inicio).title("Fuerteventura"));


        //mMap.moveCamera(CameraUpdateFactory.newLatLng(fuerteventura));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(inicio, 8));
        mMap.addPolyline(new PolylineOptions()
                        .color(Color.YELLOW)
                .add(new LatLng(28.61,28.62),new LatLng(28.61,28.62))
                .clickable(true)


        );




       // mMap.addPolyline(loadGeoJson(
         //       'https://storage.googleapis.com/mapsdevsite/json/google.json'));

    }
}
