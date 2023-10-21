/*

    Made by: Armando Arredondo Valle
    Finished: 10/09/2023 | 10:08 PM

*/


package mx.tec.arredondovalle_primerparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import mx.tec.arredondovalle_primerparcial.adapter.CustomAdapter
import mx.tec.arredondovalle_primerparcial.databinding.ActivityVisualizacionBinding
import mx.tec.arredondovalle_primerparcial.model.Ubicacion

class Visualizacion : AppCompatActivity() {
    lateinit var binding: ActivityVisualizacionBinding
    var selectedUbicacion: Ubicacion? = null // Declare selectedUbicacion as a class-level variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVisualizacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val estados = mutableListOf(
            "Aguascalientes",
            "Baja California",
            "Baja California Sur",
            "Campeche",
            "Chiapas",
            "Chihuahua",
            "Ciudad de México",
            "Coahuila",
            "Colima",
            "Durango",
            "Estado de México",
            "Guanajuato",
            "Guerrero",
            "Hidalgo",
            "Jalisco",
            "Michoacán",
            "Morelos",
            "Nayarit",
            "Nuevo León",
            "Oaxaca",
            "Puebla",
            "Querétaro",
            "Quintana Roo",
            "San Luis Potosí",
            "Sinaloa",
            "Sonora",
            "Tabasco",
            "Tamaulipas",
            "Tlaxcala",
            "Veracruz",
            "Yucatán",
            "Zacatecas"
        )

        val ubicacion = intent.getParcelableExtra<Ubicacion>("ubicacion")
        val datos = intent.getParcelableArrayListExtra<Ubicacion>("datos")?.toMutableList() ?: mutableListOf()
        ubicacion?.let { datos.add(it) }
        val adapter = CustomAdapter(this, R.layout.layout_elemento, datos)
        val spinner = findViewById<Spinner>(R.id.spnEstados)
        val estadosAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, estados)
        estadosAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = estadosAdapter

        binding.repeater.apply {
            layoutManager =
                LinearLayoutManager(this@Visualizacion, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            this.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                val selectedEstado = parent?.getItemAtPosition(position).toString()
                val filteredData = datos.filter { ubicacion -> ubicacion.estado == selectedEstado }
                val filteredAdapter =
                    CustomAdapter(this@Visualizacion, R.layout.layout_elemento,
                        filteredData.toMutableList()
                    )
                binding.repeater.adapter = filteredAdapter
                selectedUbicacion = if (filteredData.isNotEmpty()) filteredData[0] else null
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                binding.repeater.adapter = adapter
            }
        }



        adapter.setOnItemClickListener(object : CustomAdapter.OnItemClickListener {
            override fun onItemClick(ubicacion: Ubicacion) {
                showOptionsDialog(ubicacion)
            }

            override fun onItemDelete(ubicacion: Ubicacion) {
                // Handle the long click event (if needed)
                showDeleteConfirmationDialog(ubicacion)
            }
        })


    }

    private fun showOptionsDialog(ubicacion: Ubicacion) {
        val options = arrayOf("Ver en Mapa", "Eliminar")

        AlertDialog.Builder(this)
            .setTitle("Opciones")
            .setItems(options) { _, which ->
                when (which) {
                    0 -> {
                        navigateToMapView(ubicacion)
                    }

                    1 -> {
                        //listener?.onItemDelete(ubicacion)
                    }
                }
            }
            .show()
    }

    private fun showDeleteConfirmationDialog(ubicacion: Ubicacion) {
        AlertDialog.Builder(this).setTitle("Eliminar Ubicación")
            .setMessage("¿Estás seguro de que deseas eliminar esta ubicación?")
            .setPositiveButton("Sí") { _, _ ->
            }.setNegativeButton("No", null).show()
    }

    private fun navigateToMapView(ubicacion: Ubicacion) {
        val intent = Intent(this@Visualizacion, MapActivity::class.java)
        intent.putExtra("latitud", ubicacion.latitud)
        intent.putExtra("longitud", ubicacion.longitud)
        startActivity(intent)
    }

}

