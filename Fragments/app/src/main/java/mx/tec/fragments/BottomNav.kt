package mx.tec.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import mx.tec.fragments.databinding.ActivityBottomNavBinding
import mx.tec.fragments.ui.header.Header

class BottomNav : AppCompatActivity() {
    lateinit var binding: ActivityBottomNavBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        var fragmentTransaction : FragmentTransaction? = null

        binding.bnav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.mnuFav ->{
                    fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction?.replace(R.id.contenedor, Header())
                    fragmentTransaction?.commit()
                    true
                }

                else -> {
                    false}
            }
        }
    }
}