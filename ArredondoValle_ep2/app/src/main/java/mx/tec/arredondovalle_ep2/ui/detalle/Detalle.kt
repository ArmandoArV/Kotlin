package mx.tec.arredondovalle_ep2.ui.detalle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import mx.tec.arredondovalle_ep2.R
import mx.tec.arredondovalle_ep2.utility.AppDatabase

class Detalle : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view: View = inflater.inflate(R.layout.fragment_new, container, false)
        return view
    }
}