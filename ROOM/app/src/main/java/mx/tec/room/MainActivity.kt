package mx.tec.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.tec.room.databinding.ActivityMainBinding
import mx.tec.room.model.Persona
import mx.tec.room.utility.AppDatabase
import java.sql.Date

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val db = AppDatabase.getInstance(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSave.setOnClickListener{
            var persona = Persona(
                0,
                binding.edtName.text.toString(),
                binding.edtLast.text.toString(),
                binding.edtAge.text.toString().toInt(),
                Date.valueOf(binding.edtFecha.text.toString())
            )
            Thread{
                db?.personaDao()?.registrarPersona(persona)
            }.start()
        }
        binding.btnVisualizar.setOnClickListener {
            val intent = Intent(this, Visualizar::class.java)
            startActivity(intent)
        }
    }
}