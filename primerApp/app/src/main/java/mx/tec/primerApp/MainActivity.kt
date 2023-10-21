    package mx.tec.primerApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import mx.tec.primerApp.R.id.btnLogin
import mx.tec.primerApp.R.id.edtUser


    class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtUser = findViewById<EditText>(edtUser)
        val btnLogin = findViewById<Button>(btnLogin)

        btnLogin.setOnClickListener {
            val user = edtUser.text.toString()
            Toast.makeText(this, "Bienvenido $user", Toast.LENGTH_LONG).show()
        }
    }
}