package mx.tec.persistencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreference = getSharedPreferences("sharedPreference", MODE_PRIVATE)
        with(sharedPreference.edit()) {
            putString("nombre", "Juan")
            putInt("edad", 20)
            putBoolean("estaCasado", false)
          //  commit()

            sharedPreference.getString("nombre", "No hay nombre")
            // Remove all the data from the shared preference
            clear()
        }
    }
}