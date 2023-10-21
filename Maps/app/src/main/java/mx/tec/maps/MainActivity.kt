package mx.tec.maps

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import mx.tec.maps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LocationListener {
    lateinit var binding: ActivityMainBinding
    lateinit var mapa: GoogleMap
    lateinit var locationManager: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        var mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment;

        mapFragment.getMapAsync{ googleMaps ->
            mapa = googleMaps
            /*mapa.isMyLocationEnabled = true

            var ubi: LatLng = LatLng(-34.0, 151.0)
            mapa.addMarker(MarkerOptions().position(ubi).icon( BitmapDescriptorFactory.fromResource(R.drawable.img)))

            mapa.moveCamera(CameraUpdateFactory.newLatLng(ubi))*/
        }


    }

    override fun onLocationChanged(location: Location) {
        var ubi: LatLng = LatLng(location.latitude, location.longitude)
        mapa.addMarker(
            MarkerOptions().position(ubi).icon(BitmapDescriptorFactory.fromResource(R.drawable.img))
        )

        mapa.moveCamera(CameraUpdateFactory.newLatLng(ubi))
    }
}