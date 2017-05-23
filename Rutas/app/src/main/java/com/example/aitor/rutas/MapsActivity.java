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
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;
import static com.example.aitor.rutas.R.id.map;
import static java.lang.Double.parseDouble;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public TextView mapaRecorrido;
    public TextView mapaDificultad;
    public TextView mapaDescripcion;
    public String kmlx;
    public String kmly;
    public List<LatLng> camino = new ArrayList<>();



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
        kmlx=bundle.getString("kmlx");
        kmly=bundle.getString("kmly");
//Se rellenan los edittext
        mapaRecorrido.setText(recorrido);
        mapaDificultad.setText(dificultad);
        mapaDescripcion.setText(descripcion);

        //



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

        String [] listax = kmlx.split("@");
        String [] listay=kmly.split("@");



        for (int i=0; i<listax.length; i++) {
            double x=Double.parseDouble(listax[i]);
            double y=Double.parseDouble(listay[i]);


        camino.add(i, new LatLng(x, y));
//Añade marcador inicio
           if (i==0){
               mMap.addMarker(new MarkerOptions()
                       .position(new LatLng(x, y))
                       .title("Incio"));

               // Se situa el foco en el inicio con zoom 12
               mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(x, y),11));
           }
           //Añadre marcador final
           if (i==listax.length-1){
               mMap.addMarker(new MarkerOptions()

                       .position(new LatLng(x, y))
                       .title("Final"));


           }


        }

// lee la lista de posiciones y la agrega a la polilinea

        mMap.addPolyline(new PolylineOptions()
                .color(Color.YELLOW)
                .clickable(true)
                .addAll(camino));




        mMap.getCameraPosition();




    }



}




