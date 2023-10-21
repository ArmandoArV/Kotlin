package mx.tec.arredondovalle_ep2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.tec.arredondovalle_ep2.databinding.ActivityMainBinding
import mx.tec.arredondovalle_ep2.model.Reminder
import mx.tec.arredondovalle_ep2.ui.New.New
import mx.tec.arredondovalle_ep2.ui.detalle.Detalle
import mx.tec.arredondovalle_ep2.utility.AppDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.detalle, Detalle())
    }
}