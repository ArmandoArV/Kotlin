package mx.tec.apis

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import mx.tec.apis.databinding.ActivityFormulario2Binding
import mx.tec.apis.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONObject

class Formulario : AppCompatActivity() {
    lateinit var binding: ActivityFormulario2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormulario2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            var queue = Volley.newRequestQueue(this)
            var url = "https://jsonplaceholder.typicode.com/users"
            var lista = mutableListOf<String>()
            val listener = Response.Listener<JSONObject> { response ->
                Log.e(
                    "RESTLIBS", response.toString()
                )
            }
            val error = Response.ErrorListener { error -> Log.e("RESTLIBS", error.message!!) }
            val body = JSONObject()
            body.put("name", binding.edtName.text.toString())
            body.put("username", binding.edtUsername.text.toString())
            body.put("email", binding.edtEmail.text.toString())
            body.put("phone", binding.edtPhone.text.toString())
            body.put("website", binding.edtWebsite.text.toString())
            val jsonArrayRequest = JsonObjectRequest(Request.Method.POST, url, body, listener, error)


            queue.add(jsonArrayRequest)
        }
    }
}