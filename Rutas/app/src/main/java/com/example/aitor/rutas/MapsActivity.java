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

import java.util.List;

import static android.R.attr.path;
import static android.R.attr.strokeColor;
import static com.example.aitor.rutas.R.id.large_icon_uri;
import static com.example.aitor.rutas.R.id.map;
import static java.security.AccessController.getContext;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public TextView mapaRecorrido;
    public TextView mapaDificultad;
    public TextView mapaKml;
    public TextView mapaDescripcion;
    public String kmlx;
    public String kmly;
    public List<LatLng> prueba;
    public String kml;
    double pointY[]={105.45526,105.57364,105.53505,105.45523,105.51962,105.77320};
    double pointX[]={9.99222,9.88347,9.84184,9.77197,9.55501,9.67768,9};

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
        // Add a marker in Sydney and move the camera
        //kml.substring()
        LatLng inicio = new LatLng(28.61, -13.92);
        mMap.addMarker(new MarkerOptions().position(inicio).title("Fuerteventura"));
        String [] listax = kmlx.split("|");
        String [] listay=kmly.split("|");

          Double x= Double.parseDouble(listax[0]) ;
        Double y =Double.parseDouble(listay[0]);

        prueba.add(0,new LatLng(x,y));

         mMap.moveCamera(CameraUpdateFactory.newLatLng(inicio));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(inicio, 8));
        mMap.addPolyline(new PolylineOptions().addAll(prueba));

        // .add(new LatLng(),new LatLng(29,13.62)


        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-33.8256, 151.2395), 10));




    }



    }


