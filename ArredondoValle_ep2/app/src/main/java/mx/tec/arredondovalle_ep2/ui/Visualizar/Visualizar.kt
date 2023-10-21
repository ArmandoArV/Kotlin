package mx.tec.arredondovalle_ep2.ui.Visualizar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import mx.tec.arredondovalle_ep2.R
import mx.tec.arredondovalle_ep2.utility.AppDatabase

class Visualizar : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_visualizar, container, false)
        val listView = view.findViewById<ListView>(R.id.lvlista)

        val db = AppDatabase.getInstance(requireContext())

        Thread {
            val list = db.ReminderDao().getAll()

            activity?.runOnUiThread {
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, list)
                listView.adapter = adapter
            }
        }.start()

        return view
    }
}
