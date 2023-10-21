package mx.tec.arredondovalle_ep2.ui.Sync;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import mx.tec.arredondovalle_ep2.R
import mx.tec.arredondovalle_ep2.model.Reminder
import mx.tec.arredondovalle_ep2.utility.AppDatabase
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class Sync : Fragment() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view: View = inflater.inflate(R.layout.fragment_sync, container, false)
        val db = AppDatabase.getInstance(requireContext())
        val queue = Volley.newRequestQueue(requireContext())
        val remoteUrl =
            "http://laventana-env-1.eba-4xgdujcc.us-east-1.elasticbeanstalk.com/recordatorios"

        // Define a method for synchronizing data
        val syncData = {
            val stringRequest = StringRequest(
                Request.Method.GET, remoteUrl,
                { response ->
                    Log.d("RESPONSE", "Response: $response")
                    try {
                        val list = parseResponse(response)

                        GlobalScope.launch(Dispatchers.IO) {
                            for (item in list) {
                                db.ReminderDao().registrarReminder(item)
                            }
                        }
                    } catch (e: Exception) {
                        Log.e("ERROR", "Error processing response: ${e.message}")
                    }
                },
                { error ->
                    Log.e("ERROR", "Error in the request: ${error.message}")
                }
            )
            queue.add(stringRequest)
        }

        val syncButton = view.findViewById<View>(R.id.btnSync2)
        syncButton.setOnClickListener {
            syncData()
        }

        return view
    }

    private fun parseResponse(response: String): List<Reminder> {
        val list = mutableListOf<Reminder>()

        try {
            val jsonObject = JSONObject(response)
            val recordatoriosArray = jsonObject.getJSONArray("recordatorios")

            for (i in 0 until recordatoriosArray.length()) {
                val recordatorioObject = recordatoriosArray.getJSONObject(i)
                val id = recordatorioObject.getInt("id_recordatorio")
                val title = recordatorioObject.getString("nombre_recordatorio")
                val description = recordatorioObject.getString("info_recordatorio")
                val category = recordatorioObject.getString("categoria_recordatorio")

                val reminder = Reminder(id, title, description, category)
                list.add(reminder)
            }
        } catch (e: JSONException) {
            Log.e("JSON Parsing Error", "Error parsing JSON: ${e.message}")
        }

        return list
    }

}
