package mx.tec.pruebasintegracion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log  // Import Log
import mx.tec.pruebasintegracion.adapter.CustomAdapter
import mx.tec.pruebasintegracion.databinding.ActivityInboxBinding
import mx.tec.pruebasintegracion.model.Usuario

class Inbox : AppCompatActivity() {
    lateinit var binding: ActivityInboxBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInboxBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mails = listOf(
            Usuario("John", "Prueba"),
            // Add more Usuario objects if needed
        )

        val recyclerView: RecyclerView = binding.recyclerView  // Assuming you have a RecyclerView in your layout with the id "recyclerView"
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Create an instance of your custom adapter and set it to the RecyclerView
        val adapter = CustomAdapter(this, R.layout.activity_inbox, mails)
        recyclerView.adapter = adapter

        // Add debugging statements to check variables and execution flow
        Log.d("InboxActivity", "Activity created")
        Log.d("InboxActivity", "Number of mails: ${mails.size}")
    }
}
