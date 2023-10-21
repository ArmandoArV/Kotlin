package mx.tec.fragments.ui.header

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import mx.tec.fragments.R

class Header : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_header, container,false)
        val txtHeader = view.findViewById<TextView>(R.id.txtTextHeader)
        txtHeader.text = "Header"
        return view
    }
}