/*
Created by Helm  17/01/2017.
*/


package net.andapps.nearby.ui.shops.pages.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ShopsMapFragment : SupportMapFragment() ,ShopsMapView, OnMapReadyCallback {

    private val TIENDEO = LatLng(41.380968, 2.185584)


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view  =  super.onCreateView(inflater, container, savedInstanceState)
        getMapAsync(this)
        return view
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val map = googleMap
        map.addMarker(MarkerOptions().position(TIENDEO).title("Tiendeo Office"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(TIENDEO, 16f))
    }

}
