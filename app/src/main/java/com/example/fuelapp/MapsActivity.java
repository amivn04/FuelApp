package com.example.fuelapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import com.example.fuelapp.Models.GassStation;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import static com.example.fuelapp.Helpers.GassStationDB.getGassStations;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback,
        GoogleMap.OnInfoWindowClickListener {

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



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        List<GassStation> stations = getGassStations();

        for (GassStation station : stations) {
            Marker marker = mMap.addMarker(new MarkerOptions().position(station.getLocation())
            .title(station.getName()).snippet(station.getAddress()));
            marker.setTag(station.getId());
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(stations.get(0).getLocation()));

        mMap.setOnInfoWindowClickListener(this);
    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onInfoWindowClick(Marker marker) {

        Long id = (Long) marker.getTag();
        Intent intent = new Intent(MapsActivity.this, GassStationActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);



    }
}
