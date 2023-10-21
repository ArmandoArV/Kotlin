package mx.tec.a2doexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import mx.tec.a2doexamen.databinding.ActivityBottomBarBinding

class BottomBar : AppCompatActivity() {
    lateinit var binding: ActivityBottomBarBinding
    lateinit var navController: NavController // Se encarga de manejar los fragmentos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Referencia al NavHostFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.contenedor) as NavHostFragment

        // Optener el nav Controller del NavHostFragment
        navController = navHostFragment.navController

        // Ligar la bottomNav con el controller
        setupWithNavController(binding.bnavBarra, navController)
    }
}