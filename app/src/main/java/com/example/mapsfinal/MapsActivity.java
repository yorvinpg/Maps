package com.example.mapsfinal;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Sydney and move the camera
        LatLng autonoma = new LatLng(-12.195483, -76.9719602);
        LatLng libreria = new LatLng(-12.1950265, -76.9716449);
        LatLng jugos    = new LatLng(-12.1963635, -76.9721322);
        mMap.addMarker(new MarkerOptions().position(autonoma).title("Universidad Autonoma"));
        mMap.addMarker(new MarkerOptions().position(libreria).title("Libreria"));
        mMap.addMarker(new MarkerOptions().position(jugos).title("Jugos"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(autonoma));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.getTitle().equals("Jugos")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.google.com/maps/search/Jugos/@-12.1947386,-76.9710182,17z"));
                    startActivity(intent);
                }
                if (marker.getTitle().equals("Libreria")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.google.com/maps/search/Jugos/@-12.1947386,-76.9710182,17z"));
                    startActivity(intent);
                }
                return false;
            }
        });
    }


}
