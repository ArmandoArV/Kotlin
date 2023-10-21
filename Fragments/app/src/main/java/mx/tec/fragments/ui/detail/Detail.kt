package mx.tec.fragments.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import mx.tec.fragments.R

class Detail : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_detail, container,false)
        val txtHeader = view.findViewById<TextView>(R.id.txtDetail)
        txtHeader.text = "Header"
        return view
    }
}