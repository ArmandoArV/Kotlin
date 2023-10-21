/*

    Made by: Armando Arredondo Valle
    Finished: 10/09/2023 | 10:08 PM

*/

package mx.tec.arredondovalle_primerparcial

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import mx.tec.arredondovalle_primerparcial.databinding.ActivityMainBinding
import mx.tec.arredondovalle_primerparcial.model.Ubicacion

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val estados = listOf(
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

        val inputtedData = mutableListOf<String>()


        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, estados)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spnEdo.adapter = adapter


        binding.btnSave.setOnClickListener {
            val nombre = binding.edtLugar.text.toString()
            val descripcion = binding.edtDesc.text.toString()
            val estado = binding.spnEdo.selectedItem.toString()
            val latitud = binding.edtLat.text.toString().toDoubleOrNull()
            val longitud = binding.edtLong.text.toString().toDoubleOrNull()

            if (nombre != "" && descripcion != "" && estado != "" && latitud != null && longitud != null) {
                val ubicacion = Ubicacion(nombre, descripcion, estado, latitud, longitud)
                val intent = Intent(this, Visualizacion::class.java)
                intent.putExtra("ubicacion", ubicacion)
                startActivity(intent)
                finish()
            } else {
                binding.txtResult.text = "Invalid data"
            }
        }


    }
}