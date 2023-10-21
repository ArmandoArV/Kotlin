package mx.tec.apis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import mx.tec.apis.databinding.ActivityMainBinding
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        var queue = Volley.newRequestQueue(this)
        var url = "https://jsonplaceholder.typicode.com/users"
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var lista = mutableListOf<String>()
        val listener = Response.Listener<JSONArray> { response ->
            Log.e(
                "RESTLIBS", response.toString()
            )
            for (i in 0..<response.length()) {
                lista.add(response.getJSONObject(i).getString("name"))
            }
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
            binding.lvLista.adapter = adapter

        }
        val error = Response.ErrorListener { error -> Log.e("RESTLIBS", error.message!!) }
        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null, listener, error)


        queue.add(jsonArrayRequest)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.addItem ->{
                val intent = Intent(this@MainActivity, Formulario::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}