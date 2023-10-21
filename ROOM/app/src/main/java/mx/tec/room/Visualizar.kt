package mx.tec.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import mx.tec.room.databinding.ActivityVisualizarBinding
import mx.tec.room.utility.AppDatabase

class Visualizar : AppCompatActivity() {
    private lateinit var binding: ActivityVisualizarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val db = AppDatabase.getInstance(this)

        super.onCreate(savedInstanceState)
        binding = ActivityVisualizarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Thread{
        val list = db.personaDao().getAll()

        val adapter = ArrayAdapter(this@Visualizar, android.R.layout.simple_list_item_1, list)
        binding.lvlista.adapter = adapter
        }.start()
    }
}