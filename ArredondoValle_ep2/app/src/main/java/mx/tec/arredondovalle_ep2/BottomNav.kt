package mx.tec.arredondovalle_ep2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import mx.tec.arredondovalle_ep2.databinding.ActivityBottomNavBinding

class BottomNav : AppCompatActivity() {
    lateinit var binding: ActivityBottomNavBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.contenedor) as NavHostFragment

        navController = navHostFragment.navController
        setupWithNavController(binding.bnavBarra, navController)
    }
}