package mx.tec.customlayout.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import mx.tec.customlayout.R
import mx.tec.customlayout.model.Elemento

// Un adapter necesita: contexto, layout, datos

class CustomAdapter(val context: Context, val layout: Int, val datos: List<Elemento>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(position: Int): Any {
        return datos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = inflater.inflate(layout, parent, false)
        val imgSample = view.findViewById<ImageView>(R.id.imgSample)
        val textHeader = view.findViewById<TextView>(R.id.textHeader)
        val textDesc = view.findViewById<TextView>(R.id.textDesc)

        imgSample.setImageResource(datos[position].imagen)
        textHeader.text = datos[position].name
        textDesc.text = datos[position].description

        return view

    }
}