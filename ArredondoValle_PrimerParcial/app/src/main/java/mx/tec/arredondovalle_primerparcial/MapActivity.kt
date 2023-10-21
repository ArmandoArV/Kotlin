/*

    Made by: Armando Arredondo Valle
    Finished: 10/09/2023 | 10:08 PM

*/

package mx.tec.arredondovalle_primerparcial

import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import mx.tec.arredondovalle_primerparcial.databinding.ActivityMapBinding

class MapActivity : AppCompatActivity() {
    lateinit var binding : ActivityMapBinding
    lateinit var mapa: GoogleMap
    lateinit var locationManager: LocationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnBack = binding.btnBack

        val latitud = intent.getDoubleExtra("latitud", 0.0)
        val longitud = intent.getDoubleExtra("longitud", 0.0)

        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        var mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment;
        Log.d("MapActivity", "Latitude: $latitud, Longitude: $longitud")
        mapFragment.getMapAsync { googleMap ->
            mapa = googleMap
            // mapa.isMyLocationEnabled = true

            var ubi: LatLng = LatLng(latitud, longitud)
            mapa.addMarker(MarkerOptions().position(ubi))

            mapa.moveCamera(CameraUpdateFactory.newLatLng(ubi))
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}