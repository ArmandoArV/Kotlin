package mx.tec.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import mx.tec.fragment.databinding.ActivityBottomNavBinding
import mx.tec.fragment.ui.encabezado.Encabezado

class BottomNav : AppCompatActivity() {
    lateinit var binding: ActivityBottomNavBinding
    lateinit var navController: NavController // Se encarga de manejar los fragmentos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Referencia al NavHostFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.contenedor) as NavHostFragment

        // Optener el nav Controller del NavHostFragment
        navController = navHostFragment.navController

        // Ligar la bottomNav con el controller
        setupWithNavController(binding.bnavBarra, navController)

        /*
        val fragmentManager = supportFragmentManager // Se encarga de manejar los fragmentos
        //val fragmentTransaction = fragmentManager.beginTransaction() // Se encarga de las transacciones de los fragmentos

    binding.bnavBarra.setOnItemSelectedListener {
        when(it.itemId){
            R.id.mnuAdd -> {
                fragmentManager.beginTransaction().apply {
                    replace(R.id.contenedor, Encabezado()) // Se agrega el fragmento al contenedor
                    commit() // Se confirma la transacción
                }
            }
            R.id.mnuSearch -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            }
            R.id.mnuSetting -> {
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show()
            }
            else -> false
        }
        true
    }
         */
    }
}