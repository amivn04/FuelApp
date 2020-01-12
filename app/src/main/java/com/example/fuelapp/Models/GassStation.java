package com.example.fuelapp.Models;

import com.google.android.gms.maps.model.LatLng;

public class GassStation {
    private long id;
    private String name;
    private String address;
    private LatLng location;

    public GassStation(long id, String name, String address, LatLng location) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public LatLng getLocation() {
        return location;
    }
}
