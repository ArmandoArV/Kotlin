package mx.tec.a2doexamen.ui.SyncBD

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import mx.tec.a2doexamen.R
import mx.tec.a2doexamen.model.Recordatorio
import mx.tec.a2doexamen.utility.AppDatabase
import org.json.JSONArray
import org.json.JSONObject

class SyncDb : Fragment() {
override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    super.onCreateView(inflater, container, savedInstanceState)
    val view = inflater.inflate(R.layout.fragment_sync_db, container, false)

    val db = AppDatabase.getInstance(this.requireContext()) // Inicializar base de datos

    val url = "http://laventana-env-1.eba-4xgdujcc.us-east-1.elasticbeanstalk.com/recordatorios"

    // Al hacer click en el boton, se ejecuta la peticion y se guardan los datos en la base de datos remota desde la local
    val btnSync = view.findViewById<View>(R.id.btnSync)



    btnSync.setOnClickListener{
        postVolley(url, db)
    }

    return view
    }

    fun postVolley(url: String, db: AppDatabase){
        /*
        {
        "nombre_recordatorio": "Recordatorio 1",
        "info_recordatorio": "Info 1",
        "categoria_recordatorio": "Importante"
        }
         */

        var queue = Volley.newRequestQueue(this.requireContext())


        val listener = Response.Listener<JSONObject> { response ->
            Log.e("RESTLIBS", response.toString())
        }

        val error = Response.ErrorListener { error ->
            Log.e("RESTLIBS", error.message!!)
        }

        val body = JSONObject()

        // Agregar elementos a la lista
        Thread{
            val list = db.recordatorioDao().obtenerRecordatorios()
            for (i in 0 until list.size) {
                val recordatorio = list[i]
                //val recordatorioJson = JSONObject()
                body.put("nombre_recordatorio", recordatorio.titulo)
                body.put("info_recordatorio", recordatorio.descripcion)
                body.put("categoria_recordatorio", recordatorio.categoria)
                Log.e("RESTLIBS", body.toString())
                val JsonArrayRequest = JsonObjectRequest(Request.Method.POST, url, body, listener, error)
                queue.add(JsonArrayRequest) // Agregar la petición a la cola -> Se planea la ejecución
            }
        }.start()

        // Borrar elementos de la base de datos local
        Thread{
            db.recordatorioDao().borrarRecordatorios()
        }.start()



    }
}