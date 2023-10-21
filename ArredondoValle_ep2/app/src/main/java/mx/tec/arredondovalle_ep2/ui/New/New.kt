package mx.tec.arredondovalle_ep2.ui.New

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import mx.tec.arredondovalle_ep2.R
import mx.tec.arredondovalle_ep2.model.Reminder
import mx.tec.arredondovalle_ep2.utility.AppDatabase

class New : Fragment() {
    private lateinit var edtTitle: EditText
    private lateinit var edtDescription: EditText
    private lateinit var btnSave: Button
    private lateinit var spnCategories: Spinner

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_new, container, false)

        edtTitle = view.findViewById(R.id.edtTitle)
        edtDescription = view.findViewById(R.id.edtDescription)
        btnSave = view.findViewById(R.id.btnSave)
        spnCategories = view.findViewById(R.id.spnCategories)

        val opciones = listOf(
            "Importante",
            "Útil",
            "Irrelevante",
            "Casual",
        )

        val db = AppDatabase.getInstance(requireContext())

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, opciones)
        spnCategories.adapter = adapter

        btnSave.setOnClickListener {
            val title = edtTitle.text.toString()
            val description = edtDescription.text.toString()
            val category = spnCategories.selectedItem.toString()
            val reminder = Reminder(0, title, description, category)

            Thread {
                db?.ReminderDao()?.registrarReminder(reminder)
            }.start()
        }

        return view
    }
}
