package mx.tec.a2doexamen.ui.NuevoRec

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import mx.tec.a2doexamen.R
import mx.tec.a2doexamen.model.Recordatorio
import mx.tec.a2doexamen.utility.AppDatabase

class NuevoRec: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view: View = inflater.inflate(R.layout.fragment_nuevorec, container, false)

        val db = AppDatabase.getInstance(this.requireContext()) // Inicializar base de datos

        // Crear array de categorias
        val categorias = arrayOf("Importante", "Irrelevante", "Casual")

        // Agregar elementos al spinner
        val spinner = view.findViewById<Spinner>(R.id.spnCat)
        spinner.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categorias)

        // Agregar listener al boton
        val btnAgregar = view.findViewById<View>(R.id.btnGuardar)
        btnAgregar.setOnClickListener{
            val Titulo = view.findViewById<TextView>(R.id.edtTitulo)
            val Descripcion = view.findViewById<TextView>(R.id.edtDescripcion)
            val Categoria = view.findViewById<Spinner>(R.id.spnCat)

            val Recordatorio = Recordatorio(0,Titulo.text.toString(), Descripcion.text.toString(), Categoria.selectedItem.toString())

            Toast.makeText(requireContext(), "Recordatorio registrado", Toast.LENGTH_SHORT).show()

            Titulo.text = ""
            Descripcion.text = ""
            Categoria.setSelection(0)

            Thread{
                db.recordatorioDao().registrarRecordatorio(Recordatorio)
            }.start()
        }

        return view
    }
}