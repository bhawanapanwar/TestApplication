package com.example.bhawanap.testapplication.MapModule

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.bhawanap.testapplication.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    lateinit var LATlONG:LatLng

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val lat= java.lang.Double.parseDouble(intent.getStringExtra("lat"))
        val long=java.lang.Double.parseDouble(intent.getStringExtra("long"))

        LATlONG=LatLng(lat, long)

        val mapFragment : SupportMapFragment? =
                supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment

        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap ?: return

        with(googleMap) {

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LATlONG, 16f))

            googleMap.addMarker(MarkerOptions().position(LATlONG))
        }
    }

}