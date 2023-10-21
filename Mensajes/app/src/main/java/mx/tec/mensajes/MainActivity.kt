package mx.tec.mensajes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import mx.tec.mensajes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Lecture of the XML for creating the control references to a view or view group
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToast.setOnClickListener {
            Toast.makeText(
                this, "Bienvenido ${binding.edtMensaje.text}", Toast.LENGTH_LONG
            ).show()
        }

        binding.btnAlert.setOnClickListener {
            var builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Alerta")
                .setMessage("Contenido")
                .setPositiveButton("Ok") { dialog, button ->
                  dialog.dismiss()
                }
                .setNegativeButton("Cancelar") { dialog, button ->
                    dialog.dismiss()
                }
                .show()
        }

        binding.btnLog.setOnClickListener {
            Log.i("ETIQUETA", binding.edtMensaje.text.toString())

        }
        // setContentView(R.layout.activity_main)

        // val constante, var variables
        // val btnToast = findViewById<Button>(R.id.btnToast)

        // Binding

    }
}