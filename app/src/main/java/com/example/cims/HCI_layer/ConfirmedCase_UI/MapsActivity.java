package com.example.cims.HCI_layer.ConfirmedCase_UI;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cims.PD_layer.ConfirmedCase.Place;
import com.example.cims.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.cims.databinding.ActivityMapsBinding;

import java.util.Iterator;

public class MapsActivity extends SupportMapFragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Button btn_loadmark;
    public MapsActivity(){

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getMapAsync(this);
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
        Iterator<Place> itr = ((ConfirmedCaseActivity) getActivity()).getPlaceArrayList().iterator();
        while(itr.hasNext()) {
            Place place = itr.next();
            LatLng marker = new LatLng(place.getLat(), place.getLng());
            mMap.addMarker(new MarkerOptions().position(marker)
                               .title(place.getVisitRecord().getVisitedDate())
                               .snippet(place.getVisitRecord().getPlaceName()+" / "+place.getVisitRecord().getAddress()));
        }
        mMap.setMaxZoomPreference(20);
        mMap.setMinZoomPreference(6.5f);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(36.138642, 127.987679), 6.5f));
    }
}