package mx.tec.customlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.tec.customlayout.adapter.CustomAdapter
import mx.tec.customlayout.databinding.ActivityMainBinding
import mx.tec.customlayout.model.Elemento

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val datos = listOf(
        Elemento(R.drawable.gato, "Gato", "minino"),
        Elemento(R.drawable.perropendejo, "Perro", "Pendejo"),
        Elemento(R.drawable.mapacheuvas, "Mapache", "Pendejo"),
        Elemento(R.drawable.pato, "Pato", "Pendejo"),
    )




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CustomAdapter(this, R.layout.layout_elemento, datos)
        binding.lvLista.adapter = adapter
    }
}