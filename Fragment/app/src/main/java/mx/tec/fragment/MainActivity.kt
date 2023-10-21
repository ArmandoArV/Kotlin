package mx.tec.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.tec.fragment.databinding.ActivityMainBinding
import mx.tec.fragment.ui.detalle.Detalle
import mx.tec.fragment.ui.encabezado.Encabezado

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager // Se encarga de manejar los fragmentos
        val fragmentTransaction = fragmentManager.beginTransaction() // Se encarga de las transacciones de los fragmentos

        fragmentTransaction.replace(R.id.encabezado, Encabezado()) // Se agrega el fragmento al contenedor
        fragmentTransaction.replace(R.id.detalle, Detalle()) // Se agrega el fragmento al contenedor

        fragmentTransaction.commit() // Se confirma la transacción
    }
}