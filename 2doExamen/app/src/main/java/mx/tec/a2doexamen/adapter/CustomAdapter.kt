package mx.tec.a2doexamen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.tec.a2doexamen.R
import mx.tec.a2doexamen.model.Recordatorio

class CustomAdapter(
    val context: Context,
    val layout: Int,
    val dataSource: List<Recordatorio>
): RecyclerView.Adapter<CustomAdapter.RecordatorioViewHolder>() {
    class RecordatorioViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        layout: Int
    ): RecyclerView.ViewHolder(inflater.inflate(layout, parent, false)) {
        var titulo: TextView? = null
        var descripcion: TextView? = null
        var categoria: TextView? = null

        init {
            titulo = itemView.findViewById(R.id.txtTitle) as TextView
            descripcion = itemView.findViewById(R.id.txtDes) as TextView
            categoria = itemView.findViewById(R.id.txtCategory) as TextView
        }

        fun bind(recordatorio: Recordatorio) {
            titulo!!.text = recordatorio.titulo
            descripcion!!.text = recordatorio.descripcion
            categoria!!.text = recordatorio.categoria
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordatorioViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RecordatorioViewHolder(inflater, parent, layout)
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindViewHolder(holder: RecordatorioViewHolder, position: Int) {
        val recordatorio = dataSource[position]
        holder.bind(recordatorio)
    }

}