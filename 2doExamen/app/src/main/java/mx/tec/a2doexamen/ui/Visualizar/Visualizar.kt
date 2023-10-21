package mx.tec.a2doexamen.ui.Visualizar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mx.tec.a2doexamen.R
import mx.tec.a2doexamen.adapter.CustomAdapter
import mx.tec.a2doexamen.model.Recordatorio
import mx.tec.a2doexamen.utility.AppDatabase
import org.json.JSONObject

class Visualizar : Fragment() {
    lateinit var rvList : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view: View = inflater.inflate(R.layout.fragment_visualizar, container, false)

        rvList = view.findViewById(R.id.rvLista)
        val db = AppDatabase.getInstance(this.requireContext())
        val queue = Volley.newRequestQueue(this.requireContext())

        val url = "http://laventana-env-1.eba-4xgdujcc.us-east-1.elasticbeanstalk.com/recordatorios"
        val list = mutableListOf<Recordatorio>()

        val listener = Response.Listener<JSONObject> { response ->
                val item = response.getJSONArray("recordatorios")
                for (j in 0 until item.length()) {
                    val recordatorio = Recordatorio(
                        item.getJSONObject(j).getInt("id_recordatorio"),
                        item.getJSONObject(j).getString("nombre_recordatorio"),
                        item.getJSONObject(j).getString("info_recordatorio"),
                        item.getJSONObject(j).getString("categoria_recordatorio")
                    )
                    list.add(recordatorio)
                }
            Combinacion(db, list)
        }


        val error = Response.ErrorListener { error ->
            //Log.e("RESTLIBS", error.message!!)
        }

        val jsonArrayRequest = JsonObjectRequest(Request.Method.GET, url, null, listener, error)
        queue.add(jsonArrayRequest) // Agregar la petición a la cola -> Se planea la ejecución

        return view
    }

    @OptIn(DelicateCoroutinesApi::class) // Para que no marque error en la funcion Thread.sleep()
    private fun Combinacion(db: AppDatabase, list: MutableList<Recordatorio>){
        GlobalScope.launch(Dispatchers.IO){
            val listaLocal = db.recordatorioDao().obtenerRecordatorios()
            val listaCombinada = mutableListOf<Recordatorio>()
            listaCombinada.addAll(listaLocal)
            listaCombinada.addAll(list)

            withContext(Dispatchers.Main){
                rvList.apply {
                    layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = CustomAdapter(requireActivity(), R.layout.recordatorio, listaCombinada)
                }
            }

        }

    }
}