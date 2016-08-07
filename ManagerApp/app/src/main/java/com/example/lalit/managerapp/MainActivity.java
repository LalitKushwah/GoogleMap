package com.example.lalit.managerapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    double lati=22.8119715,longi=75.9347113;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(lati,longi);
        LatLng talawlai =new LatLng((lati+0.05),(longi+0.05));
        Marker customer= mMap.addMarker(new MarkerOptions().position(sydney)
                .title("Your Location"));
        Marker laundary= mMap.addMarker(new MarkerOptions().position(talawlai).title("Employee"));
        laundary.setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        laundary.showInfoWindow();

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lati, longi), 11.0f));
        Circle circle = mMap.addCircle(new CircleOptions()
                .center(new LatLng(lati, longi))
                .radius(10000)
                .strokeColor(Color.GRAY)
                .fillColor(Color.WHITE)); //Inside color

    }

}