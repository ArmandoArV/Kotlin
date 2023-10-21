package mx.tec.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import mx.tec.recycler.adapter.CustomAdapter
import mx.tec.recycler.databinding.ActivityMainBinding
import mx.tec.recycler.model.Elemento

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datos = listOf(
            Elemento("Mapache uno", R.drawable.mapachecaracteristicas),
            Elemento("Mapache dos", R.drawable.mapachedecozumel),
            Elemento("Mapache tres", R.drawable.mapp),
            Elemento("Mapache cuatro", R.drawable.unmapache)
        )

        val adaptor = CustomAdapter(this@MainActivity, R.layout.layout_elemento, datos)

           binding.repeater.apply {
                layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false);
                setHasFixedSize(true)
                adapter = adaptor;
            }
    }
}