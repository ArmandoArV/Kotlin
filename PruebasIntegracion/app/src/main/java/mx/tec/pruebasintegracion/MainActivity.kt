import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log  // Import Log
import mx.tec.pruebasintegracion.Inbox
import mx.tec.pruebasintegracion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hash map of email and password
        val emailPasswordMap = mapOf(
            "test@gmail.com" to "123456",
        )

        binding.btnLogin.setOnClickListener {
            val email = binding.edtMail.text.toString()
            val password = binding.edtPassword.text.toString()
            Log.d("MainActivity", "Email: $email, Password: $password") // Add a log statement to check the entered email and password

            if (emailPasswordMap.containsKey(email)) {
                if (emailPasswordMap[email] == password) {
                    binding.txtResult.text = "Login successful"
                    Log.d("MainActivity", "Login successful") // Add a log statement for a successful login
                    val intent = Intent(this, Inbox::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    binding.txtResult.text = "Incorrect password"
                    Log.d("MainActivity", "Incorrect password") // Add a log statement for an incorrect password
                }
            } else {
                binding.txtResult.text = "Email not found"
                Log.d("MainActivity", "Email not found") // Add a log statement for an email not found
            }
        }
    }
}
