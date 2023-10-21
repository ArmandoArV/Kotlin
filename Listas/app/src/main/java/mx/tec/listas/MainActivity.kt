package mx.tec.listas

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import mx.tec.listas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val lista = listOf("Camila","Armando","Efraín","Axel Rojo","Axel Gris")
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1,lista)
        binding.lvLista.adapter = adapter
        binding.spLista.adapter = adapter

        binding.btnShow.setOnClickListener{
            Toast.makeText(this, "Seleccionaste ${binding.spLista.selectedItem}", Toast.LENGTH_SHORT).show()
        }

        binding.lvLista.setOnItemClickListener{ parent, view, position, id ->
            // Toast.makeText(this, "Seleccionaste ${lista[position]}", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Seleccionaste ${(view as TextView).text}", Toast.LENGTH_SHORT).show()
        }


    }
}