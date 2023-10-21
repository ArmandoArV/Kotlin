package mx.tec.fragment.ui.encabezado

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import mx.tec.fragment.R

class Encabezado: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view: View = inflater.inflate(R.layout.fragment_encabezado, container, false)
        val txtTextoEncabezado = view.findViewById<TextView>(R.id.txtTextoEncabezado)
        txtTextoEncabezado.text = "Encabezado"

        return view
    }
}