package mx.tec.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.tec.fragments.databinding.ActivityMainBinding
import mx.tec.fragments.ui.detail.Detail
import mx.tec.fragments.ui.header.Header

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.Header, Header())
        fragmentTransaction.replace(R.id.Detail, Detail())
        fragmentTransaction.commit()
    }
}