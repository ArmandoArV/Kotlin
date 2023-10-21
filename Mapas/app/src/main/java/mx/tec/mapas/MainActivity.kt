package mx.tec.mapas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.tec.mapas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

// AIzaSyDsrQRPi0yWYvnvEtCmJXUtpb75bmfAjHg